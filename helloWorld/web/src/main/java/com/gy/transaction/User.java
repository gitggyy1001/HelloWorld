package com.gy.transaction;

import java.io.Serializable;

/**
 * Created by hello on 2018/5/22.
 */
public class User implements Serializable{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
