package com.minghua.bridge.v2;

public class ShanZhaiCrop extends Crop {
    //产什么产品，不知道，等被调用的才知道
    public ShanZhaiCrop(Product product) {
        super(product);
    }

    //狂赚钱
    @Override
    public void makeMoney(){
        super.makeMoney();
        System.out.println("我赚钱呀...");
    }
}
