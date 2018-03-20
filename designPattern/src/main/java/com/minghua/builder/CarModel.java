package com.minghua.builder;

import java.util.ArrayList;

public abstract class CarModel {
    private ArrayList<CarAction> sequence = new ArrayList();
    protected abstract void start();
    protected abstract void stop();
    protected abstract void engineBoom();
    protected abstract void alarm();



    final public void run(){
        for (CarAction action : sequence) {
            switch (action){
                case START:
                    this.start(); //开启汽车
                    break;
                case STOP:
                    this.stop();
                    break;
                case ALARM:
                    this.alarm();
                    break;
                case ENGINEBOOM:
                    this.engineBoom();
                    break;
                default:
                    System.out.println("不支持的操作");
            }
        }
    }

    final public void setSequence(ArrayList<CarAction> sequence){
        this.sequence =  sequence;
    }
}
