package com.synkers.quickblox.api;

import com.synkers.quickblox.exception.AuthenticationException;
import com.synkers.quickblox.model.User;
import com.synkers.quickblox.model.UserRequest;
import com.synkers.quickblox.model.UserResponse;
import com.synkers.quickblox.module.Users;
import com.synkers.quickblox.util.QuickBlox;
import com.synkers.quickblox.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class QbUsersApi {
    private Users users;
    private UsersCallback usersCallback;

    public QbUsersApi() throws AuthenticationException {
        RetrofitUtil<Users> retrofitUtil = new RetrofitUtil<Users>();
        if (QuickBlox.getAuthToken() != null) {
            retrofitUtil.addHeader(QuickBlox.HEADER_TOKEN_KEY, QuickBlox.getAuthToken());
        } else {
            throw new AuthenticationException("Need to be authenticated");
        }
        users = (Users) retrofitUtil.create(Users.class);
    }

    public interface UsersCallback {
        void onSuccess(User user);

        void onFailure(String reason);
    }

    public void signUp(User user, final UsersCallback usersCallback) {
        this.usersCallback = usersCallback;
        UserRequest userRequest = new UserRequest(user);
        users.signUp(userRequest).enqueue(responseHandler);
    }

    public void getUserById(String id, final UsersCallback usersCallback) {
        this.usersCallback = usersCallback;
        users.getUserByIdentifier(id).enqueue(responseHandler);
    }

    public void updateUserPassword(User user, String oldPassword, String password, final UsersCallback usersCallback) {
        this.usersCallback = usersCallback;
        user.setPassword(password);
        user.setOld_password(oldPassword);
        users.updateUser(user.getId(), new UserRequest(user)).enqueue(responseHandler);
    }

    private Callback<UserResponse> responseHandler = new Callback<UserResponse>() {
        public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
            if (response.isSuccessful()) {
                usersCallback.onSuccess(response.body().getUser());
            } else {
                try {
                    usersCallback.onFailure("Response Code:" + response.code() + " " + "Response Body:" + response.errorBody().string());
                } catch (IOException e) {
                    usersCallback.onFailure("Error getting response body" + e.toString());
                }
            }
        }

        public void onFailure(Call<UserResponse> call, Throwable throwable) {
            usersCallback.onFailure(throwable.toString());
        }
    };
}