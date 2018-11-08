package com.gy.designPattern.FactoryMode.simpleFactory;

/**
 * Created by hello on 2018/9/13.
 */
public class PizzaFactory {
    public Pizza createPizza(int type){
        Pizza pizza = null;
        if(type==1){
            pizza = new ApplePizza();
        }
        else if(type==2){
            pizza = new CheesePizza();
        }
        return pizza;
    }
}
