package com.baoge.designpattern.xingweixing.p01_muban.client;

import com.baoge.designpattern.xingweixing.p01_muban.AbsComputer;
import com.baoge.designpattern.xingweixing.p01_muban.CoderComputer;
import com.baoge.designpattern.xingweixing.p01_muban.NormalComputer;

public class Client {
    public static void main(String[] args) {
        AbsComputer corderComputer = new CoderComputer();
        corderComputer.startUp();

        AbsComputer normalComputer = new NormalComputer();
        normalComputer.startUp();
    }
}
