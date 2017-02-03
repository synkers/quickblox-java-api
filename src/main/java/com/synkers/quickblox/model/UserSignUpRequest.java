package com.synkers.quickblox.model;

public class UserSignUpRequest {
    private User user;

    public UserSignUpRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}