package com.baoge.designpattern.jiegouxing.p04_zhuangshizhe;

public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        method1();
        super.operate();
    }
    //定义自己扩展的修饰方法
    private void method1(){
        System.out.println("ConcreteDecorator1 method1");
    }
}
