package com.baoge.designpattern.jiegouxing.p02_zuhe.anquan;

public abstract class Component {
    protected String name;
    public Component(String name){
        this.name = name;
    }
    public abstract void doSomething();
}
