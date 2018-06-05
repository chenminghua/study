package com.minghua.study.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.minghua.study.mybatis.mapper.UserMapper;
import com.minghua.study.mybatis.model.User;
import com.minghua.study.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: minghua
 * @date: 2018/6/5 14:16
 * @modified By:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userMapper.listUsers();
    }
}
