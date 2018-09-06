package com.minghua.study.spi.dubbo.service.impl;

import com.minghua.study.spi.dubbo.service.IRun;

/**
 * @author: minghua
 * @date: 2018/9/6 13:52
 * @modified By:
 */
public class HumanRunImpl implements IRun {
    @Override
    public void run() {
        System.out.println("人跑步！");
    }
}
