package com.synkers.quickblox.model;

public class Session {
    private String id;
    private String updated_at;
    private String ts;
    private String token;
    private String nonce;
    private String created_at;
    private String user_id;
    private String device_id;
    private String application_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", ts='" + ts + '\'' +
                ", token='" + token + '\'' +
                ", nonce='" + nonce + '\'' +
                ", created_at='" + created_at + '\'' +
                ", user_id='" + user_id + '\'' +
                ", device_id='" + device_id + '\'' +
                ", application_id='" + application_id + '\'' +
                '}';
    }
}