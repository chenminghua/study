package com.minghua.springboot.jpa.dao;

import com.minghua.springboot.jpa.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-29
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    User findOne(int id);
    User save(User user);
    void delete(int id);
}
