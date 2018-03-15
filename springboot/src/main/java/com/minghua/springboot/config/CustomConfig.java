package com.minghua.springboot.config;

import com.minghua.springboot.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-15
 */
@Configuration
public class CustomConfig extends WebMvcConfigurerAdapter {

    @Bean
    public FilterRegistrationBean myFilterRegistration(CustomFilter customFilter) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(customFilter);
        registrationBean.setEnabled(true);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/hello");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

    @Bean
    public CustomFilter getCustomFilter() {
        return new CustomFilter();
    }

}
