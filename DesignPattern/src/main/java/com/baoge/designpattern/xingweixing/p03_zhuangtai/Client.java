package com.baoge.designpattern.xingweixing.p03_zhuangtai;

public class Client {
    public static void main(String[] args) {
        TvController tvController = new TvController();
        tvController.powerOn();
        tvController.nextChannel();
        tvController.turnUp();

        tvController.powerOff();
        tvController.nextChannel();
        tvController.turnUp();
    }
}
