package com.gy.designPattern.strategypattern;

/**
 * Created by hello on 2018/9/8.
 */
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("fly with wings ~ ");
    }
}
