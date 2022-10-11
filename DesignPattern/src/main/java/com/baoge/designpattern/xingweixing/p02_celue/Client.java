package com.baoge.designpattern.xingweixing.p02_celue;

public class Client {
    public static void main(String[] args) {
        TranficCalculator tranficCalculator = new TranficCalculator();
        tranficCalculator.setStrategy(new BusCalculateStrategy());
        tranficCalculator.calculate(10);
    }
}
