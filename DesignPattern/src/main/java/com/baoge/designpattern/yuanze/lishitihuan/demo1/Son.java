package com.baoge.designpattern.yuanze.lishitihuan.demo1;

import java.util.Collection;
import java.util.Map;

public class Son extends Father {
    //放大输入类型
    public Collection doSomeThing(Map map){
        System.out.println("子类被执行");
        return map.values();
    }
}
