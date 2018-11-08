package com.gy.designPattern.DecoratorMode;

/**
 * Created by hello on 2018/9/13.
 */

public class Demo{
    public static void main(String[] args) {
            //首先创建一个黑咖啡
            Coffee cof = new CoffeeImpl();
            //加糖咖啡
            Coffee sugar = new Sugar(cof);
            sugar.coffee();
            //加糖又加奶咖啡
            Coffee milk = new Milk(sugar);
            sugar.coffee();
    }
}

