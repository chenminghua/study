package com.minghua.abstractFactory;


import minghua.common.utils.P;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-17
 */
public abstract  class YelloHuman implements Human {
    @Override
    public void laugh() {
        P.rintln("黄种人会笑");
    }

    @Override
    public void talk() {
        P.rintln("黄种人会说");
    }
}
