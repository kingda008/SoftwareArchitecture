package com.baoge.designpattern.chuangjianxing.p02_gongchang.v1;

public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄色");
    }

    @Override
    public void talk() {
        System.out.println("黄说");
    }
}
