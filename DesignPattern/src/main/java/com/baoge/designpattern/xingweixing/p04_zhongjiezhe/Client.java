package com.baoge.designpattern.xingweixing.p04_zhongjiezhe;

public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleagueA concreteColleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB concreteColleagueB = new ConcreteColleagueB(mediator);

        mediator.setConcreteColleagueA(concreteColleagueA);
        mediator.setConcreteColleagueB(concreteColleagueB);

        concreteColleagueA.depMethod();
    }
}
