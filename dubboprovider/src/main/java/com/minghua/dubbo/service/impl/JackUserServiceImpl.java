package com.minghua.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.minghua.dubbo.domain.User;
import com.minghua.dubbo.service.UserService;

@Service(version = "1.0", group = "jack")
public class JackUserServiceImpl implements UserService {
    @Override
    public User findUserByName(String name) {
        User user = null;
        if ("jack".equals(name)) {
            user = new User("jack", "jack@qq.com" , 52);
        } else {
            System.out.println("要查找的用户不存在！" + name);
        }
        return user;
    }
}
