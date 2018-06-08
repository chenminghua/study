package com.minghua.study.swagger2.service;

import com.minghua.study.swagger2.model.User;
import com.minghua.study.swagger2.vo.JsonResponse;

import java.util.List;

/**
 * @author: minghua
 * @date: 2018/6/7 8:05
 * @modified By:
 */
public interface UserService {

    /**
     * @param id
     * @return
     */
    JsonResponse getUser(int id);

    /**
     * @param sex
     * @param country
     * @return
     */
   JsonResponse listUsers(Integer sex, String country);
}
