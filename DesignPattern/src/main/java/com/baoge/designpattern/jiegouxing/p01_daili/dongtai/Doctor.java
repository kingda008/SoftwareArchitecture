package com.baoge.designpattern.jiegouxing.p01_daili.dongtai;

//实现类2
public class Doctor implements Person {
    private String name;
    public Doctor() {
    }
    public Doctor(String name) {
        this.name = name;
    }
    @Override
    public void wakeup() {
        System.out.println("医生"+name+"早晨醒来啦");
    }
    @Override
    public void sleep() {
        System.out.println("医生"+name+"晚上睡觉啦");
    }
}
