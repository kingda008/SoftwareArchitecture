package com.baoge.designpattern.jiegouxing.p01_daili.dongtai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理类
public class JDKDynamicProxy implements InvocationHandler {
    private Object bean;

    public JDKDynamicProxy(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodname = method.getName();
        if (methodname.equals("wakeup")) {
            System.out.println("早安~~~");
        } else if (methodname.equals("sleep")) {
            System.out.println("晚安~~~");
        }
        return method.invoke(bean, args);
    }
}
