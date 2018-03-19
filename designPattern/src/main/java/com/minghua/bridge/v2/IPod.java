package com.minghua.bridge.v2;

public class IPod extends Product {
    @Override
    protected void beProduced() {
        System.out.println("生产出的iPod是这个样子的...");
    }

    @Override
    protected void beSold() {
        System.out.println("生产出的iPod卖出去了...");
    }

}
