package com.minghua.spbtmgdb.domain;

import lombok.Data;

import java.io.InputStream;

/**
 * @author: minghua
 * @date: 2018/6/28 18:25
 * @modified By:
 */
@Data
public class User {
    //头像
    private InputStream image;
    private int id;
    private String name;
    private String email;
}
