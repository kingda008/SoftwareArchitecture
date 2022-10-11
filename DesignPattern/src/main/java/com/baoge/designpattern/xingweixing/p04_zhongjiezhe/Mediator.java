package com.baoge.designpattern.xingweixing.p04_zhongjiezhe;

public abstract class Mediator {
    //定义同事类
    protected ConcreteColleagueA concreteColleagueA;
    protected ConcreteColleagueB concreteColleagueB;
    public abstract void doSomething() ;


    public ConcreteColleagueA getConcreteColleagueA() {
        return concreteColleagueA;
    }

    public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA) {
        this.concreteColleagueA = concreteColleagueA;
    }

    public ConcreteColleagueB getConcreteColleagueB() {
        return concreteColleagueB;
    }

    public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB) {
        this.concreteColleagueB = concreteColleagueB;
    }
}
