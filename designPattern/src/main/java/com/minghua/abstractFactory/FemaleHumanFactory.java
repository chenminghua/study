package com.minghua.abstractFactory;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-17
 */
public class FemaleHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createYelloHuman() {
        return null;
    }

    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteFemmaleHuman);
    }
}
