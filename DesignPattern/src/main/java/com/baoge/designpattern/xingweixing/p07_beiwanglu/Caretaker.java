package com.baoge.designpattern.xingweixing.p07_beiwanglu;

public class Caretaker {
    private Memoto memoto;
    public void archive(Memoto memoto){
        this.memoto = memoto;
    }

    public Memoto getMemoto(){
        return memoto;
    }
}
