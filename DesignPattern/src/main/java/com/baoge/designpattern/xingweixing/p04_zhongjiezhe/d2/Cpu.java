package com.baoge.designpattern.xingweixing.p04_zhongjiezhe.d2;

/**
 * CPU负责对主板传递来的音视频解码
 *
 */
public class Cpu extends Colleague {
    private String dataVideo, dataSound;//视频音频数据

    public Cpu(Mediator mediator) {
        super(mediator);
    }


    public String getDataVideo() {
        return dataVideo;
    }

    public void setDataVideo(String dataVideo) {
        this.dataVideo = dataVideo;
    }

    public String getDataSound() {
        return dataSound;
    }

    public void setDataSound(String dataSound) {
        this.dataSound = dataSound;
    }

    public void decode(String data) {
        String[] tmp = data.split("，");
        dataSound = tmp[0];
        dataVideo = tmp[1];
        //告知中介者自身状态改变
        mediator.changed(this);
    }
}
