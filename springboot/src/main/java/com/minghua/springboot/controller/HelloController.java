package com.minghua.springboot.controller;

import com.minghua.springboot.jpa.dao.DeptRepository;
import com.minghua.springboot.jpa.dao.UserRepository;
import com.minghua.springboot.jpa.model.Departement;
import com.minghua.springboot.jpa.model.User;
import com.minghua.springboot.jpa.web.MySqlController;
import com.minghua.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-15
 */
@RestController
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeptRepository deptRepository;

    //@Resource(name = "myUserService")
    //@Resource(name = "hisUserService")
    // private UserService userService;

    @Autowired
    private Map<String, UserService> userServiceMap;


    @RequestMapping(value = "/hello/{implMethod}", method = RequestMethod.GET)
    String home(@PathVariable String implMethod) {
        LOGGER.info("get param is :{}", implMethod);
        LOGGER.info("注入大小：" + userServiceMap.size());
        if ("my".equalsIgnoreCase(implMethod)) {
            return userServiceMap.get("myUserService").findUser(1).toString();
        } else if ("his".equalsIgnoreCase(implMethod)){
            return userServiceMap.get("hisUserService").findUser(1).toString();
        } else {
            return "ERROR";
        }

    }

    @RequestMapping(value = "/saveUserUseForm", method = RequestMethod.POST)
    User saveUserUseForm(String name, String email, int dept){
        LOGGER.info("get param is :{},{},{}", name, email, dept);
        Departement departement = deptRepository.findOne(dept);
        return userRepository.save(new User(name, email, departement));
    }
}
