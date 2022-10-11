package com.baoge.designpattern.xingweixing.p04_zhongjiezhe;

public class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }
    /**
     * 自有方法
     */
    public void selfMethod(){
        System.out.println("selfMethod B");
    }

    /**
     * 依赖方法
     */
    public void depMethod(){
        System.out.println("depMethod B");
        //1，处理自己的业务逻辑
        //2，委托中介者处理其他同事业务逻辑
        super.mediator.doSomething();
    }
}
