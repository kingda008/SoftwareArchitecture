package com.baoge.designpattern.xingweixing.p08_diedaiqi;

import java.util.List;

public class MingIterator implements Iterator {
    private List<Employee> list;
    private int position;

    public MingIterator(List<Employee> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return !(position > list.size() - 1 || list.get(position) == null);
    }

    @Override
    public Object next() {
        Employee e = list.get(position);
        position++;
        return e;
    }
}
