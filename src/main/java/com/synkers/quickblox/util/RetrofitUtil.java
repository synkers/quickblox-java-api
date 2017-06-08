package com.synkers.quickblox.util;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RetrofitUtil<E> {
    private Map<String, String> headers = new HashMap<String, String>();

    private Retrofit.Builder getBuilder() {
        return new Retrofit.Builder()
                .baseUrl(QuickBlox.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
    }

    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    public void putHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Object create(Class<?> clazz) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder builder = original.newBuilder();
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    builder.header(entry.getKey(), entry.getValue());
                }
                Request request = builder.method(original.method(), original.body()).build();
                return chain.proceed(request);
            }
        });
        return getBuilder().client(httpClient.build()).build().create(clazz);
    }
}