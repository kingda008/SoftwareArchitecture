package com.baoge.designpattern.chuangjianxing.p03_build;

public class Director {
    Builder builder = null;
    public Director(Builder builder){
        this.builder = builder;
    }
    public void construct(String board,String display){
        builder.buildBoard(board);
        builder.buildDisplay(display);
        builder.buildOs();
    }
}
