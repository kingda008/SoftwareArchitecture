package com.baoge.designpattern.xingweixing.p05_mingling;

public class Client {
    public static void main(String[] args) {
        //构造一个接收者
        Receiver receiver = new Receiver();
        //根据接收者对象构建一个命令对象
        Command command = new ConcreteCommand(receiver);
        //根据具体命令对象构造请求者对象
        Invoke invoke = new Invoke(command);
        //执行请求方法
        invoke.action();
    }
}
