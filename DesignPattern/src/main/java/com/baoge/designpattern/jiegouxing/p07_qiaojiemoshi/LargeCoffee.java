package com.baoge.designpattern.jiegouxing.p07_qiaojiemoshi;

public class LargeCoffee extends Coffee {
    public LargeCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯的 "+coffeeAdditives.addSomething()+" 咖啡");
    }
}
