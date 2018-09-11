package com.minghua.weight2goods.service;

import com.minghua.weight2goods.model.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: minghua
 * @date: 2018/9/11 13:53
 * @modified By:
 */
public class DiscernService {
    /**
     * 每种东西每次最多拿5个
     */
    private static int MAX_COUNT_PER_TIME = 5;

    /**
     * 识别算法
     *
     * @param totalWeight 总重量
     * @return
     */
    public Map<Goods, Integer> discern(List<Goods> goodsList, int totalWeight) {
        if (goodsList.size() == 1) {
            return size1(goodsList, totalWeight);
        }
        if (goodsList.size() == 2) {
            return size2(goodsList, totalWeight);
        }
        if (goodsList.size() == 3) {
            return size3(goodsList, totalWeight);
        }
        return null;
    }

    private Map<Goods, Integer> size1(List<Goods> goodsList, int totalWeight) {
        Map<Goods, Integer> result = new HashMap<>();
        int loopTimes = 0;
        float min = totalWeight;
        for (int i = 0; i <= goodsList.get(0).getCount(); i++) {
            float weight = goodsList.get(0).getWeight() * i;
            float temp = Math.abs(weight - totalWeight);
            System.out.println("组合为：" + i + ",此组合重量为：" + weight + ",当前最小值为：" + min);
            if (temp < min) {
                min = temp;
                System.out.println("替换最小值, " + temp);
                result.put(goodsList.get(0), i);
            }
            loopTimes++;
        }
        System.out.println(loopTimes);
        return result;
    }

    private Map<Goods, Integer> size2(List<Goods> goodsList, int totalWeight) {
        Map<Goods, Integer> result = new HashMap<>();
        int loopTimes = 0;
        float min = totalWeight;
        for (int i = 0; i <= goodsList.get(0).getCount(); i++) {
            for (int j = 0; j <= goodsList.get(1).getCount(); j++) {
                float weight = goodsList.get(0).getWeight() * i + goodsList.get(1).getWeight() * j;
                float temp = Math.abs(weight - totalWeight);
                System.out.println("组合为：" + i + "," + j + "," + ",此组合重量为：" + weight + ",当前最小值为：" + min);
                if (temp < min) {
                    min = temp;
                    System.out.println("替换最小值, " + temp);
                    result.put(goodsList.get(0), i);
                    result.put(goodsList.get(1), j);
                }
                loopTimes++;
            }
        }
        System.out.println(loopTimes);
        return result;
    }

    private Map<Goods, Integer> size3(List<Goods> goodsList, int totalWeight) {
        Map<Goods, Integer> result = new HashMap<>();
        int loopTimes = 0;
        float min = totalWeight;
        for (int i = 0; i <= goodsList.get(0).getCount(); i++) {
            for (int j = 0; j <= goodsList.get(1).getCount(); j++) {
                for (int k = 0; k <= goodsList.get(2).getCount(); k++) {
                    float weight = goodsList.get(0).getWeight() * i + goodsList.get(1).getWeight() * j
                            + goodsList.get(2).getWeight() * k;
                    float temp = Math.abs(weight - totalWeight);
                    System.out.println("组合为：" + i + "," + j + "," + k + ",此组合重量为：" + weight + ",当前最小值为：" + min);
                    if (temp < min) {
                        min = temp;
                        System.out.println("替换最小值, " + temp);
                        result.put(goodsList.get(0), i);
                        result.put(goodsList.get(1), j);
                        result.put(goodsList.get(2), k);
                    }
                    loopTimes++;
                }
            }
        }
        System.out.println(loopTimes);
        return result;
    }
}
