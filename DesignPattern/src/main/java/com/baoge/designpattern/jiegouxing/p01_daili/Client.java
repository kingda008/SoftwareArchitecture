package com.baoge.designpattern.jiegouxing.p01_daili;

public class Client {
    public static void main(String[] args) {
        IRentHouse rentHouse = new RentHouse();
        IRentHouse iRentHouseProxy = new IntermediaryProxy(rentHouse);
        iRentHouseProxy.rentHouse();
    }
}
