package com.baoge.designpattern.xingweixing.p09_fangwenzhe;

public class CtoVisitor implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师：" + engineer.name + ",代码行数:" + engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理：" + manager.name + ",KPI:" + manager.kpi + ",新产品数量：" + manager.getProducts());
    }
}
