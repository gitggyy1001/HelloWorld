package com.test;

/**
 * Created by hello on 2018/10/26.
 */
import java.io.IOException;

import com.gy.dubbo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath*:springmvc.xml" });
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");

        System.out.println(demoService.sayHello("hello,this is client's Hi!"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

