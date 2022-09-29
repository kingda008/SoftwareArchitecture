package com.baoge.designpattern.chuangjianxing.p02_gongchang.v1;

public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白色");
    }
    @Override
    public void talk() {
        System.out.println("白说");
    }
}
