package com.baoge.designpattern.xingweixing.p04_zhongjiezhe.d2;

public class Client {
    public static void main(String[] args) {
        MainBoard mainBoard = new MainBoard();

        CDDevice cdDevice = new CDDevice(mainBoard);
        Cpu cpu = new Cpu(mainBoard);
        GraphicsCard graphicsCard = new GraphicsCard(mainBoard);
        SoundCard soundCard = new SoundCard(mainBoard);

        mainBoard.setCdDevice(cdDevice);
        mainBoard.setCpu(cpu);
        mainBoard.setGraphicsCard(graphicsCard);
        mainBoard.setSoundCard(soundCard);

        //开始播放
        cdDevice.load();

    }
}
