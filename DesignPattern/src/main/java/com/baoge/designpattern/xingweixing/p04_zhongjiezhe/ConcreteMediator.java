package com.baoge.designpattern.xingweixing.p04_zhongjiezhe;

public class ConcreteMediator extends Mediator {
    @Override
    public void doSomething() {
        super.concreteColleagueA.selfMethod();
        super.concreteColleagueB.selfMethod();
    }
}
