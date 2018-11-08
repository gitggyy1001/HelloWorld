package com.gy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by hello on 2018/8/24.
 */
public class TestJdkProxy {
    public static void main(String[] args) {
        Target target = new Target();
        DynamicProxy handler  = new DynamicProxy(target);
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        HelloInterface proxy = (HelloInterface) Proxy.newProxyInstance(loader, interfaces, handler);
        proxy.hello();
    }
}
