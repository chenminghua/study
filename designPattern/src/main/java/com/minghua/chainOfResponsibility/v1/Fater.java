package com.minghua.chainOfResponsibility.v1;

public class Fater implements IHnadler {
    /**
     * 未嫁女请示
     * @param woman
     */
    @Override
    public void handleMessage(Woman woman) {
        System.out.println("女儿的请示是： "+ woman.getRequest());
        System.out.println("父亲的答复是:同意");
    }
}
