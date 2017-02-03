package com.synkers.quickblox.module;

import com.synkers.quickblox.model.UserRequest;
import com.synkers.quickblox.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface Users {
    @POST("/users.json")
    Call<UserResponse> signUp(@Body UserRequest userRequest);

    @PUT("/users/{userId}.json")
    Call<UserResponse> updateUser(@Path("userId") String userId, @Body UserRequest userRequest);

    @GET("/users/{userId}.json")
    Call<UserResponse> getUserByIdentifier(@Path("userId") String userId);
}