package com.baoge.designpattern.chuangjianxing.p03_build;

/**
 * 抽象产品类
 */
public abstract class Computer {
    protected String board;
    protected String display;
    protected String os;

    protected Computer(){}
    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }



    public abstract void setOs() ;
}
