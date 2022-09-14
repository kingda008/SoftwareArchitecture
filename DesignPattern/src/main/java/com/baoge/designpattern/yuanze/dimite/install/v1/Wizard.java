package com.baoge.designpattern.yuanze.dimite.install.v1;

import java.util.Random;

public class Wizard {
    private Random rand = new Random(System.currentTimeMillis());

    public int first() {
        System.out.println("执行第一步");
        return rand.nextInt(100);
    }

    public int second() {
        System.out.println("执行第二步");
        return rand.nextInt(100);
    }

    public int third() {
        System.out.println("执行第三步");
        return rand.nextInt(100);
    }

}
