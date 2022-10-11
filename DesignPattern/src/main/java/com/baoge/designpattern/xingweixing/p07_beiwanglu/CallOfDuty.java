package com.baoge.designpattern.xingweixing.p07_beiwanglu;

/**
 * 使命召唤游戏，Originator发起人角色
 */
public class CallOfDuty {
    private int mCheckPoint = 1;
    private int mLifeValue =100;
    private String mWeapon = "沙漠之鹰";

    public void play(){
        System.out.println("玩游戏：");
        mLifeValue -= 10;
        mCheckPoint++;
    }

    public void quit(){
        System.out.println("退出游戏：");
    }

    /**
     * 创建备忘录(保存游戏进度)
     * @return
     */
    public Memoto createMemoto(){
        Memoto memoto = new Memoto();
        memoto.setmCheckPoint(mCheckPoint);
        memoto.setmLifeValue(mLifeValue);
        memoto.setmWeapon(mWeapon);
        return memoto;
    }

    /**
     * 恢复进度
     * @param memoto
     */
    public void restore(Memoto memoto){
        mCheckPoint = memoto.getmCheckPoint();
        mLifeValue = memoto.getmLifeValue();
        mWeapon = memoto.getmWeapon();
    }
}
