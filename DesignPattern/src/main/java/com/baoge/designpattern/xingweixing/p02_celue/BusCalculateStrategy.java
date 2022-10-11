package com.baoge.designpattern.xingweixing.p02_celue;

public class BusCalculateStrategy implements CalculateStrategy {
    @Override
    public int calculatePrice(int km) {
        int price = 100;
        //省略公交车计算逻辑
        return price;
    }
}
