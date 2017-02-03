package com.synkers.quickblox.api;

import com.synkers.quickblox.exception.AuthenticationException;
import com.synkers.quickblox.model.User;
import com.synkers.quickblox.model.UserSignUpRequest;
import com.synkers.quickblox.model.UserSignUpResponse;
import com.synkers.quickblox.module.Users;
import com.synkers.quickblox.util.QuickBlox;
import com.synkers.quickblox.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class QbUsersApi {
    private Users users;

    public QbUsersApi() throws AuthenticationException {
        RetrofitUtil<Users> retrofitUtil = new RetrofitUtil<Users>();
        if (QuickBlox.getAuthToken() != null) {
            retrofitUtil.addHeader(QuickBlox.TOKEN_KEY, QuickBlox.getAuthToken());
        } else {
            throw new AuthenticationException("Need to be authenticated");
        }
        users = (Users) retrofitUtil.create(Users.class);
    }

    public interface SignUpCallback {
        void onSuccess(User user);

        void onFailure(String reason);
    }

    public void signUp(User user, final SignUpCallback signUpCallback) {
        UserSignUpRequest userSignUpRequest = new UserSignUpRequest(user);
        users.signUp(userSignUpRequest).enqueue(new Callback<UserSignUpResponse>() {
            public void onResponse(Call<UserSignUpResponse> call, Response<UserSignUpResponse> response) {
                if (response.isSuccessful()) {
                    signUpCallback.onSuccess(response.body().getUser());
                } else {
                    try {
                        signUpCallback.onFailure("Response Code:" + response.code() + " " + "Response Body:" + response.errorBody().string());
                    } catch (IOException e) {
                        signUpCallback.onFailure("Error getting response body" + e.toString());
                    }
                }
            }

            public void onFailure(Call<UserSignUpResponse> call, Throwable throwable) {
                signUpCallback.onFailure("Failed");
            }
        });
    }
}