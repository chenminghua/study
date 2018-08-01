package com.minghua.study.kafka.controller;

import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: minghua
 * @date: 2018/7/5 18:06
 * @modified By:
 */
@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User findUser(@PathVariable int id) {
        User user = new User();
        user.setId(id);
        user.setAge(id * 10);
        user.setUserName("username." + id);
        return user;
    }

    @RequestMapping(path = "/user/save", method = RequestMethod.POST)
    public User saveUser(User user) {
        System.out.println(user.toString());
        LOGGER.info(user.toString());
        return user;
    }
}
