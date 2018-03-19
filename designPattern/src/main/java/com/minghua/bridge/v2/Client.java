package com.minghua.bridge.v2;

import org.junit.Test;

public class Client {
    @Test
    public void test() {
        House house = new House();
        System.out.println("-------房地产公司是这个样子运行的-------");
        //房产公司
        HouseCrop houseCrop = new HouseCrop(house);
        houseCrop.makeMoney();
        System.out.println("\n");

        //山寨公司生产的产品很多，不过我只要指定产品就成了
        System.out.println("-------山寨公司是这样运行的-------");
        //ShanZhaiCrop shanZhaiCorp = new ShanZhaiCrop(new Clothes());
        ShanZhaiCrop shanZhaiCrop = new ShanZhaiCrop(new IPod());
        shanZhaiCrop.makeMoney();
    }
}
