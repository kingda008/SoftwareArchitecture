package com.baoge.designpattern.jiegouxing.p03_shipeiqi.duixiang;

public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        //偷天换日
        adaptee.doSomething();
    }
}
