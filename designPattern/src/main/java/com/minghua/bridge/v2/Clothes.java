package com.minghua.bridge.v2;

public class Clothes extends Product {
    @Override
    protected void beProduced() {
        System.out.println("生产出的衣服是这个样子的...");
    }

    @Override
    protected void beSold() {
        System.out.println("生产出的衣服卖出去了...");
    }
}
