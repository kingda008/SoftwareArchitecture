package com.baoge.designpattern.chuangjianxing.p03_chouxianggongchang;

public class Client {
    public static void main(String[] args) {
        CarFactory audiQ3 = new AudiQ3Factory();
        audiQ3.createBrake().brake();
        audiQ3.createEngine().engine();
        audiQ3.createTire().tire();

        CarFactory audiQ7 = new AudiQ7Factory();
        audiQ7.createBrake().brake();
        audiQ7.createEngine().engine();
        audiQ7.createTire().tire();
    }
}
