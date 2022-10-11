package com.baoge.designpattern.xingweixing.p02_celue;

public class TaxiCalculateStrategy implements CalculateStrategy {
    @Override
    public int calculatePrice(int km) {
        int price = 50;
        //省略出租车计算逻辑
        return price;
    }
}
