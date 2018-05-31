package com.minghua.study.mybatis.dao;

import com.minghua.study.mybatis.model.City;
import minghua.common.utils.P;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: minghua
 * @date: 2018/5/31 10:25
 * @modified By:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityDaoTest {
    @Autowired
    private CityDao cityDao;

    @Test
    public void findByName() {
        String cityName = "绵阳";
        City city = cityDao.findByName(cityName);
        P.rintln(city);
    }

    @Test
    public void listByProvince() {
        String provinceName = "四川";
        List<City> cities = cityDao.listByProvinceName(provinceName);
        cities.forEach(city -> {
            P.rintln(city);
        });
    }


    @Test
    @Transactional
    public void save() {
        City city = new City();
        String cname = "兰州";
        String pname = "甘肃";
        city.setName(cname);
        city.setProvince(pname);
        city.setCountry("中国");
        boolean result = cityDao.save(city);
        P.rintln(result);
        City savedCity = cityDao.findByName(cname);

        Assert.assertTrue(result);
        Assert.assertEquals(cname, savedCity.getName());
    }
}