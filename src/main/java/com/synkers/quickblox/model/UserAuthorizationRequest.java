package com.synkers.quickblox.model;

import com.synkers.quickblox.util.Hmac;
import com.synkers.quickblox.util.Nonce;
import com.synkers.quickblox.util.Timestamp;

public class UserAuthorizationRequest {
    private String timestamp;
    private String nonce;
    private String application_id;
    private User user;
    private String auth_key;
    private String signature;

    public UserAuthorizationRequest(String application_id, String auth_key, String auth_secret, User user) {
        this.application_id = application_id;
        this.auth_key = auth_key;
        this.timestamp = Timestamp.generateTimestamp();
        this.nonce = Nonce.generateNonce();
        this.user = user;
        this.signature = Hmac.hmacSha1("application_id=" + application_id + "&auth_key=" + auth_key +
                "&nonce=" + nonce + "&timestamp=" + timestamp + "&user[login]=" + user.getLogin() +
                "&user[password]=" + user.getPassword(), auth_secret);
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuth_key() {
        return auth_key;
    }

    public void setAuth_key(String auth_key) {
        this.auth_key = auth_key;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "UserAuthorizationRequest{" +
                "timestamp='" + timestamp + '\'' +
                ", nonce='" + nonce + '\'' +
                ", application_id='" + application_id + '\'' +
                ", user=" + user +
                ", auth_key='" + auth_key + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}