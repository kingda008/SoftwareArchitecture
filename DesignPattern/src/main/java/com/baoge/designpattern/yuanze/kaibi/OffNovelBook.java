package com.baoge.designpattern.yuanze.kaibi;

public class OffNovelBook extends NovelBook {
    public OffNovelBook(String name, int price, String author) {
        super(name, price, author);
    }

    @Override
    public int getPrice() {
        int price = super.getPrice();
        if (price > 50) {
            price = (int) (price * 0.8);
        }else {
            price = (int) (price * 0.9);
        }
        return price;
    }
}
