package com.baoge.designpattern.jiegouxing.p04_zhuangshizhe;

public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        method2();
        super.operate();
    }
    //定义自己扩展的修饰方法
    private void method2(){
        System.out.println("ConcreteDecorator2 method2");
    }
}
