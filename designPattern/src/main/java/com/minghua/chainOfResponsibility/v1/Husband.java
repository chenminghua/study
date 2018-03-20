package com.minghua.chainOfResponsibility.v1;

public class Husband implements IHnadler {
    @Override
    public void handleMessage(Woman woman) {
        System.out.println("妻子的请示是： "+ woman.getRequest());
        System.out.println("丈夫的答复是:同意");
    }
}
