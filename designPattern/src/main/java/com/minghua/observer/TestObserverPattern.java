package com.minghua.observer;

import org.junit.Test;

public class TestObserverPattern {
    @Test
    public void test() {
        HanFeizi hanFeizi = new HanFeizi();
        LiSi liSi = new LiSi();
        WangSi wangSi = new WangSi();

        hanFeizi.addObserver(liSi);
        hanFeizi.addObserver(wangSi);

        hanFeizi.haveBreakfast();
        hanFeizi.haveFun();
    }
}
