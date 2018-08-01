package com.minghua.study.swagger.mybatis.service;

import com.github.pagehelper.Page;

import com.minghua.study.swagger.mybatis.model.User;

/**
 * @author: minghua
 * @date: 2018/6/5 14:16
 * @modified By:
 */
public interface UserService {
    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    Page<User> findByPage(int pageNo, int pageSize);
}
