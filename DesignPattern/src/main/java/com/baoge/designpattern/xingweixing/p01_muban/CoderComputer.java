package com.baoge.designpattern.xingweixing.p01_muban;

public class CoderComputer extends AbsComputer {
    @Override
    protected void login() {
      System.out.println("程序员登录，权限最大");
    }
}
