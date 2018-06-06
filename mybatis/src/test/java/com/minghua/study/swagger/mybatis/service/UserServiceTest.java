package com.minghua.study.swagger.mybatis.service;

import com.github.pagehelper.Page;
import com.minghua.study.mybatis.model.User;
import com.minghua.study.swagger.mybatis.model.User;
import minghua.common.utils.P;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

/**
 * @author: minghua
 * @date: 2018/6/5 14:23
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void findByPage() {
        Page<User> userPage = userService.findByPage(1,10);
        P.rintln(userPage.getTotal());
        P.rintln(userPage);
        Assert.assertEquals(10, userPage.getResult().size());
    }
}