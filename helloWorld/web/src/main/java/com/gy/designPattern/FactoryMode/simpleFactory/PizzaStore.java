package com.gy.designPattern.FactoryMode.simpleFactory;

/**
 * Created by hello on 2018/9/13.
 */
public class PizzaStore {
    PizzaFactory  pizzaFactory;

    public PizzaStore(PizzaFactory  pizzaFactory){
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza order(int type){
        Pizza pizza = pizzaFactory.createPizza(type);
        pizza.make();
        return pizza;
    }
}
