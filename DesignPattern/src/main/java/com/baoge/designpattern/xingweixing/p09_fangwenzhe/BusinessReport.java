package com.baoge.designpattern.xingweixing.p09_fangwenzhe;

import java.util.ArrayList;
import java.util.List;

public class BusinessReport {
    private List<Staff> mStaffs = new ArrayList<>();

    public BusinessReport(){
        mStaffs.add(new Manager("王经理"));
        mStaffs.add(new Engineer("张工"));
    }

    public void showReport(Visitor visitor){
        for(Staff staff:mStaffs){
            staff.accept(visitor);
        }
    }
}
