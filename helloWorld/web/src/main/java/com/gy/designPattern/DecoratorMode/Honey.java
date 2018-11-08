package com.gy.designPattern.DecoratorMode;

/**
 * Created by hello on 2018/9/13.
 */
class Honey extends CoffeeWrapper {
    public Honey(Coffee cof) {
        super(cof);
    }
    public void coffee(){
        super.coffee();
        System.out.println("加蜂蜜");
    }
}
