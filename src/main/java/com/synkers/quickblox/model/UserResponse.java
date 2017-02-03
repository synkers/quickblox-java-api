package com.synkers.quickblox.model;

public class UserResponse {
    private User user;

    public UserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}