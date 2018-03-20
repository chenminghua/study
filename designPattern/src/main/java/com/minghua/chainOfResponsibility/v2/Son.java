package com.minghua.chainOfResponsibility.v2;

import com.minghua.chainOfResponsibility.v1.IWoman;
import com.minghua.chainOfResponsibility.v1.Status;

public class Son extends AbstractHandler {
    public Son() {
        super(Status.WIDOWED);
    }

    @Override
    protected void response(IWoman woman) {
        System.out.println("--------母亲向儿子请示-------");
        System.out.println(woman.getRequest());
        System.out.println("儿子的答复是：同意\n");
    }
}
