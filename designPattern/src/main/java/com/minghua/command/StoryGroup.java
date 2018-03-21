package com.minghua.command;

import minghua.utils.P;

public class StoryGroup extends Group {
    @Override
    public void find() {
        P.rintln("找到需求组");
    }

    @Override
    public void add() {
        P.rintln("增加需求");
    }

    @Override
    public void delete() {
        P.rintln("删除需求");
    }

    @Override
    public void change() {
        P.rintln("改变需求组");
    }
}
