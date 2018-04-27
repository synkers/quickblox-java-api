package com.synkers.quickblox.api;

import com.synkers.quickblox.exception.AuthenticationException;
import com.synkers.quickblox.model.*;
import com.synkers.quickblox.module.Chat;
import com.synkers.quickblox.module.Users;
import com.synkers.quickblox.util.QuickBlox;
import com.synkers.quickblox.util.RetrofitUtil;

public class QbChatApi extends Api {
    private Chat chat;

    public QbChatApi() throws AuthenticationException {
        RetrofitUtil<Users> retrofitUtil = new RetrofitUtil<Users>();
        if (QuickBlox.getAuthToken() != null) {
            retrofitUtil.addHeader(QuickBlox.HEADER_TOKEN_KEY, QuickBlox.getAuthToken());
        } else {
            throw new AuthenticationException("Need to be authenticated");
        }
        chat = (Chat) retrofitUtil.create(Chat.class);
    }

    public void createDialog(DialogCreationRequest dialogCreationRequest, final QbCallback<Dialog> callback) {
        chat.createDialog(dialogCreationRequest).enqueue(getResponseHandler(callback));
    }

    public void updateDialog(String dialogId, DialogDataUpdateFields dialogUpdateFields, final QbCallback<Dialog> callback) {
        chat.updateDialog(dialogId, dialogUpdateFields).enqueue(getResponseHandler(callback));
    }

    public void getDialogs(DialogFilter dialogFilter, final QbCallback<Dialogs> callback) {
        chat.filterDialogByCustomData(dialogFilter.assemble()).enqueue(getResponseHandler(callback));
    }

    public void getDialogs(final QbCallback<Dialogs> callback) {
        chat.getDialogs().enqueue(getResponseHandler(callback));
    }

    public void getMessages(Dialog dialog, final QbCallback<Messages> callback) {
        chat.getMessages(dialog.getId()).enqueue(getResponseHandler(callback));
    }
}