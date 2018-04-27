package com.synkers.quickblox.module;

import com.synkers.quickblox.model.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface Chat {
    @POST("/chat/Dialog.json")
    Call<Dialog> createDialog(@Body DialogCreationRequest dialogCreationRequest);

    @GET("/chat/Dialog.json")
    Call<Dialogs> filterDialogByCustomData(@QueryMap Map<String, String> options);

    @GET("/chat/Dialog.json")
    Call<Dialogs> getDialogs();

    @PUT("/chat/Dialog/{dialogId}.json")
    Call<Dialog> updateDialog(@Path("dialogId") String dialogId, @Body DialogDataUpdateFields dialogUpdateFields);

    @GET("/chat/Message.json")
    Call<Messages> getMessages(@Query("chat_dialog_id") String chatDialogId);
}