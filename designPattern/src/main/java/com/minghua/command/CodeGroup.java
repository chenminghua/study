package com.minghua.command;

import minghua.utils.P;

public class CodeGroup extends Group {
    @Override
    public void find() {
        P.rintln("找到代码开发组");
    }

    @Override
    public void add() {
        P.rintln("增加代码");
    }

    @Override
    public void delete() {
        P.rintln("删除代码");
    }

    @Override
    public void change() {
        P.rintln("修改代码");
    }
}
