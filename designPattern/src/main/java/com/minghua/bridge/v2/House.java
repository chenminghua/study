package com.minghua.bridge.v2;

public class House extends Product {
    @Override
    protected void beProduced() {
        System.out.println("生产出的房子是这个样子的...");
    }

    @Override
    protected void beSold() {
        System.out.println("生产出的房子卖出去了...");
    }
}
