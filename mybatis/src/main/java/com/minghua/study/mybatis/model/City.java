package com.minghua.study.mybatis.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: minghua
 * @date: 2018/5/30 17:41
 * @modified By:
 */
@Data
@ToString
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String state;
    private String country;
}
