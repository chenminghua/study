package com.minghua.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.minghua.dubbo.domain.City;
import org.springframework.stereotype.Component;

@Component
public class CityDubboConsumeService {
    @Reference(version = "1.0.0")
    CityService cityService;

    public void printCity() {
        String cityName="温岭";
        City city = cityService.findCityByName(cityName);
        System.out.println(city.toString());
    }

    public void printMyHometown(){
        System.out.println(cityService.getMyHomeTown("甘肃省华亭县"));
    }
}
