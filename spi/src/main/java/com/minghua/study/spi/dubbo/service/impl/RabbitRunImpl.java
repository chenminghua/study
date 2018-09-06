package com.minghua.study.spi.dubbo.service.impl;

import com.minghua.study.spi.dubbo.service.IRun;

/**
 * @author: minghua
 * @date: 2018/9/6 13:51
 * @modified By:
 */
public class RabbitRunImpl implements IRun {
    @Override
    public void run() {
        System.out.println("兔子跑步！");
    }
}
