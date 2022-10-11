package com.baoge.designpattern.xingweixing.p06_guanchazhe;

public class ConcreteSubject extends Subject {
    public void doSomething(){
        //1，处理自己的业务
        //2，通知
        notifyObservers();
    }
}
