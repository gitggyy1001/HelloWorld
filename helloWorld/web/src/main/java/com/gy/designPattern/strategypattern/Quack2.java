package com.gy.designPattern.strategypattern;

/**
 * Created by hello on 2018/9/8.
 */
public class Quack2 implements  QuackBehavior {
    @Override
    public void quack() {
        System.out.println("gu gu gu ~");
    }
}
