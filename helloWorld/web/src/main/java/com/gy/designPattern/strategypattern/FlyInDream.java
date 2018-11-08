package com.gy.designPattern.strategypattern;

/**
 * Created by hello on 2018/9/8.
 */
public class FlyInDream implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("sweet dream ah?");
    }
}
