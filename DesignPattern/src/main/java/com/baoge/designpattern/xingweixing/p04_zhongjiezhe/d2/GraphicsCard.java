package com.baoge.designpattern.xingweixing.p04_zhongjiezhe.d2;

public class GraphicsCard extends Colleague {
    public GraphicsCard(Mediator mediator) {
        super(mediator);
    }

    public void videoPlay(String data){
        System.out.println("播放："+data);
    }
}
