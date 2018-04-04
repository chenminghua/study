package com.minghua.dubbo;

import com.minghua.dubbo.domain.User;
import com.minghua.dubbo.service.CityDubboConsumeService;
import com.minghua.dubbo.service.UserDubboConsumeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args){
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, args);
        CityDubboConsumeService cityService = run.getBean(CityDubboConsumeService.class);
        cityService.printCity();
        cityService.printMyHometown();

        UserDubboConsumeService userService = run.getBean(UserDubboConsumeService.class);
        User user1 = userService.getUserByName("qiushui");
        User user2 = userService.getUserByName("jack");
        System.out.println(user1);
        System.out.println(user2);
    }
}
