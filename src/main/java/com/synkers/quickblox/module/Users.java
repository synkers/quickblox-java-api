package com.synkers.quickblox.module;

import com.synkers.quickblox.model.UserRequest;
import com.synkers.quickblox.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Users {
    @POST("/users.json")
    Call<UserResponse> signUp(@Body UserRequest userRequest);

    @PUT("/users/{userId}.json")
    Call<UserResponse> updateUser(@Path("userId") String userId, @Body UserRequest userRequest);
}