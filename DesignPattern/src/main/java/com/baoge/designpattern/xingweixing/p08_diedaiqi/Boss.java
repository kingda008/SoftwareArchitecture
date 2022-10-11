package com.baoge.designpattern.xingweixing.p08_diedaiqi;

public class Boss {
    public static void main(String[] args) {
        DepartMing ming = new DepartMing();
        check(ming.iterator());

        DepartHui hui = new DepartHui();
        check(hui.iterator());
    }

    private static void check(Iterator iterator) {
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}
