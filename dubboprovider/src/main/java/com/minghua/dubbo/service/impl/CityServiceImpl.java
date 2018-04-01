package com.minghua.dubbo.service.impl;

import com.minghua.dubbo.domain.City;
import com.minghua.dubbo.service.CityService;
import org.springframework.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class CityServiceImpl implements CityService {
    @Override
    public City findCityByName(String cityName) {
        if (StringUtils.isEmpty(cityName)) {
            return null;
        }
        City city = new City();
        city.setCityName(cityName);
        return city;
    }

    @Override
    public String getMyHomeTown(String homeTown) {
        return "我的家乡是：" + homeTown;
    }


}
