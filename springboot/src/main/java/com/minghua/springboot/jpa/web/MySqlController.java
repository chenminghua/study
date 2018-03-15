package com.minghua.springboot.jpa.web;

import com.minghua.springboot.jpa.model.User;
import com.minghua.springboot.jpa.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-29
 */
@RestController
@RequestMapping("/mysql")
public class MySqlController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("getUsers")
    List<User> getUsers(){
        return userRepository.findAll();
    }

    //localhost:8080/mysql/getUser/1
    @RequestMapping(value="getUser/{id}",method= RequestMethod.GET)
    User getUser(@PathVariable int id){
        return  userRepository.findOne(id);
    }

}
