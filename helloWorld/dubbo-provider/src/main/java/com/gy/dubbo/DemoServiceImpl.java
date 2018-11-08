package com.gy.dubbo;

import com.gy.dubbo.DemoService;
import org.springframework.stereotype.Service;

/**
 * Created by hello on 2018/10/26.
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    public String sayHello(String msg) {
        System.out.println(msg);
        return "hello,this is server's Hi!";
    }
}
