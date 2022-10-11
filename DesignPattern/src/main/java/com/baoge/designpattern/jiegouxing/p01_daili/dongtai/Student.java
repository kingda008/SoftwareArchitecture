package com.baoge.designpattern.jiegouxing.p01_daili.dongtai;

//实现类1
public class Student implements Person {
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void wakeup() {
        System.out.println("学生" + name + "早晨醒来啦");
    }

    @Override
    public void sleep() {
        System.out.println("学生" + name + "晚上睡觉啦");
    }
}
