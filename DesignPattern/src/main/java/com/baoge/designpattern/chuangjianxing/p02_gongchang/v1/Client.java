package com.baoge.designpattern.chuangjianxing.p02_gongchang.v1;

public class Client {
    public static void main(String[] args) {
        AbsHumanFactory factory = new HumanFactory();
        Human yellowHuman = factory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();

        WhiteHuman whiteHuman = factory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
    }
}
