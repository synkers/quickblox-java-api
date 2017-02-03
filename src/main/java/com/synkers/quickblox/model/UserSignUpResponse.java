package com.synkers.quickblox.model;

public class UserSignUpResponse {
    private User user;

    public UserSignUpResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}