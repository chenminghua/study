package com.minghua.springboot.jpa.web;

import com.alibaba.fastjson.JSON;
import com.minghua.springboot.jpa.dao.DeptRepository;
import com.minghua.springboot.jpa.dao.UserRepository;
import com.minghua.springboot.jpa.dto.NewUserDTO;
import com.minghua.springboot.jpa.model.Departement;
import com.minghua.springboot.jpa.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(MySqlController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeptRepository deptRepository;

    @RequestMapping("getUsers")
    List<User> getUsers(){
        return userRepository.findAll();
    }

    //localhost:8080/mysql/getUser/1
    @RequestMapping(value="getUser/{id}",method= RequestMethod.GET)
    User getUser(@PathVariable int id){
        return  userRepository.findOne(id);
    }

    @RequestMapping(value = "saveUserUseForm", method = RequestMethod.POST)
    User saveUserUseForm(String name, String email, int dept){
        LOGGER.info("get param is :{},{},{}", name, email, dept);
        Departement departement = deptRepository.findOne(dept);
        return userRepository.save(new User(name, email, departement));
    }

    @RequestMapping(value = "saveUserUseJson", method = RequestMethod.POST)
    User saveUserUseJson(@RequestBody String jsonParam){
        LOGGER.info("get param is :{}", jsonParam);
        NewUserDTO userDTO = JSON.parseObject(jsonParam, NewUserDTO.class);
        Departement departement = deptRepository.findOne(userDTO.getDept());
        User user = new User(userDTO.getName(), userDTO.getEmail(), departement);
        return userRepository.save(user);
    }

}
