package com.baoge.designpattern.xingweixing.p04_zhongjiezhe;

public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
}
