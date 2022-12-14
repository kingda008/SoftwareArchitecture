package com.baoge.sx03_annotation;

public class AnnotationDemo {
    @MyAnnotataion(name = "lvr", website = "hello", revision = 1)
    public static void main(String[] args) {
        System.out.println("I am main method");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MyAnnotataion(name = "lvr", website = "hello", revision = 2)
    public void demo() {
        System.out.println("I am demo method");
    }
}
