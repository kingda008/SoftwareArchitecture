package com.baoge.designpattern.jiegouxing.p02_zuhe.anquan;

public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void doSomething() {
        System.out.println(name);

    }
}
