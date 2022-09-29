package com.baoge.designpattern.chuangjianxing.p02_gongchang.v2_jdgc;

public class Client {
    public static void main(String[] args) {

        Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();

        WhiteHuman whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
    }
}
