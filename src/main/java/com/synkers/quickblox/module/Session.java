package com.synkers.quickblox.module;

import com.synkers.quickblox.model.UserAuthorizationRequest;
import com.synkers.quickblox.model.UserAuthorizationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Session {
    @POST("/session.json")
    Call<UserAuthorizationResponse> getUserAuthorization(@Body UserAuthorizationRequest userAuthorizationRequest);
}