package com.baoge.designpattern.chuangjianxing.danli.dcl.v1;

public class Sigleton {
    private static Sigleton instance;
    private Sigleton(){}

    public static  Sigleton getInstance(){
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
