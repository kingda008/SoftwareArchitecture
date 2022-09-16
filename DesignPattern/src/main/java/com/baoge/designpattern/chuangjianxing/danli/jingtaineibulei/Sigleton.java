package com.baoge.designpattern.chuangjianxing.danli.jingtaineibulei;

public class Sigleton {
    private Sigleton() {
    }

    public static Sigleton getInstance() {
        return SingleonHolder.instance;
    }

    private static class SingleonHolder {
        private static final Sigleton instance = new Sigleton();
    }
}
