package com.baoge.designpattern.xingweixing.p09_fangwenzhe;

import java.util.Random;

public class Engineer extends Staff {
    public Engineer(String name){
        super(name);
    }
    @Override
    public void accept(Visitor visitor) {
        //切口中，把自己送出去了
        visitor.visit(this);
    }
    //工程师的代码量
    public int getCodeLines(){
        return new Random().nextInt(10*10000);
    }
}
