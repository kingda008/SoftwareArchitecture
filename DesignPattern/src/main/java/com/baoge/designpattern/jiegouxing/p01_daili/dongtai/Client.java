package com.baoge.designpattern.jiegouxing.p01_daili.dongtai;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        JDKDynamicProxy proxy = new JDKDynamicProxy(new Student("张三"));
        //创建代理实例
        Person student = (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Person.class}, proxy);
        student.wakeup();
        student.sleep();

        proxy = new JDKDynamicProxy(new Doctor("王教授"));
        Person doctor = (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Person.class}, proxy);
        doctor.wakeup();
        doctor.sleep();

        proxy = new JDKDynamicProxy(new Dog("旺旺"));
        Animal dog = (Animal) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Animal.class}, proxy);
        dog.wakeup();
        dog.sleep();

        proxy = new JDKDynamicProxy(new Cat("咪咪"));
        Animal cat = (Animal) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Animal.class}, proxy);
        cat.wakeup();
        cat.sleep();
    }
}

