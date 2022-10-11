package com.baoge.designpattern.xingweixing.p09_fangwenzhe;

public class Client {
    public static void main(String[] args) {
        //构建报表
        BusinessReport report = new BusinessReport();
        //给CEO看的报表
        report.showReport(new CeoVisitor());
        //给CTO看的报表
        report.showReport(new CtoVisitor());
    }
}
