package com.minghua.study.swagger2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: minghua
 * @date: 2018/6/6 17:06
 * @modified By:
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    private int sex;
    private String country;
}
