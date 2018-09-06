package com.minghua.study.spi.service.impl;

import com.minghua.study.spi.service.ISearch;

/**
 * @author: minghua
 * @date: 2018/9/6 11:31
 * @modified By:
 */
public class DbSearchImpl implements ISearch {
    @Override
    public void search() {
        System.out.println("DB内搜索！");
    }
}
