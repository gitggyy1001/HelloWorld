package com.gy.designPattern.DecoratorMode;

/**
 * Created by hello on 2018/9/13.
 */
class CoffeeWrapper implements Coffee {
    private Coffee cof;
    public CoffeeWrapper(Coffee cof){
        this.cof = cof;
    }
    public void coffee(){
        cof.coffee();
    }
}
