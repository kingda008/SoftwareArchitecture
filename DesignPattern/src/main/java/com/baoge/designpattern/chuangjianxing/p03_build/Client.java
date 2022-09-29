package com.baoge.designpattern.chuangjianxing.p03_build;

public class Client {
    public static void main(String[] args) {
        Builder builder = new MacBookBuilder();
        Director director = new Director(builder);
        director.construct("英特尔主板","三星显示器");
        builder.create();
    }
}
