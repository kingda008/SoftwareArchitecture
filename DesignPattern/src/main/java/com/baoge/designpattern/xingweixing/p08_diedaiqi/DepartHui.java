package com.baoge.designpattern.xingweixing.p08_diedaiqi;

import java.util.ArrayList;
import java.util.List;

public class DepartHui implements Depart {
    private Employee[] employees = new Employee[3];

    public DepartHui(){
        employees[0] = new Employee("cc",12);
        employees[1] = new Employee("dd",122);
    }

    public Employee[] getEmployeeList(){
        return employees;
    }
    @Override
    public Iterator iterator() {
        return new HuiIterator(employees);
    }
}
