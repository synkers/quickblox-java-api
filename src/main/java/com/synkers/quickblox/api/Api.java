package com.synkers.quickblox.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class Api {

    public interface QbCallback<T> {
        void onSuccess(T t);

        void onFailure(String reason);
    }

    <T> Callback<T> getResponseHandler(final QbCallback<T> qbCallback) {
        return new Callback<T>() {
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()) {
                    qbCallback.onSuccess(response.body());
                } else {
                    try {
                        qbCallback.onFailure("Response Code:" + response.code() + " " + "Response Body:" + response.errorBody().string());
                    } catch (IOException e) {
                        qbCallback.onFailure("Error getting response body" + e.toString());
                    }
                }
            }

            public void onFailure(Call<T> call, Throwable throwable) {
                qbCallback.onFailure(throwable.toString());
            }
        };
    }
}