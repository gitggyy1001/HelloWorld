package com.gy.rmi;

import java.rmi.Naming;

/**
 * Created by hello on 2018/3/8.
 */
public class RmiClient {
    public static void main(String[] args) {
        try {
            IHello hello = (IHello) Naming.lookup("rmi://localhost:1399/Hello");
            System.out.println(hello.sayHello("gy"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
