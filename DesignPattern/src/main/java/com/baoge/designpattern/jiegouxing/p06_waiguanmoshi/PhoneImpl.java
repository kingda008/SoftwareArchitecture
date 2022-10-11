package com.baoge.designpattern.jiegouxing.p06_waiguanmoshi;

public class PhoneImpl implements IPhone {
    @Override
    public void dial() {
        System.out.println("打电话");
    }

    @Override
    public void hangup() {
        System.out.println("挂断");
    }
}
