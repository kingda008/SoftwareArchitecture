package com.baoge.designpattern.xingweixing.p08_diedaiqi;

import java.util.ArrayList;
import java.util.List;

public class DepartMing implements Depart {
    private List<Employee> employeeList = new ArrayList<>();

    public DepartMing(){
        employeeList.add(new Employee("aa",12));
        employeeList.add(new Employee("bb",13));
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }
    @Override
    public Iterator iterator() {
        return new MingIterator(employeeList);
    }
}
