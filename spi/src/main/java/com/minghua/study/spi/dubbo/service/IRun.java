package com.minghua.study.spi.dubbo.service;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author: minghua
 * @date: 2018/9/6 13:51
 * @modified By:
 */
@SPI
public interface IRun {
    void run();
}
