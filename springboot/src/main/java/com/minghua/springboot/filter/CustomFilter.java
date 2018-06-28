package com.minghua.springboot.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-15
 */
public class CustomFilter extends GenericFilterBean {
    private volatile int times;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        times++;
        System.out.println("第" + times + "次，cost:" + (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void initFilterBean() throws ServletException {
        System.out.println("==============GenericFilterBean======initFilterBean");
        System.out.println(this.getFilterConfig() + "============" + this.getFilterName());
    }

    @Override
    public void destroy() {
        System.out.println("================GenericFilterBean=========destroy");
    }
}
