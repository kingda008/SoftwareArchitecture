package com.baoge.designpattern.chuangjianxing.p02_gongchang.v2_jdgc;

public class HumanFactory   {

    public static <T extends Human> T createHuman(Class<T> tClass) {
        Human human = null;
        try {
            human = (T) Class.forName(tClass.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) human;
    }
}
