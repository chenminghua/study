package com.minghua.springboot.filter;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-16
 */
public class FilterThreadSafeTest {
    @Test
    public void testFilterThreadSafe() throws IOException, URISyntaxException {
        for (int i = 0; i < 1000; i++) {
            new com.minghua.springboot.filter.HttpGet().run();
        }
    }
}
