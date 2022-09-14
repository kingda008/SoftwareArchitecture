package com.baoge.designpattern.yuanze.dimite.v2;

import java.util.List;

public class GroupLeader {
    private List<Girl> girls;

    public GroupLeader(List<Girl> girlList) {
        girls = girlList;
    }

    //  清点数量
    public void countGirls() {
        System.out.println("女神数量为：" + girls.size());
    }
}
