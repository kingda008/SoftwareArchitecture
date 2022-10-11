package com.baoge.designpattern.xingweixing.p05_mingling;

public class Invoke {
    private Command command;
    public Invoke(Command command){
        this.command = command;
    }

    public void action(){
        command.execute();
    }
}
