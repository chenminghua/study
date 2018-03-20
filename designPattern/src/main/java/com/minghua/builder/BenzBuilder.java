package com.minghua.builder;

import java.util.ArrayList;

public class BenzBuilder extends CarBuilder {
    private BenzCar benz = new BenzCar();
    @Override
    public void setSequence(ArrayList sequence) {
        this.benz.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benz;
    }
}
