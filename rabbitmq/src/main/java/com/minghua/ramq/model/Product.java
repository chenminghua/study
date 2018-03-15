package com.minghua.ramq.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-14
 */
@Data
@Accessors(chain = true)
@ToString
public class Product {
    private int id;
    private String name;
    private double price;
}
