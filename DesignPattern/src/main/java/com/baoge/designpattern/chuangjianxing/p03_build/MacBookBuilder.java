package com.baoge.designpattern.chuangjianxing.p03_build;

public class MacBookBuilder extends Builder {
    private Computer computer = new MacBook();
    @Override
    public void buildBoard(String board) {
        computer.setBoard(board);
    }

    @Override
    public void buildDisplay(String display) {
        computer.setDisplay(display);
    }

    @Override
    public void buildOs() {
        computer.setOs();
    }

    @Override
    public Computer create() {
        return computer;
    }
}
