package com.minghua.templateMethod;

public class PassengerByTrain extends HappyPeople {
    @Override
    protected void traval() {
        System.out.println("乘火车回家。。");
    }
}
