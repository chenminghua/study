package com.qiushui.study.tts.baidu.spredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author: minghua
 * @date: 2018/11/21 18:45
 * @modified By:
 */
public class HelloController {

    @Autowired
    private ValueOperations<String, String> valueOperations;

    public void hello() {
        //valueOperations.set();
    }
}
