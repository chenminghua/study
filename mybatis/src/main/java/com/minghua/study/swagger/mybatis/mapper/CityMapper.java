package com.minghua.study.swagger.mybatis.mapper;

import com.minghua.study.swagger.mybatis.model.City;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


/**
 * @author: minghua
 * @date: 2018/5/31 10:06
 * @modified By:
 */
public interface CityMapper {
    /**
     * 根据id查找city
     * 使用注解
     * @param cId
     * @return
     */
    @Select("select id,name,province, country from city where id=#{id}")
    City findById(@Param("id") int cId);
    /**
     * find bity by city name.
     * @param name
     * @return
     */
    City findByName(@Param("name") String name);

    /**
     * 查找指定省份的城市
     * @param provinceName
     * @return
     */
    List<City> listByProvinceName(@Param("provinceName") String provinceName);

    /**
     * 查找指定省份的城市
     * 反馈map格式，key为城市名称
     * @param provinceName
     * @return
     */
    @MapKey("name")
    Map<String, City> findCitiesByProvinceWithMap(@Param("provinceName") String provinceName);

    /**
     * save new city.
     * @param city
     * @return
     */
    boolean save(City city);


    /**
     * update city info
     * @param city
     * @return
     */
    boolean update(City city);


    /**
     * delete city by id
     * @param id
     * @return
     */
    boolean delete(int id);


    /**
     *模糊查询
     * @return
     */
    List<City> listCitiesByName(String name);
}
