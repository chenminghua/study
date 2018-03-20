package com.minghua.chainOfResponsibility.v2;

import com.minghua.chainOfResponsibility.v1.IWoman;
import com.minghua.chainOfResponsibility.v1.Status;

public class Husband extends AbstractHandler {
    public Husband() {
        super(Status.MARRIED);
    }

    @Override
    protected void response(IWoman woman) {
        System.out.println("--------妻子向丈夫请示-------");
        System.out.println(woman.getRequest());
        System.out.println("丈夫的答复是：同意\n");
    }
}
