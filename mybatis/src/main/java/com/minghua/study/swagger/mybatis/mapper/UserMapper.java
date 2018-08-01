package com.minghua.study.swagger.mybatis.mapper;

import com.minghua.study.swagger.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;

/**
 * @author: minghua
 * @date: 2018/6/5 13:59
 * @modified By:
 */
@Mapper
public interface UserMapper {

    /**
     * @return
     */
    Page<User> listUsers();
}
