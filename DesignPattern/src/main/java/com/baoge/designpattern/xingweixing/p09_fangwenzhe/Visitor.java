package com.baoge.designpattern.xingweixing.p09_fangwenzhe;

public interface Visitor {
    void visit(Engineer engineer);
    void visit(Manager manager);
}
