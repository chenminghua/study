package com.minghua.observer;

import java.util.Observable;
import java.util.Observer;

public class WangSi implements Observer {
    @Override
    //王斯，看到韩非子有活动，自己就受不了
    public void update(Observable observable,Object obj){
        System.out.println("王斯：观察到韩非子活动，自己也开始活动了...");
        this.cry(obj.toString());
        System.out.println("王斯：真真的哭死了...\n");
    }
    //一看李斯有活动，就哭，痛哭
    private void cry(String context){
        System.out.println("王斯：因为"+context+"， ——所以我悲伤呀！ ");
    }
}
