package com.synkers.quickblox.util;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest<T> {
    private String url;
    private HashMap<String, String> headers = new HashMap<String, String>();
    private RequestType requestType;
    private Class<T> type;
    private String body;

    private HttpRequest(Builder builder, Class<T> type) {
        this.url = builder.url;
        this.headers = builder.headers;
        this.requestType = builder.requestType;
        this.type = type;
        this.body = builder.body;
    }

    public static class Builder<T> {
        private String url;
        private HashMap<String, String> headers = new HashMap<String, String>();
        private RequestType requestType;
        private Class<T> type;
        private String body;

        public Builder(Class<T> type) {
            this.type = type;
        }

        public Builder<T> setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder<T> setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder<T> addHeader(String headerName, String headerValue) {
            this.headers.put(headerName, headerValue);
            return this;
        }

        public Builder<T> setRequestTpe(RequestType requestType) {
            this.requestType = requestType;
            return this;
        }

        public HttpRequest<T> build() {
            return new HttpRequest<T>(this, type);
        }
    }

    public void execute(Callback<T> callback) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(getUrl());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestType.getType());
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", Integer.toString(body.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(body);
            wr.close();

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            Gson gson = new Gson();
            callback.onSuccess(gson.fromJson(response.toString(), type));
        } catch (Exception e) {
            callback.onFailure(e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private String getUrl() {
        return url;
    }

    public interface Callback<T> {
        void onSuccess(T responseBody);

        void onFailure(Exception e);
    }

    public enum RequestType {
        POST("POST"), GET("GET"), PUT("PUT");

        String type;

        RequestType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
