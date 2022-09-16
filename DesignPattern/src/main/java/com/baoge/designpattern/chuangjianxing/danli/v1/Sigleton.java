package com.baoge.designpattern.chuangjianxing.danli.v1;

public class Sigleton {
    private static Sigleton sigleton;

    private Sigleton() {
    }

    public static Sigleton getInstance() {
        if (sigleton == null) {
            sigleton = new Sigleton();
        }
        return sigleton;
    }
}
