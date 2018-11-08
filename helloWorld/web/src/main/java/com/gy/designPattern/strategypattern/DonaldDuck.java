package com.gy.designPattern.strategypattern;

/**
 * Created by hello on 2018/9/8.
 */
public class DonaldDuck extends Duck {

    public DonaldDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }

    public DonaldDuck() {
        this.flyBehavior = new FlyInDream();
        this.quackBehavior = new Quack();
    }

}
