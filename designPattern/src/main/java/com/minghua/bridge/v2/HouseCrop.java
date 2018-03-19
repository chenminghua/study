package com.minghua.bridge.v2;

public class HouseCrop extends Crop {

    public HouseCrop(House house) {
        super(house);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了...");
    }
}
