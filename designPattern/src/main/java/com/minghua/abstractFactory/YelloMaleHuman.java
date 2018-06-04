package com.minghua.abstractFactory;


import minghua.common.utils.P;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-17
 */
public class YelloMaleHuman extends YelloHuman {
    @Override
    public void sex() {
        P.rintln("该黄种人的性别为男");
    }
}
