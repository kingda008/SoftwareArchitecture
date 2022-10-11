package com.baoge.designpattern.jiegouxing.p02_zuhe.anquan;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private List<Component> components = new ArrayList<>();
    public Composite(String name) {
        super(name);
    }

    @Override
    public void doSomething() {
        System.out.println(name);
        for(Component c:components){
            c.doSomething();
        }
    }

    public void addChild(Component component){
        components.add(component);
    }

    public void removeChild(Component component){
        components.remove(component);
    }
    public Component getChild(int index){
        return components.get(index);
    }

}
