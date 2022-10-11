package com.baoge.designpattern.jiegouxing.p07_qiaojiemoshi;

/**
 * 抽象化角色
 */
public abstract class Coffee {
    //抽象化角色中对实现化角色的引用 ！！
    protected CoffeeAdditives coffeeAdditives;

    public Coffee(CoffeeAdditives additives) {
        coffeeAdditives = additives;
    }

    /**
     * 具体什么样子由子类决定
     */
    public abstract void makeCoffee();
}
