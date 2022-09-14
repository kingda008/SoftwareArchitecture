package com.baoge.designpattern.yuanze.dimite.v2;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        List<Girl> girls = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            girls.add(new Girl());
        }
        GroupLeader leader = new GroupLeader(girls);
        teacher.commond(leader);
    }
}
