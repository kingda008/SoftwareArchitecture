package com.baoge.designpattern.chuangjianxing.danli.lanhan.v2;

public class Sigleton {
    private static Sigleton instance;
    private Sigleton(){}

    public static synchronized Sigleton getInstance(){
        if(instance == null){
            instance = new Sigleton();
        }
        return instance;
    }
}
