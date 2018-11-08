package com.test;

/**
 * Created by hello on 2018/10/26.
 */
import java.io.IOException;

import com.gy.dubbo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class Test {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springmvc.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
        System.out.println("Dubbo provider start...");
        try {
            System.in.read();   // 按任意键退出
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

