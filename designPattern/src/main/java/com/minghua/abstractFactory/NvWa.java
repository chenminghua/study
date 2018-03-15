package com.minghua.abstractFactory;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-17
 */
public class NvWa {
    public static void main(String[] args) {
        FemaleHumanFactory femaleHumanFactory = new FemaleHumanFactory();
        MaleHumanFactory maleHumanFactory = new MaleHumanFactory();

        Human h1 = femaleHumanFactory.createWhiteHuman();
        Human h2 = femaleHumanFactory.createYelloHuman();

        Human h3 = maleHumanFactory.createWhiteHuman();
        Human h4 = maleHumanFactory.createYelloHuman();

        h1.laugh();
        h1.talk();

    }
}
