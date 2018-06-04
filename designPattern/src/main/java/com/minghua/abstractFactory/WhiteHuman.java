package com.minghua.abstractFactory;


import minghua.common.utils.P;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-17
 */
public  abstract class WhiteHuman implements Human {
    @Override
    public void talk() {
        P.rintln("白种人会说");
    }

    @Override
    public void laugh() {
        P.rintln("白种人会笑");
    }
}
