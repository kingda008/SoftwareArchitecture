package com.baoge.designpattern.yuanze.lishitihuan.demo2;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        Father father = new Father();
        father.doSomeThing(hashMap);

        Son son = new Son();
        son.doSomeThing(hashMap);

    }
}
