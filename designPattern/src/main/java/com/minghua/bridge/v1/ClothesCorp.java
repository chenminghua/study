package com.minghua.bridge.v1;

public class ClothesCorp extends Crop {
    @Override
    protected void produce() {
        System.out.println("服装公司生产衣服...");
    }

    @Override
    protected void sell() {
        System.out.println("服装公司出售衣服...");
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("服装公司赚小钱...");
    }
}
