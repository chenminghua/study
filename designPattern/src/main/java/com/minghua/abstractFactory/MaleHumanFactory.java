package com.minghua.abstractFactory;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-17
 */
public class MaleHumanFactory extends AbstractHumanFactory {

    @Override
    public Human createYelloHuman() {
        return super.createHuman(HumanEnum.YelloMaleHuman);
    }

    @Override
    public Human createWhiteHuman() {
        return null;
    }
}
