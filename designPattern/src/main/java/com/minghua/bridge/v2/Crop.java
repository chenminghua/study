package com.minghua.bridge.v2;

public abstract class Crop {
    private Product product;

    public Crop(Product product){
        this.product = product;
    }

    public void makeMoney(){
        this.product.beProduced();
        this.product.beSold();
    }
}
