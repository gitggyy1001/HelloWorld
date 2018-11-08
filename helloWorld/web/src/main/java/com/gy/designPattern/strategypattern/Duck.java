package com.gy.designPattern.strategypattern;

/**
 * Created by hello on 2018/9/8.
 */
public class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior,QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
        this.flyBehavior = flyBehavior;
    }

    public Duck(){

    }

    public void display(){};

    public void performQuack(){
        quackBehavior.quack();
    };

    public void performFly(){
        flyBehavior.fly();
    }

}
