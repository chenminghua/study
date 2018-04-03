package com.minghua.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.minghua.dubbo.domain.User;
import com.minghua.dubbo.service.UserService;

@Service(version = "1.0")
public class UserServiceImpl implements UserService {
    @Override
    public User findUserByName(String name) {
        User user = null;
        if ("qiushui".equals(name)) {
            user = new User("qiushui", "minghua.cc@qq.com" , 25);
        } else {
            System.out.println("要查找的用户不存在！");
        }
        return user;
    }

}
