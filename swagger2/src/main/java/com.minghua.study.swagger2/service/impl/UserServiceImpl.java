package com.minghua.study.swagger2.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.minghua.study.swagger2.model.User;
import com.minghua.study.swagger2.service.UserService;
import com.minghua.study.swagger2.vo.JsonResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: minghua
 * @date: 2018/6/7 8:06
 * @modified By:
 */
@Service
public class UserServiceImpl implements UserService {
    private static final List<User> users = new ArrayList<User>();
    static {
        User user1 =  new User(1, "李1", "li1@qq.com", 1, "中国");
        User user2 =  new User(2, "李2", "li2@qq.com", 0, "中国");
        users.add(user1);
        users.add(user2);
    }
    @Override
    public JsonResponse getUser(int id) {
        if (0 == id) {
            return JsonResponse.fail();
        }
        if (1 != id && 2 != id) {
            return new JsonResponse(200, "未找到", null);
        } else {
            JsonResponse jsonResponse = new JsonResponse();
            jsonResponse.setData(JSONObject.toJSON(users.get(id - 1)));
            return jsonResponse;
        }
    }

    @Override
    public JsonResponse listUsers(Integer sex, String country) {
        JsonResponse jsonResponse = new JsonResponse();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("users", users);
        jsonObject.put("rowCount", users.size());
        jsonResponse.setData(jsonObject);
        return jsonResponse;
    }
}
