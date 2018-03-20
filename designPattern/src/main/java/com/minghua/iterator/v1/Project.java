package com.minghua.iterator.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Project implements IProject {
    //项目名称
    private String name;
    //项目成员数量
    private int num = 0;
    //项目话费
    private int cost = 0;
    @Override
    public String getProjectInfo() {
        String info = "";
        //获得项目的名称
        info = info+ "项目名称是： " + this.name;
        //获得项目人数
        info = info + "\t项目人数: "+ this.num;
        //项目费用
        info = info+ "\t 项目费用： "+ this.cost;
        return info;
    }
}
