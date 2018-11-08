package com.gy.designPattern.strategypattern;

/**
 * Created by hello on 2018/9/8.
 */
public class Quack implements  QuackBehavior {
    @Override
    public void quack() {
        System.out.println("gua gua gua ~ ");
    }
}
