package com.minghua.study.swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-15
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class Swagger {
    public static void main(String[] args) {
        SpringApplication.run(Swagger.class, args);
    }
}
