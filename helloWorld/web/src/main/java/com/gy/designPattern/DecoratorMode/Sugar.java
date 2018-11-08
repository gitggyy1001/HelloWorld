package com.gy.designPattern.DecoratorMode;

/**
 * Created by hello on 2018/9/13.
 */
class Sugar extends CoffeeWrapper {
    public Sugar(Coffee cof) {
        super(cof);
    }
    public void coffee(){
        super.coffee();
        System.out.println("加糖");
    }
}
