package com.minghua.bridge.v1;

import org.junit.Test;

public class BridgePattern {
    @Test
    public void testV1() {
        Crop clothesCrop = new ClothesCorp();
        Crop houseCrop = new HouseCorp();

        houseCrop.makeMoney();

        clothesCrop.makeMoney();
    }
}
