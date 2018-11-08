package com.gy.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by hello on 2018/4/23.
 */
@Repository
public class AopTest implements IAopTest{

    public  int test() {
        System.out.println("main");
        return 1;
    }

    public  int test2() {
        System.out.println("main2");
        return 2;
    }
}
