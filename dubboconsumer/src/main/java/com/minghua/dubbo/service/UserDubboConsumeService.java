package com.minghua.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.minghua.dubbo.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserDubboConsumeService {
    @Reference(version = "1.0")
    UserService userService;

    public User getUserByName(String name){
        return userService.findUserByName(name);
    }
}
