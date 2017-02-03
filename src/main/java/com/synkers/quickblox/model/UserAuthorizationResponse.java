package com.synkers.quickblox.model;

public class UserAuthorizationResponse {
    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "UserAuthorizationResponse{" +
                "session=" + session +
                '}';
    }
}