package com.minghua.study.mybatis.mapper;

import com.minghua.study.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
