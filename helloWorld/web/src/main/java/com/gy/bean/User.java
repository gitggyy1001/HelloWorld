package com.gy.bean;

import java.io.Serializable;

/**
 * Created by hello on 2018/3/30.
 */
public class User implements Serializable {
    String userName;
    Integer userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
