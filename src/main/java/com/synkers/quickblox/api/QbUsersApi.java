package com.synkers.quickblox.api;

import com.synkers.quickblox.exception.AuthenticationException;
import com.synkers.quickblox.model.User;
import com.synkers.quickblox.model.UserRequest;
import com.synkers.quickblox.model.UserResponse;
import com.synkers.quickblox.module.Users;
import com.synkers.quickblox.util.QuickBlox;
import com.synkers.quickblox.util.RetrofitUtil;

public class QbUsersApi extends Api {
    private Users users;

    public QbUsersApi() throws AuthenticationException {
        RetrofitUtil<Users> retrofitUtil = new RetrofitUtil<Users>();
        if (QuickBlox.getAuthToken() != null) {
            retrofitUtil.addHeader(QuickBlox.HEADER_TOKEN_KEY, QuickBlox.getAuthToken());
        } else {
            throw new AuthenticationException("Need to be authenticated");
        }
        users = (Users) retrofitUtil.create(Users.class);
    }

    public void signUp(User user, final Api.QbCallback<UserResponse> callback) {
        UserRequest userRequest = new UserRequest(user);
        users.signUp(userRequest).enqueue(getResponseHandler(callback));
    }

    public void getUserById(String id, final Api.QbCallback<UserResponse> callback) {
        users.getUserByIdentifier(id).enqueue(getResponseHandler(callback));
    }

    public void updateUserPassword(User user, String oldPassword, String password, final Api.QbCallback<UserResponse> callback) {
        user.setPassword(password);
        user.setOld_password(oldPassword);
        users.updateUser(user.getId(), new UserRequest(user)).enqueue(getResponseHandler(callback));
    }
}