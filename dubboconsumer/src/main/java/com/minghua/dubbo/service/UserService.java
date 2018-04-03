package com.minghua.dubbo.service;

import com.minghua.dubbo.domain.User;

public interface UserService {

    /**
     * find user by username.
     * @param name
     * @return
     */
    User findUserByName(String name);
}
