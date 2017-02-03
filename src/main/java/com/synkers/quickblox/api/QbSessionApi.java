package com.synkers.quickblox.api;

import com.synkers.quickblox.model.User;
import com.synkers.quickblox.model.UserAuthorizationRequest;
import com.synkers.quickblox.model.UserAuthorizationResponse;
import com.synkers.quickblox.module.Session;
import com.synkers.quickblox.util.QuickBlox;
import com.synkers.quickblox.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QbSessionApi {
    private Session session;

    public QbSessionApi() {
        RetrofitUtil<Session> retrofitUtil = new RetrofitUtil<Session>();
        session = (Session) retrofitUtil.create(Session.class);
    }

    public interface SessionCallback {
        void onSuccess(com.synkers.quickblox.model.Session session);

        void onFailure();
    }

    public void getUserAuthorization(final SessionCallback sessionCallback) {
        UserAuthorizationRequest userAuthorizationRequest = new UserAuthorizationRequest(QuickBlox.APPLICATION_ID,
                QuickBlox.AUTH_KEY, QuickBlox.AUTH_SECRET, new User(QuickBlox.LOGIN, QuickBlox.PASSWORD));
        session.getUserAuthorization(userAuthorizationRequest).enqueue(new Callback<UserAuthorizationResponse>() {
            public void onResponse(Call<UserAuthorizationResponse> call, Response<UserAuthorizationResponse> response) {
                if (response.isSuccessful()) {
                    QuickBlox.authToken = response.body().getSession().getToken();
                    sessionCallback.onSuccess(response.body().getSession());
                } else {
                    sessionCallback.onFailure();
                }
            }

            public void onFailure(Call<UserAuthorizationResponse> call, Throwable throwable) {
                sessionCallback.onFailure();
            }
        });
    }
}