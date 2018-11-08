package com.gy.designPattern.strategypattern;

/**
 * Created by hello on 2018/9/8.
 */
public class Test {
    public static void main(String[] args) {
        Duck duck = new DonaldDuck();
        duck.performQuack();

        FlyBehavior flyBehavior = new FlyInDream();
        QuackBehavior quackBehavior = new Quack();
        Duck duck2 = new DonaldDuck(flyBehavior,quackBehavior);
        duck2.performQuack();
    }
}
