package com.synkers.quickblox.api;

import com.synkers.quickblox.exception.AuthenticationException;
import com.synkers.quickblox.model.DialogCreationRequest;
import com.synkers.quickblox.model.DialogCreationResponse;
import com.synkers.quickblox.module.Chat;
import com.synkers.quickblox.module.Users;
import com.synkers.quickblox.util.QuickBlox;
import com.synkers.quickblox.util.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class QbChatApi {
    private Chat chat;
    private ChatCallback chatCallback;

    public QbChatApi() throws AuthenticationException {
        RetrofitUtil<Users> retrofitUtil = new RetrofitUtil<Users>();
        if (QuickBlox.getAuthToken() != null) {
            retrofitUtil.addHeader(QuickBlox.HEADER_TOKEN_KEY, QuickBlox.getAuthToken());
        } else {
            throw new AuthenticationException("Need to be authenticated");
        }
        chat = (Chat) retrofitUtil.create(Chat.class);
    }

    public interface ChatCallback {
        void onSuccess(DialogCreationResponse dialogCreationResponse);

        void onFailure(String reason);
    }

    public void createChatDialog(DialogCreationRequest dialogCreationRequest, final ChatCallback chatCallback) {
        this.chatCallback = chatCallback;
        chat.createDialog(dialogCreationRequest).enqueue(responseHandler);
    }

    private Callback<DialogCreationResponse> responseHandler = new Callback<DialogCreationResponse>() {
        public void onResponse(Call<DialogCreationResponse> call, Response<DialogCreationResponse> response) {
            if (response.isSuccessful()) {
                chatCallback.onSuccess(response.body());
            } else {
                try {
                    chatCallback.onFailure("Response Code:" + response.code() + " " + "Response Body:" + response.errorBody().string());
                } catch (IOException e) {
                    chatCallback.onFailure("Error getting response body" + e.toString());
                }
            }
        }

        public void onFailure(Call<DialogCreationResponse> call, Throwable throwable) {
            chatCallback.onFailure(throwable.toString());
        }
    };
}