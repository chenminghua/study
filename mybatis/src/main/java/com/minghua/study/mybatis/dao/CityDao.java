package com.minghua.study.mybatis.dao;

import com.minghua.study.mybatis.model.City;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;
import java.util.Map;

/**
 * @author: minghua
 * @date: 2018/5/31 10:06
 * @modified By:
 */
public interface CityDao {
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

}
