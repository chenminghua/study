package com.minghua.templateMethod;

public class Celebrate {
    public static void main(String[] args) {
        HappyPeople tom = new PassengerByAir();
        tom.celebrateSpringFestival();

        HappyPeople xiaoming = new PassengerByTrain();
        xiaoming.celebrateSpringFestival();
    }
}
