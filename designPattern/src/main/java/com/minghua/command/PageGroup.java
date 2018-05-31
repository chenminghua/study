package com.minghua.command;


import minghua.common.utils.P;

public class PageGroup extends Group {
    @Override
    public void find() {
        P.rintln("找到页面组");
    }

    @Override
    public void add() {
        P.rintln("添加页面");
    }

    @Override
    public void delete() {
        P.rintln("删除页面");
    }

    @Override
    public void change() {
        P.rintln("修改页面");
    }
}
