package com.minghua.spbtmgdb.service;

import com.minghua.spbtmgdb.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author: minghua
 * @date: 2018/6/28 18:19
 * @modified By:
 */
public interface UserService {
    /**
     * @param user
     * @param ins 头像
     */
    void saveUser(User user, InputStream ins);

    void delete(String sn, String filename);

    User findUser(String id);

    OutputStream findUserAvatar(int id) throws IOException;

    List<User> listUser();
}
