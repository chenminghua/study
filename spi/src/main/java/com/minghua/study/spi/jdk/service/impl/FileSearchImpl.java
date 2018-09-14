package com.minghua.study.spi.jdk.service.impl;

import com.minghua.study.spi.jdk.service.ISearch;

/**
 * @author: minghua
 * @date: 2018/9/6 11:30
 * @modified By:
 */
public class FileSearchImpl implements ISearch {
    @Override
    public void search() {
        System.out.println("文件中搜索！");
    }
}
