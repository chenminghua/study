package com.minghua.study.mybatis.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author: minghua
 * @date: 2018/5/30 13:30
 * @modified By:
 */
@Data
@ToString
public class User {
    private int id;
    private String name;
    private String userName;
    private String password;
}
