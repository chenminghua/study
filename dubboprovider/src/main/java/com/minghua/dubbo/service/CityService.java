package com.minghua.dubbo.service;

import com.minghua.dubbo.domain.City;

public interface CityService {
    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);

    String getMyHomeTown(String homeTown);
}
