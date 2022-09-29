package com.baoge.designpattern.chuangjianxing.p02_gongchang.v2_duogegongchang;

public class WhiteHumanFactory extends AbsHumanFactory {
    @Override
    public Human createHuman() {
        Human human = new WhiteHuman();

        return  human;
    }
}
