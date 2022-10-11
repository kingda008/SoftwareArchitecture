package com.baoge.designpattern.xingweixing.p04_zhongjiezhe.d2;



public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
}
