package com.synkers.quickblox.model;

public class User {
    private String id;
    private String login;
    private String password;
    private String twitter_id;
    private String phone;
    private String tag_list;
    private String website;
    private String email;
    private String facebook_id;
    private String external_user_id;
    private String full_name;

    public User(String login, String email, String full_name, String password) {
        this.login = login;
        this.email = email;
        this.full_name = full_name;
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTwitter_id() {
        return twitter_id;
    }

    public void setTwitter_id(String twitter_id) {
        this.twitter_id = twitter_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTag_list() {
        return tag_list;
    }

    public void setTag_list(String tag_list) {
        this.tag_list = tag_list;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
    }

    public String getExternal_user_id() {
        return external_user_id;
    }

    public void setExternal_user_id(String external_user_id) {
        this.external_user_id = external_user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", twitter_id='" + twitter_id + '\'' +
                ", phone='" + phone + '\'' +
                ", tag_list='" + tag_list + '\'' +
                ", website='" + website + '\'' +
                ", email='" + email + '\'' +
                ", facebook_id='" + facebook_id + '\'' +
                ", external_user_id='" + external_user_id + '\'' +
                ", full_name='" + full_name + '\'' +
                '}';
    }
}