package com.baoge.sx01_generic;

public class Client {
    public static void main(String[] args) {
        Container<String, String> container1 = new Container<>("abc", "efg");
        Container<Integer, Integer> container2 = new Container(111, 222);

        System.out.println(container1.getKey()+container1.getValue());
        System.out.println(container2.getKey()+container2.getValue());
    }
}
