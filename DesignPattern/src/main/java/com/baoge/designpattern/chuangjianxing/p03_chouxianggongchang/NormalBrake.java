package com.baoge.designpattern.chuangjianxing.p03_chouxianggongchang;

public class NormalBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("普通制动");
    }
}
