package com.baoge.designpattern.xingweixing.p04_zhongjiezhe.d2;

public class MainBoard extends Mediator {
    private CDDevice cdDevice;
    private Cpu cpu;
    private SoundCard soundCard;
    private GraphicsCard graphicsCard;

    public CDDevice getCdDevice() {
        return cdDevice;
    }

    public void setCdDevice(CDDevice cdDevice) {
        this.cdDevice = cdDevice;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public SoundCard getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    public GraphicsCard getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public void changed(Colleague colleague) {
        if (colleague == cdDevice) {
            cpu.decode(cdDevice.read());
        } else if (colleague == cpu) {
            soundCard.soundPlay(cpu.getDataSound());
            graphicsCard.videoPlay(cpu.getDataVideo());
        }
    }
}
