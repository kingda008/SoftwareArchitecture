package com.baoge.designpattern.xingweixing.p03_zhuangtai;

public class PowerOnState implements TvState {
    @Override
    public void nextChannel() {
        System.out.println("下一个频道");
    }

    @Override
    public void turnUp() {
        System.out.println("调高音量");
    }
}
