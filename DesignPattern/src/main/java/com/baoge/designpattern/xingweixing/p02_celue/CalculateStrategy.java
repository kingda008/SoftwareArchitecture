package com.baoge.designpattern.xingweixing.p02_celue;

/**
 * 抽象策略角色
 */
public interface CalculateStrategy {

    /**
     * 按举例来计算价格
     * @param km 公里
     * @return 价格
     */
    int calculatePrice(int km);
}
