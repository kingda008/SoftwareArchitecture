package com.baoge.designpattern.jiegouxing.p03_shipeiqi.lei;

public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        //偷天换日
        super.doSomething();
    }
}
