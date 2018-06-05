package com.minghua.study.mybatis.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: minghua
 * @date: 2018/5/30 13:30
 * @modified By:
 */
@Data
@ToString
public class User implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    private int id;
    private int age;
    private String name;
    private Date createTime;
    private Date updateTime;
}
