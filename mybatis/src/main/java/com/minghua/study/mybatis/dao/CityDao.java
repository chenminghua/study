package com.minghua.study.mybatis.dao;

import com.minghua.study.mybatis.model.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * save new city.
     * @param city
     * @return
     */
    boolean save(City city);

}
