package com.baoge.designpattern.xingweixing.p03_zhuangtai;

public class PowerOffState implements TvState {
    @Override
    public void nextChannel() {
        System.out.println("关机状态，无法控制");
    }

    @Override
    public void turnUp() {
        System.out.println("关机状态，无法控制");
    }
}
