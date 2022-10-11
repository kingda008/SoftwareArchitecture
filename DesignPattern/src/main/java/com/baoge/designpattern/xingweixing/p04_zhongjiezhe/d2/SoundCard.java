package com.baoge.designpattern.xingweixing.p04_zhongjiezhe.d2;

public class SoundCard extends Colleague {
    public SoundCard(Mediator mediator) {
        super(mediator);
    }

    public void soundPlay(String data){
        System.out.println("播放："+data);
    }
}
