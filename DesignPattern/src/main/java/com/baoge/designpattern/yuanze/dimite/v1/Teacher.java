package com.baoge.designpattern.yuanze.dimite.v1;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    //老师发布清点v女生命令
    public void commond(GroupLeader leader){
        List<Girl> girls = new ArrayList<>();
        for(int i=0;i<20;i++){
            girls.add(new Girl());
        }
        leader.countGirls(girls);
    }
}
