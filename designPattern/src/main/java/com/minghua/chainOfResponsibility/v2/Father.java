package com.minghua.chainOfResponsibility.v2;

import com.minghua.chainOfResponsibility.v1.IWoman;
import com.minghua.chainOfResponsibility.v1.Status;

public class Father extends AbstractHandler {
    public Father() {
        super(Status.SINGLE);
    }

    @Override
    protected void response(IWoman woman) {
        System.out.println("--------女儿向父亲请示-------");
        System.out.println(woman.getRequest());
        System.out.println("父亲的答复是:同意\n");
    }
}
