package com.baoge.designpattern.xingweixing.p02_celue;

/**
 * 公交方式价格计算类，扮演Context上下文封装类角色
 */
public class TranficCalculator {
    private CalculateStrategy strategy;

    public void setStrategy(CalculateStrategy strategy){
        this.strategy = strategy;
    }

    public int calculate(int km){
        return strategy.calculatePrice(km);
    }
}
