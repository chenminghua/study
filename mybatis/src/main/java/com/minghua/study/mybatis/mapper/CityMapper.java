package com.minghua.study.mybatis.mapper;

import com.minghua.study.mybatis.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: minghua
 * @date: 2018/5/30 17:45
 * @modified By:
 */
@Mapper
public interface CityMapper {
    @Select("select * from city where name = #{name}")
    City findByState(@Param("name") String name);
}
