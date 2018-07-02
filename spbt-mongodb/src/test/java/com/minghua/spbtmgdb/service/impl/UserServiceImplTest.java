package com.minghua.spbtmgdb.service.impl;

import com.minghua.spbtmgdb.domain.User;
import com.minghua.spbtmgdb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: minghua
 * @date: 2018/7/2 13:24
 * @modified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void saveUser() {
        File file = new File("D:\\var\\image\\111.png");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setEmail("minghua.cc@qq.com");
        user.setName("Dash");
        userService.saveUser(user, inputStream);
    }

    @Test
    public void delete() {
        userService.delete("","");
    }

    @Test
    public void findUser() {
        User user  = userService.findUser("5b398ec5db8eb1139b528409");
        LOGGER.info("从mongodb中查询到的数据：" + user.toString());
    }

    @Test
    public void listUser() {
        List<User> users = userService.listUser();
        LOGGER.info("从mongdb中查询到的数据： " + users.toString());
    }
}