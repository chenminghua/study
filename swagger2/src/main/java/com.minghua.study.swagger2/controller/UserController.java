package com.minghua.study.swagger2.controller;

import com.minghua.study.swagger2.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: minghua
 * @date: 2018/6/6 17:03
 * @modified By:
 */
@RestController
@RequestMapping("/user")
@Api("User相关的API")
public class UserController {
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User index(@PathVariable(value = "id") int id) {
        User user1 =  new User(1, "李1", "li1@qq.com", 1, "中国");
        User user2 =  new User(2, "李2", "li2@qq.com", 0, "中国");
        User user = null;
        switch (id) {
            case 1:
                user = user1;
                break;
            case 2:
                user = user2;
                break;
            default:
                user = user1;
        }
        return user;
    }

    @ApiOperation(value = "根据条件获取用户列表", notes = "根据不同条件查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sex", value = "性别", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "country", value = "国家", dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> users(Integer sex, String country) {
        System.out.println(sex);
        System.out.println(country);
        User user1 =  new User(1, "李1", "li1@qq.com", 1, "中国");
        User user2 =  new User(2, "李2", "li2@qq.com", 0, "中国");
        List<User> users = new ArrayList<User>(2);
        users.add(user1);
        users.add(user2);
        return users;
    }
}
