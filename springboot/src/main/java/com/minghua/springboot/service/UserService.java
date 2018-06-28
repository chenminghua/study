package com.minghua.springboot.service;

import com.minghua.springboot.jpa.model.User;

/**
 * @author: minghua
 * @date: 2018/6/28 14:08
 * @modified By:
 */
public interface UserService {
    /**
     * find user.
     * @param id
     * @return
     */
    User findUser(int id);
}
