package com.gy.designPattern.FactoryMode.simpleFactory;

/**
 * Created by hello on 2018/9/13.
 */
public class CheesePizza implements Pizza {
    @Override
    public void make() {
        System.out.println("add cheese");
    }
}
