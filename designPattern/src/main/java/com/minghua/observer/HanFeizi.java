package com.minghua.observer;

import java.util.Observable;

public class HanFeizi extends Observable {
    public void haveBreakfast() {
        System.out.println("韩非子开始吃饭了！");
        //通知所有观察者
        super.setChanged();
        super.notifyObservers("韩非子在吃饭");
    }

    public void haveFun() {
        System.out.println("韩非子开始娱乐！");
        //通知所有观察者
        super.setChanged();
        super.notifyObservers("韩非子在娱乐");
    }
}
