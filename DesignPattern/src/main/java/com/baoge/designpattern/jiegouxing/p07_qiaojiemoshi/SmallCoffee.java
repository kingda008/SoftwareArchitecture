package com.baoge.designpattern.jiegouxing.p07_qiaojiemoshi;

public class SmallCoffee extends Coffee {
    public SmallCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯的 " + coffeeAdditives.addSomething() + " 咖啡");
    }
}
