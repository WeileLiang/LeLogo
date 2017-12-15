package com.liang.lelogo.entity;

/**
 * Created by ASUS on 2017/11/8.
 */

public class WeiboContent {

    private String text;
    private User user;
    private String created_at;
    public void setText(String text) {
        this.text = text;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    public String getCreated_at() {
        return created_at;
    }
}
