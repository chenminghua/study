package com.minghua.chainOfResponsibility.v1;

public class Son implements IHnadler {
    @Override
    public void handleMessage(Woman woman) {
        System.out.println("母亲的请示是： "+ woman.getRequest());
        System.out.println("儿子的答复是:同意");
    }
}
