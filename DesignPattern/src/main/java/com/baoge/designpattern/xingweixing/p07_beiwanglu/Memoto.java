package com.baoge.designpattern.xingweixing.p07_beiwanglu;

/**
 * 备忘录角色
 */
public class Memoto {
    private int mCheckPoint;
    private int mLifeValue;
    private String mWeapon;

    public int getmCheckPoint() {
        return mCheckPoint;
    }

    public void setmCheckPoint(int mCheckPoint) {
        this.mCheckPoint = mCheckPoint;
    }

    public int getmLifeValue() {
        return mLifeValue;
    }

    public void setmLifeValue(int mLifeValue) {
        this.mLifeValue = mLifeValue;
    }

    public String getmWeapon() {
        return mWeapon;
    }

    public void setmWeapon(String mWeapon) {
        this.mWeapon = mWeapon;
    }
}
