package com.gy.dubbo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by hello on 2018/11/1.
 */
public class Test {
    private static Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        //BasicConfigurator.configure ();
        //PropertyConfigurator.configure("classpath:log4j.properties");
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}
