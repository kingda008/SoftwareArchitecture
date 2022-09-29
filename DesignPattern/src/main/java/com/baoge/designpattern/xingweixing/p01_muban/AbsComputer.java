package com.baoge.designpattern.xingweixing.p01_muban;

public abstract class AbsComputer {
    protected void powerOn() {
        System.out.println("开启电源");
    }

    protected void checkHardware() {
        System.out.println("硬盘检查");
    }

    protected void loadOs() {
        System.out.println("载入操作系统");
    }

    protected void login() {
        System.out.println("登录成功后，进入系统");
    }

    protected boolean isNeedLogin() {
        return true;
    }

    public final void startUp() {
        powerOn();
        checkHardware();
        loadOs();
        if (isNeedLogin()) {
            login();
        }
    }
}
