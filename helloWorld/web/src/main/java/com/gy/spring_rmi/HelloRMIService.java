package com.gy.spring_rmi;


import com.gy.bean.User;

/**
 * Created by hello on 2018/3/30.
 */
public interface HelloRMIService {
    User getUser(Integer userId);
}
