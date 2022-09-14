package com.baoge.designpattern.yuanze.lishitihuan.demo2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Son extends Father {
    //缩小输入类型

    public Collection doSomeThing(HashMap map){
        System.out.println("子类被执行");
        return map.values();
    }
}
