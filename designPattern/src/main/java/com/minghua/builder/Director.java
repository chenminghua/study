package com.minghua.builder;

import java.util.ArrayList;

/**
 * 导演安排顺序，生产车辆模型
 */
public class Director {
    private ArrayList<CarAction> sequence = new ArrayList();
    private CarBuilder benzBuilder = new BenzBuilder();
    private CarBuilder bmwBuilder = new BMWBuilder();
    /**
     *A类型的奔驰车模型，先start,然后stop,其他什么引擎了，喇叭一概没有
     */
    public BenzCar getABenzModel(){
        this.sequence.clear();
        //执行顺序
        this.sequence.add(CarAction.START);
        this.sequence.add(CarAction.STOP);

        //按照此顺序返回一个奔驰车
        benzBuilder.setSequence(sequence);
        return (BenzCar) benzBuilder.getCarModel();
    }

    public BMWCar getCBMWModel(){
        this.sequence.clear();
        //执行顺序
        this.sequence.add(CarAction.ALARM);
        this.sequence.add(CarAction.ENGINEBOOM);
        this.sequence.add(CarAction.START);
        this.sequence.add(CarAction.STOP);
        bmwBuilder.setSequence(sequence);
        return (BMWCar) bmwBuilder.getCarModel();
    }
}
