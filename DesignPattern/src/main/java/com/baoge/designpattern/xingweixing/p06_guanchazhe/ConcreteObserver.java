package com.baoge.designpattern.xingweixing.p06_guanchazhe;

public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("接收到消息，进行处理");
    }
}
