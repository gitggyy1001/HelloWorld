package com.gy.dynamicProxy;

/**
 * Created by hello on 2018/8/24.
 */
public class Target implements HelloInterface{
    public void hello(){
        System.out.println("hello,world!");
    }
}
