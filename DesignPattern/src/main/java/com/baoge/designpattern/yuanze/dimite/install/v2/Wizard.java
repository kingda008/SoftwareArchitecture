package com.baoge.designpattern.yuanze.dimite.install.v2;

import java.util.Random;

public class Wizard {
    private Random rand = new Random(System.currentTimeMillis());

    private int first() {
        System.out.println("执行第一步");
        return rand.nextInt(100);
    }

    private int second() {
        System.out.println("执行第二步");
        return rand.nextInt(100);
    }

    private int third() {
        System.out.println("执行第三步");
        return rand.nextInt(100);
    }

    public void installWizard() {
        int first = first();
        if (first > 50) {
            int second = second();
            if (second > 50) {
                third();
            }
        }
    }
}
