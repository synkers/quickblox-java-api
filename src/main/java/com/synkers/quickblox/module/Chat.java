package com.synkers.quickblox.module;

import com.synkers.quickblox.model.DialogCreationRequest;
import com.synkers.quickblox.model.DialogCreationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Chat {
    @POST("/chat/Dialog.json")
    Call<DialogCreationResponse> createDialog(@Body DialogCreationRequest dialogCreationRequest);
}