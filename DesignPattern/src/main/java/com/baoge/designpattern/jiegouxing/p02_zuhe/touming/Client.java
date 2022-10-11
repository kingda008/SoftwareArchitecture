package com.baoge.designpattern.jiegouxing.p02_zuhe.touming;

public class Client {
    public static void main(String[] args) {
        //构建根节点
        Composite root = new Composite("root");
        //枝干
        Composite branch1 = new Composite("Branch1");
        Composite branch2 = new Composite("Branch2");
        //叶子
        Leaf leaf1 = new Leaf("Leaf1");
        Leaf leaf2 = new Leaf("Leaf2");

        branch1.addChild(leaf1);
        branch2.addChild(leaf2);
        root.addChild(branch1);
        root.addChild(branch2);

        root.doSomething();
    }
}
