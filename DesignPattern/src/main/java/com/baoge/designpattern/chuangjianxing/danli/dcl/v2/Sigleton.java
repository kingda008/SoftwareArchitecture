package com.baoge.designpattern.chuangjianxing.danli.dcl.v2;

public class Sigleton {
    private volatile static Sigleton instance;
    private Sigleton(){}

    public static Sigleton getInstance(){
        if(instance == null){
            synchronized (Sigleton.class) {
                if(instance == null) {
                    instance = new Sigleton();
                }
            }
        }
        return instance;
    }
}
