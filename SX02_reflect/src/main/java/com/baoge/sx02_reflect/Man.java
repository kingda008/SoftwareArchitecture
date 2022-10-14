package com.baoge.sx02_reflect;

public class Man  extends Person{
    private String name;
    public String school;

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
