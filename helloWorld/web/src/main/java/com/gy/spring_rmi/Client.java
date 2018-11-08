package com.gy.spring_rmi;

import com.gy.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by hello on 2018/3/30.
 */
@Repository
public class Client {

    @Qualifier("userHttpInvokerServiceClient")
    @Autowired
    HelloRMIService HelloRMIServiceCliet;

    public User getUser(){
        System.out.println("httpinvoker-client-start");
        User user = HelloRMIServiceCliet.getUser(1);
        System.out.println("httpinvoker-client-end");
        return user;
    }
}
