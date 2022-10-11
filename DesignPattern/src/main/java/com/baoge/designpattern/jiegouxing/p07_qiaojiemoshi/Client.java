package com.baoge.designpattern.jiegouxing.p07_qiaojiemoshi;

public class Client {
    public static void main(String[] args) {
        //原汁原味
        Ordinary ordinary = new Ordinary();
        //加糖
        Sugar sugar = new Sugar();
        LargeCoffee largeOrinary = new LargeCoffee(ordinary);
        largeOrinary.makeCoffee();

        SmallCoffee smallSugarCoffee = new SmallCoffee(sugar);
        smallSugarCoffee.makeCoffee();
    }
}
