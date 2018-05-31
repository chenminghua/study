package com.minghua.study.mybatis.dao;

import com.minghua.study.mybatis.model.City;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * @author: minghua
 * @date: 2018/5/30 16:11
 * @modified By:
 */
@Component
public class CityDao {
    private final SqlSession sqlSession;

    public CityDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public City selectCityById(long id) {
        return this.sqlSession.selectOne("selectCityById", id);
    }
}
