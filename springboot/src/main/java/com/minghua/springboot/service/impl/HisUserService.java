package com.minghua.springboot.service.impl;

import com.minghua.springboot.jpa.model.User;
import com.minghua.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: minghua
 * @date: 2018/6/28 14:10
 * @modified By:
 */
@Service("hisUserService")
public class HisUserService implements UserService {
    @Override
    public User findUser(int id) {
        User user = new User();
        user.setName("如花");
        user.setEmail("vip@163.com");
        user.setId(id);
        return user;
    }
}
