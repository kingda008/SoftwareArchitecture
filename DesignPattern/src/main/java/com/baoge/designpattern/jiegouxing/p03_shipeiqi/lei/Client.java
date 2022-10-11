package com.baoge.designpattern.jiegouxing.p03_shipeiqi.lei;

public class Client {
    public static void main(String[] args) {
        //原有的业务逻辑
        Target target = new ConcreteTarget();
        target.request();

        //增加了适配器
        target = new Adapter();
        target.request();
    }
}
