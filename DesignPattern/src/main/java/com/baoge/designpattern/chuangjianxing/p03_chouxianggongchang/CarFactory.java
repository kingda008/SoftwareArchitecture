package com.baoge.designpattern.chuangjianxing.p03_chouxianggongchang;

public abstract class CarFactory {
    public abstract ITire createTire();
    public abstract IEngine createEngine();
    public abstract IBrake createBrake();
}
