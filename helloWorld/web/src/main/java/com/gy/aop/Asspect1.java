package com.gy.aop;

//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by hello on 2018/4/23.
 */

@Repository
@Aspect
public class Asspect1 {
    @Before("execution(* com.gy.aop.AopTest.test(..))")
    public void aspect(){
        System.out.println("Asspect1");
    }
}
