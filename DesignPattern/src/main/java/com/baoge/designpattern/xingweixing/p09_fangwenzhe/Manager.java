package com.baoge.designpattern.xingweixing.p09_fangwenzhe;

import java.util.Random;

public class Manager extends Staff {
    private int products;//产品数量
    public Manager(String name){
        super(name);
        products = new Random().nextInt(10);
    }
    @Override
    public void accept(Visitor visitor) {
        //切口中，把自己送出去了
        visitor.visit(this);
    }

    public int getProducts(){
        return products;
    }
}
