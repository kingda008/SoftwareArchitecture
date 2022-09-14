package com.baoge.designpattern.yuanze.lishitihuan.demo1;

import java.util.Collection;
import java.util.HashMap;

public class Father {
    public Collection doSomeThing(HashMap map){
        System.out.println("父类被执行");
        return map.values();
    }
}
