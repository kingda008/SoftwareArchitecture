package com.baoge.designpattern.chuangjianxing.p03_build;

/**
 * 具体产品类
 */
public class MacBook extends Computer {
    protected MacBook(){}

    @Override
    public void setOs( ) {
        os = "Mac OS X 10.10";
    }
}
