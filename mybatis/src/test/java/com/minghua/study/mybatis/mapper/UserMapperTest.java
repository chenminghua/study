package com.minghua.study.mybatis.mapper;

import com.github.pagehelper.Page;
import com.minghua.study.mybatis.model.User;
import minghua.common.utils.P;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author: minghua
 * @date: 2018/6/5 14:45
 * @modified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

}