package com.minghua.builder;

import org.junit.Test;

public class BuilderPattern {
    @Test
    public void client(){
        Director director = new Director();
        director.getABenzModel().run();

        director.getCBMWModel().run();

    }
}
