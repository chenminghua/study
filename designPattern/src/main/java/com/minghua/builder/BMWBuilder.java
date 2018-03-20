package com.minghua.builder;

import java.util.ArrayList;

public class BMWBuilder extends CarBuilder {
    private BMWCar bmw = new BMWCar();
    @Override
    public void setSequence(ArrayList sequence) {
        this.bmw.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmw;
    }
}
