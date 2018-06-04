package com.minghua.abstractFactory;


import minghua.common.utils.P;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-17
 */
public class WhiteFemaleHuman extends WhiteHuman {
    @Override
    public void sex() {
        P.rintln("该白种人的性别为女");
    }
}
