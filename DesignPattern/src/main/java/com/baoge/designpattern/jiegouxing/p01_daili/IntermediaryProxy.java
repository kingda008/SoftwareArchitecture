package com.baoge.designpattern.jiegouxing.p01_daili;

public class IntermediaryProxy implements IRentHouse {
    private IRentHouse iRent;
    public IntermediaryProxy(IRentHouse iRentHouse) {
        iRent=iRentHouse;
    }
    @Override
    public void rentHouse() {
        dosomenThingBefore();
        iRent.rentHouse();
        dosomenThingAfter();
    }

    private void dosomenThingBefore(){
        System.out.println("交中介费");
    }

    private void dosomenThingAfter(){
        System.out.println("中介负责维修管理");
    }
}

