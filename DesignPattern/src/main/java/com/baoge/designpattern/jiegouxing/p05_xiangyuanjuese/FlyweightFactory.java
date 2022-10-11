package com.baoge.designpattern.jiegouxing.p05_xiangyuanjuese;

import java.util.HashMap;

public class FlyweightFactory {
    //定义一个池容器
    private static HashMap<String,Flyweight> pool = new HashMap<>();
    //享员工厂
    public static Flyweight getFlyweight(String extrinsic){
        Flyweight flyweight = null;
        if(pool.containsKey(extrinsic)){
            flyweight = pool.get(extrinsic);
        }else {
            flyweight = new ConcreteFlyweight1(extrinsic);
            pool.put(extrinsic,flyweight);
        }
        return flyweight;
    }

}
