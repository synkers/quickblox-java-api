package com.synkers.quickblox.module;

import com.synkers.quickblox.model.UserSignUpRequest;
import com.synkers.quickblox.model.UserSignUpResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Users {
    @POST("/users.json")
    Call<UserSignUpResponse> signUp(@Body UserSignUpRequest userSignUpRequest);
}