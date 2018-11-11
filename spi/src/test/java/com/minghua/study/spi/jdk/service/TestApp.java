package com.minghua.study.spi.jdk.service;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.minghua.study.spi.dubbo.service.IRun;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: minghua
 * @date: 2018/9/6 11:34
 * @modified By:
 */
public class TestApp {
    @Test
    public void testJDKSPI() {
        ServiceLoader<ISearch> serviceLoader = ServiceLoader.load(ISearch.class);
        Iterator<ISearch> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            ISearch search = iterator.next();
            search.search();
        }
    }


    @Test
    public void testDubboSPI() {
        String extensionHuman = "human";
        String extensionRabbit = "rabbit";
        ExtensionLoader<IRun> extensionLoader1 = ExtensionLoader.getExtensionLoader(IRun.class);
        IRun humanRun = extensionLoader1.getExtension(extensionHuman);
        humanRun.run();

        ExtensionLoader<IRun> extensionLoader2 = ExtensionLoader.getExtensionLoader(IRun.class);
        IRun rabbitRun = extensionLoader2.getExtension(extensionRabbit);
        rabbitRun.run();
    }
}
