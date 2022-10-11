package com.baoge.designpattern.jiegouxing.p06_waiguanmoshi;

public class MobilePhone {
    private IPhone phone = new PhoneImpl();
    private ICamera camera = new HuaweiCamera();

    public void dial(){
        phone.dial();
    }
    public void videoChat(){
        camera.open();
        phone.dial();
    }
    public void hangup(){
        phone.hangup();
    }
    public void takePicture(){
        camera.open();
        camera.takePicture();
    }
    public void closeCamera(){
        camera.close();
    }
}
