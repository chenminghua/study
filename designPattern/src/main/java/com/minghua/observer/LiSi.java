package com.minghua.observer;

import java.util.Observable;
import java.util.Observer;

public class LiSi implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        //首先李斯是个观察者，一旦韩非子有活动，他就知道，他就要向老板汇报
        System.out.print("李斯：观察到韩非子活动，开始报告：");
        this.reportToQiShiHuang(arg.toString());
        System.out.println("李斯：汇报完毕，秦老板赏给他两个萝卜吃吃...\n");
    }

    //汇报给秦始皇
    private void reportToQiShiHuang(String reportContext){
        System.out.println("李斯：报告，秦老板！韩非子有活动了--->"+reportContext);
    }
}
