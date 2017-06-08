package com.synkers.quickblox.util;

import com.synkers.quickblox.api.QbChatApi;
import com.synkers.quickblox.api.QbSessionApi;
import com.synkers.quickblox.api.QbUsersApi;
import com.synkers.quickblox.exception.AuthenticationException;

public class QuickBlox {
    public static final String API_BASE_URL = "https://api.quickblox.com/";
    public static final String HEADER_TOKEN_KEY = "QB-Token";
    public static String APPLICATION_ID;
    public static String AUTH_KEY;
    public static String AUTH_SECRET;
    public static String LOGIN;
    public static String PASSWORD;
    public static String authToken;

    public static void init(String applicationId, String authKey, String authSecret, String login, String password) {
        QuickBlox.APPLICATION_ID = applicationId;
        QuickBlox.AUTH_KEY = authKey;
        QuickBlox.AUTH_SECRET = authSecret;
        QuickBlox.LOGIN = login;
        QuickBlox.PASSWORD = password;
    }

    public static String getAuthToken() {
        return authToken;
    }

    public static QbSessionApi getSessionApi() {
        return new QbSessionApi();
    }

    public static QbUsersApi getUsersApi() throws AuthenticationException {
        return new QbUsersApi();
    }

    public static QbChatApi getChatApi() throws AuthenticationException {
        return new QbChatApi();
    }
}