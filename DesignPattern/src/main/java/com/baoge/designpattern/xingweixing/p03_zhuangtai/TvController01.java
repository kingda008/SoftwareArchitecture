package com.baoge.designpattern.xingweixing.p03_zhuangtai;

public class TvController01 {
    private final static int POWER_ON = 1;
    private final static int POWER_OFF = 2;

    private int state = POWER_OFF;

    public void powerOn(){
        state = POWER_ON;
        if(state == POWER_OFF){
            System.out.println("开机了");
        }
    }

    public void powerOff(){
        state = POWER_OFF;
        if(state == POWER_ON){
            System.out.println("关机了");
        }
    }
    public void nextChannel(){
        if(state == POWER_ON){
            System.out.println("下一个频道");
        }else {
            System.out.println("关机状态，无法控制");
        }
    }

    public void turnUp(){
        if(state == POWER_ON){
            System.out.println("调高音量");
        }else {
            System.out.println("关机状态，无法控制");
        }
    }
}
