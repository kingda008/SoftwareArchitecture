package com.baoge.designpattern.xingweixing.p01_muban;

public class NormalComputer extends AbsComputer {
    @Override
    protected void checkHardware() {
        System.out.println("不需要检测");
    }

    @Override
    protected boolean isNeedLogin() {
        return false;
    }
}
