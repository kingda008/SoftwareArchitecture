package com.baoge.designpattern.jiegouxing.p01_daili.dongtai;

public class Cat implements Animal {
    private String name;
    public Cat() {
    }
    public Cat(String name) {
        this.name = name;
    }
    @Override
    public void wakeup() {
        System.out.println("小猫"+name+"早晨醒来啦");
    }
    @Override
    public void sleep() {
        System.out.println("小猫"+name+"晚上睡觉啦");
    }
}
