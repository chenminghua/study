package com.minghua.study.swagger.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: minghua
 * @date: 2018/5/30 17:41
 * @modified By:
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String province;
    private String country;
}
