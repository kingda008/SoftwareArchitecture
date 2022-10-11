package com.baoge.designpattern.xingweixing.p04_zhongjiezhe.d2;

/**
 * CD设别负责读取光盘数据，并将数据提供给主板
 *
 */
public class CDDevice extends Colleague {
    private String data;//视频数据

    public CDDevice(Mediator mediator) {
        super(mediator);
    }
    public String read(){
        return data;
    }
    public void load(){
        data = "视频数据，音频数据";
        mediator.changed(this);
    }
}
