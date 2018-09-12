package com.minghua.weight2goods.service;

import com.minghua.weight2goods.model.Goods;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: minghua
 * @date: 2018/9/11 13:36
 * @modified By:
 */
public class DiscernServiceTest {
    List<Goods> goodsList = new ArrayList<>();
    DiscernService discernService = new DiscernService();

    private void getGoodsListSize1() {
        goodsList.add(new Goods("农夫山泉", 580F, 3.0F, 7));
    }

    private void getGoodsListSize2() {
        goodsList.add(new Goods("农夫山泉", 580F, 3.0F, 7));
        goodsList.add(new Goods("百事可乐", 370F, 4.5F, 10));
    }

    private void getGoodsListSize3() {
        goodsList.add(new Goods("农夫山泉", 580F, 3.0F, 7));
        goodsList.add(new Goods("百事可乐", 370F, 4.5F, 10));
        goodsList.add(new Goods("雪碧", 358F, 4.0F, 2));
    }

    @Test
    public void testDiscern() {
        int totalWeight = 742;
        System.out.println("售货机内当前的商品为：");
        getGoodsListSize3();
        goodsList.forEach(good -> System.out.println(good.toString()));

        long startTime = System.currentTimeMillis();
        Map<Goods, Integer> result = discernService.discern(goodsList, totalWeight);
        long endTime = System.currentTimeMillis();

        System.out.println("变化总重量：" + totalWeight);
        result.forEach((k, v) -> {
            System.out.print(k.toString());
            System.out.println("，数量：" + v);
        });

        System.out.println("计算总共耗时：" + (endTime - startTime) + "ms");
    }


}
