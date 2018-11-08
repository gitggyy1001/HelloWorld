package com.gy.aop;

import org.springframework.stereotype.Repository;

/**
 * Created by hello on 2018/8/29.
 */
@Repository
public class NoAop {
    public  void hello(){
        System.out.println("no aop");
    }
}
