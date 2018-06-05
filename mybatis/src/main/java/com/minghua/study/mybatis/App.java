package com.minghua.study.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: minghua
 * @date: 2018/5/30 16:09
 * @modified By:
 */
@SpringBootApplication
@MapperScan("com.minghua.study.mybatis.mapper")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
