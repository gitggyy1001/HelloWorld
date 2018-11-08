package com.gy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hello on 2018/8/27.
 */
public class DynamicProxy implements InvocationHandler {

    //　这个就是我们要代理的真实对象
    private Object target;

    //    构造方法，给我们要代理的真实对象赋初值
    public DynamicProxy(Object subject)
    {
        this.target = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//　　在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before invoke target");
        method.invoke(target, args);
        System.out.println("after invoke target");
        return null;
    }
}
