package com.minghua.bridge.v1;

public class IPodCrop extends Crop {
    @Override
    protected void produce() {
        System.out.println("我生产iPod...");
    }

    @Override
    protected void sell() {
        System.out.println("iPod畅销...");
    }


    @Override
    //狂赚钱
    public void makeMoney(){
        super.makeMoney();
        System.out.println("我赚钱呀...");
    }
}
