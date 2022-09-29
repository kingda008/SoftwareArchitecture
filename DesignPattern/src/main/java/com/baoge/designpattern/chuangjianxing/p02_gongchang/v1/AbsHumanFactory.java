package com.baoge.designpattern.chuangjianxing.p02_gongchang.v1;

public abstract class AbsHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> tClass);
}
