package com.minghua.study.mybatis;

import com.minghua.study.mybatis.data.CityMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: minghua
 * @date: 2018/5/30 16:09
 * @modified By:
 */
@SpringBootApplication
public class App implements CommandLineRunner {
    private final CityMapper cityMapper;

    public App(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cityMapper.findById(1));
    }
}
