package com.minghua.weight2goods.model;

import lombok.Data;
import lombok.ToString;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Goods goods = (Goods) o;
        return Float.compare(goods.weight, weight) == 0 &&
                Float.compare(goods.price, price) == 0 &&
                count == goods.count &&
                Objects.equals(name, goods.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price, count);
    }
}
