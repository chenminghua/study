package com.minghua.weight2goods.service;

import com.minghua.weight2goods.model.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: minghua
 * @date: 2018/9/11 13:53
 * @modified By:
 */
public class DiscernService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DiscernService.class);
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
        if (null == goodsList || goodsList.size() == 0) {
            LOGGER.info("当前售货机内无商品");
            return null;
        }
        if (totalWeight <= 0) {
            LOGGER.warn("总重量为非正数，" + totalWeight);
            return null;
        }
        Map<Goods, Integer> result = null;
        switch (goodsList.size()) {
            case 1:
                result = size1(goodsList, totalWeight);
                break;
            case 2:
                result = size2(goodsList, totalWeight);
                break;
            case 3:
                result = size3(goodsList, totalWeight);
                break;
            default:
                LOGGER.warn("不支持三种以上商品！");
        }
        return result;
    }

    /**
     * 针对一种商品
     *
     * @param goodsList
     * @param totalWeight
     * @return
     */
    private Map<Goods, Integer> size1(List<Goods> goodsList, int totalWeight) {
        Map<Goods, Integer> result = new HashMap<>(1);
        int loopTimes = 0;
        float min = totalWeight;
        Goods goods = goodsList.get(0);
        int loopSize = MAX_COUNT_PER_TIME < goods.getCount() ? MAX_COUNT_PER_TIME : goods.getCount();
        for (int i = 0; i <= loopSize; i++) {
            float weight = goods.getWeight() * i;
            float temp = Math.abs(weight - totalWeight);
            LOGGER.info("组合为：" + i + ",此组合重量为：" + weight + ",当前最小值为：" + min);
            if (temp < min) {
                min = temp;
                LOGGER.debug("替换最小值, " + temp);
                result.put(goods, i);
            }
            loopTimes++;
        }
        LOGGER.debug(loopTimes + "");
        return result;
    }

    /**
     * 针对两种商品
     *
     * @param goodsList
     * @param totalWeight
     * @return
     */
    private Map<Goods, Integer> size2(List<Goods> goodsList, int totalWeight) {
        Map<Goods, Integer> result = new HashMap<>(2);
        int loopTimes = 0;
        float min = totalWeight;
        Goods goodsI = goodsList.get(0);
        Goods goodsJ = goodsList.get(1);
        int loopISize = MAX_COUNT_PER_TIME < goodsI.getCount() ? MAX_COUNT_PER_TIME : goodsI.getCount();
        int loopJSize = MAX_COUNT_PER_TIME < goodsJ.getCount() ? MAX_COUNT_PER_TIME : goodsJ.getCount();
        for (int i = 0; i <= loopISize; i++) {
            for (int j = 0; j <= loopJSize; j++) {
                float weight = goodsI.getWeight() * i + goodsJ.getWeight() * j;
                float temp = Math.abs(weight - totalWeight);
                LOGGER.info("组合为：" + i + "," + j + ",此组合重量为：" + weight + ",当前最小值为：" + min);
                if (temp < min) {
                    min = temp;
                    LOGGER.debug("替换最小值, " + temp);
                    result.put(goodsI, i);
                    result.put(goodsJ, j);
                }
                loopTimes++;
            }
        }
        LOGGER.debug(loopTimes + "");
        return result;
    }

    /**
     * 针对三种商品
     *
     * @param goodsList
     * @param totalWeight
     * @return
     */
    private Map<Goods, Integer> size3(List<Goods> goodsList, int totalWeight) {
        Map<Goods, Integer> result = new HashMap<>(3);
        int loopTimes = 0;
        float min = totalWeight;
        Goods goodsI = goodsList.get(0);
        Goods goodsJ = goodsList.get(1);
        Goods goodsK = goodsList.get(2);
        int loopISize = MAX_COUNT_PER_TIME < goodsI.getCount() ? MAX_COUNT_PER_TIME : goodsI.getCount();
        int loopJSize = MAX_COUNT_PER_TIME < goodsJ.getCount() ? MAX_COUNT_PER_TIME : goodsJ.getCount();
        int loopKSize = MAX_COUNT_PER_TIME < goodsK.getCount() ? MAX_COUNT_PER_TIME : goodsK.getCount();
        for (int i = 0; i <= loopISize; i++) {
            for (int j = 0; j <= loopJSize; j++) {
                for (int k = 0; k <= loopKSize; k++) {
                    float weight = goodsI.getWeight() * i + goodsJ.getWeight() * j
                            + goodsK.getWeight() * k;
                    float temp = Math.abs(weight - totalWeight);
                    LOGGER.info("组合为：" + i + "," + j + "," + k + ",此组合重量为：" + weight + ",当前最小值为：" + min);
                    if (temp < min) {
                        min = temp;
                        LOGGER.debug("替换最小值, " + temp);
                        result.put(goodsI, i);
                        result.put(goodsJ, j);
                        result.put(goodsK, k);
                    }
                    loopTimes++;
                }
            }
        }
        LOGGER.debug(loopTimes + "");
        return result;
    }
}
