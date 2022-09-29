package com.baoge.designpattern.chuangjianxing.p02_gongchang.v2_duogegongchang;

public class YellowHumanFactory extends AbsHumanFactory {
    @Override
    public Human createHuman() {
        Human human = new YellowHuman();
        return  human;
    }
}
