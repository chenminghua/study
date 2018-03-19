package com.minghua.bridge.v1;

public abstract class Crop {
    protected abstract void produce();
    protected abstract void sell();

    public void makeMoney(){
        this.produce();
        this.sell();
    }
}
