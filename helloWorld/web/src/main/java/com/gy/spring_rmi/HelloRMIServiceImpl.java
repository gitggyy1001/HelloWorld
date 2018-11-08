package com.gy.spring_rmi;

import com.gy.bean.User;

/**
 * Created by hello on 2018/3/30.
 */
public class HelloRMIServiceImpl implements  HelloRMIService{
    @Override
    public User getUser(Integer userId) {
        User u = new User();
        u.setUserId(userId);
        u.setUserName("ggyy");
        System.out.println("httpinvoker-server");
        return u;
    }
}
