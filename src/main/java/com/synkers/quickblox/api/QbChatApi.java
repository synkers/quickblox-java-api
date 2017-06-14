package com.synkers.quickblox.api;

import com.synkers.quickblox.exception.AuthenticationException;
import com.synkers.quickblox.model.*;
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
    private DialogCallback dialogCallback;
    private DialogListCallback dialogListCallback;

    public QbChatApi() throws AuthenticationException {
        RetrofitUtil<Users> retrofitUtil = new RetrofitUtil<Users>();
        if (QuickBlox.getAuthToken() != null) {
            retrofitUtil.addHeader(QuickBlox.HEADER_TOKEN_KEY, QuickBlox.getAuthToken());
        } else {
            throw new AuthenticationException("Need to be authenticated");
        }
        chat = (Chat) retrofitUtil.create(Chat.class);
    }

    public interface DialogCallback {
        void onSuccess(Dialog dialog);

        void onFailure(String reason);
    }

    public interface DialogListCallback {
        void onSuccess(Dialogs dialog);

        void onFailure(String reason);
    }

    public void createDialog(DialogCreationRequest dialogCreationRequest, final DialogCallback dialogCallback) {
        this.dialogCallback = dialogCallback;
        chat.createDialog(dialogCreationRequest).enqueue(responseHandler);
    }

    public void updateDialog(String dialogId, DialogDataUpdateFields dialogUpdateFields, final DialogCallback dialogCallback) {
        this.dialogCallback = dialogCallback;
        chat.updateDialog(dialogId, dialogUpdateFields).enqueue(responseHandler);
    }

    public void getDialogs(DialogFilter dialogFilter, final DialogListCallback dialogListCallback) {
        this.dialogListCallback = dialogListCallback;
        chat.filterDialogByCustomData(dialogFilter.assemble()).enqueue(new Callback<Dialogs>() {
            public void onResponse(Call<Dialogs> call, Response<Dialogs> response) {
                if (response.isSuccessful()) {
                    dialogListCallback.onSuccess(response.body());
                } else {
                    try {
                        dialogListCallback.onFailure("Response Code:" + response.code() + " " + "Response Body:" + response.errorBody().string());
                    } catch (IOException e) {
                        dialogListCallback.onFailure("Error getting response body" + e.toString());
                    }
                }
            }

            public void onFailure(Call<Dialogs> call, Throwable throwable) {
                dialogListCallback.onFailure(throwable.toString());
            }
        });
    }

    public void getDialogs(final DialogListCallback dialogListCallback) {
        this.dialogListCallback = dialogListCallback;
        chat.getDialogs().enqueue(new Callback<Dialogs>() {
            public void onResponse(Call<Dialogs> call, Response<Dialogs> response) {
                if (response.isSuccessful()) {
                    dialogListCallback.onSuccess(response.body());
                } else {
                    try {
                        dialogListCallback.onFailure("Response Code:" + response.code() + " " + "Response Body:" + response.errorBody().string());
                    } catch (IOException e) {
                        dialogListCallback.onFailure("Error getting response body" + e.toString());
                    }
                }
            }

            public void onFailure(Call<Dialogs> call, Throwable throwable) {
                dialogListCallback.onFailure(throwable.toString());
            }
        });
    }

    private Callback<Dialog> responseHandler = new Callback<Dialog>() {
        public void onResponse(Call<Dialog> call, Response<Dialog> response) {
            if (response.isSuccessful()) {
                dialogCallback.onSuccess(response.body());
            } else {
                try {
                    dialogCallback.onFailure("Response Code:" + response.code() + " " + "Response Body:" + response.errorBody().string());
                } catch (IOException e) {
                    dialogCallback.onFailure("Error getting response body" + e.toString());
                }
            }
        }

        public void onFailure(Call<Dialog> call, Throwable throwable) {
            dialogCallback.onFailure(throwable.toString());
        }
    };
}