package com.baoge.designpattern.chuangjianxing.p03_chouxianggongchang;

public class AudiQ7Factory extends CarFactory {
    @Override
    public ITire createTire() {
        return new SuvTire();
    }

    @Override
    public IEngine createEngine() {
        return new ImportEngine();
    }

    @Override
    public IBrake createBrake() {
        return new SeniorBrake();
    }
}
