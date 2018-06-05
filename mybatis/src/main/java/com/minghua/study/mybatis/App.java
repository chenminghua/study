package com.minghua.study.mybatis;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: minghua
 * @date: 2018/5/30 16:09
 * @modified By:
 */
/*
exclude：自动注册会导致产生"系统中发现了多个分页插件，请检查系统配置!"的错误信息，排除自动注册即可。
 */
@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
@MapperScan("com.minghua.study.mybatis.mapper")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
