package com.synkers.quickblox.module;

import com.synkers.quickblox.model.Dialog;
import com.synkers.quickblox.model.DialogCreationRequest;
import com.synkers.quickblox.model.DialogDataUpdateFields;
import com.synkers.quickblox.model.Dialogs;
import retrofit2.Call;
import retrofit2.http.*;

public interface Chat {
    @POST("/chat/Dialog.json")
    Call<Dialog> createDialog(@Body DialogCreationRequest dialogCreationRequest);

    @GET("/chat/Dialog.json")
    Call<Dialogs> filterDialogByCustomData();

    @PUT("/chat/Dialog/{dialogId}.json")
    Call<Dialog> updateDialog(@Path("dialogId") String dialogId, @Body DialogDataUpdateFields dialogUpdateFields);
}