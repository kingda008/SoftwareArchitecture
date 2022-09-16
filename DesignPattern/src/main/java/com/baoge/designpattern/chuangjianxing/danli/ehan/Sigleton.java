package com.baoge.designpattern.chuangjianxing.danli.ehan;

public class Sigleton {
    private static Sigleton instance = new Sigleton();

    private Sigleton() {
    }

    public static Sigleton getInstance() {
        return instance;
    }
}
