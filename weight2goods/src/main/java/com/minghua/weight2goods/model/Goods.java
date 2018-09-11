package com.minghua.weight2goods.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author: minghua
 * @date: 2018/9/11 13:40
 * @modified By:
 */
@ToString
public class Goods {
    private String name;
    private float weight;
    private float price;
    /**
     * 数量
     */
    private int count;

    public Goods(String name, float weight, float price, int count) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
