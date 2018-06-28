package com.minghua.springboot.service.impl;

import com.minghua.springboot.jpa.model.User;
import com.minghua.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: minghua
 * @date: 2018/6/28 14:09
 * @modified By:
 */
@Service("myUserService")
public class MyUserServiceImpl implements UserService {
    @Override
    public User findUser(int id) {
        User user = new User();
        user.setName("小花");
        user.setEmail("vip@qq.com");
        user.setId(id);
        return user;
    }
}
