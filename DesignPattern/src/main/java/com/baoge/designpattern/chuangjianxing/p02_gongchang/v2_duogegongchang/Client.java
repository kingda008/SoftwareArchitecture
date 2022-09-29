package com.baoge.designpattern.chuangjianxing.p02_gongchang.v2_duogegongchang;

public class Client {
    public static void main(String[] args) {

        Human yellowHuman = new YellowHumanFactory().createHuman();
        yellowHuman.getColor();
        yellowHuman.talk();

        Human whiteHuman = new WhiteHumanFactory().createHuman();
        whiteHuman.getColor();
        whiteHuman.talk();
    }
}
