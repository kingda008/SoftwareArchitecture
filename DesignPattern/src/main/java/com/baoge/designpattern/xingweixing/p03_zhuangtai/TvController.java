package com.baoge.designpattern.xingweixing.p03_zhuangtai;

public class TvController implements PowerController {
    private TvState tvState;

    public TvState getTvState() {
        return tvState;
    }

    public void setTvState(TvState tvState) {
        this.tvState = tvState;
    }

    @Override
    public void powerOn() {
        setTvState(new PowerOnState());
        System.out.println("开机了");
    }

    @Override
    public void powerOff() {
        setTvState(new PowerOffState());
        System.out.println("开机了");
    }

    public void nextChannel(){
        tvState.nextChannel();
    }
    public void turnUp(){
        tvState.turnUp();
    }
}
