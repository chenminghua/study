package com.minghua.spbtmgdb.service.impl;

import com.minghua.spbtmgdb.domain.FreezerStatus;
import com.minghua.spbtmgdb.domain.User;
import com.minghua.spbtmgdb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: minghua
 * @date: 2018/7/2 13:24
 * @modified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DeviceServiceImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceServiceImplTest.class);

    @Autowired
    private DeviceStatusServiceImpl deviceService;

    @Test
    public void saveUser() {
        //1W台设备，每台设备30天数据(估算8000条数据),总数8KW
        int devCount = 10000;
        int dataCountPerDev = 8000;
        for (int i = 0; i < devCount; i++) {
            FreezerStatus freezerStatus = new FreezerStatus();
            //设备编号dev_1
            freezerStatus.setDevSn("dev_" + i);
            for (int j = 0; j < dataCountPerDev; j++) {
                freezerStatus.setDateTime(new Date());
                freezerStatus.setStatusTimes("t" + j);
                deviceService.saveDeviceStatus(freezerStatus);
            }
        }
    }


    @Test
    public void findDevStatus() {
        FreezerStatus freezerStatus = deviceService.findDevStatus("");
        LOGGER.info("从mongodb中查询到的数据：" + freezerStatus.toString());
    }

    @Test
    public void listDevStatus() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        List<FreezerStatus> totalResult = new ArrayList<FreezerStatus>();
        int totalTimes = 5;

        // 设置计数器，从0开始
        final CountDownLatch countDownLatch = new CountDownLatch(totalTimes - 1);
        // 定义Future数组，数组大小和计数器个数相同
        Future<List<FreezerStatus>>[] futures = new Future[totalTimes];

        for (int i = 0; i < totalTimes; i++) {
            Random random = new Random();
            final String devSn = "dev_" + random.nextInt(5000);
            // 将各个result塞到线程池的各个线程里，返回Future数组
            futures[i] = threadPool.submit(new Callable<List<FreezerStatus>>() {
                // 返回取得的List
                @Override
                public List<FreezerStatus> call() throws Exception {
                    List<FreezerStatus> result = new ArrayList<>();
                    try {
                        result = deviceService.listDevStatus(devSn, null);
                    } catch (Exception e) {
                        throw e;
                    } finally {
                        // 线程完成任务后通过countDownLatch.countDown()来通知CountDownLatch对象，计数器-1
                        countDownLatch.countDown();
                    }
                    return result;
                }
            });

        }
        // 所有任务执行完毕后触发事件,countDownLatch为0，唤醒await在latch上的主线程
        countDownLatch.await();

        long end = System.currentTimeMillis();
        // 合并记录
        for (int j = 0; j < totalTimes; j++) {
            if (futures[j] != null && futures[j].get() != null) {
                totalResult.addAll(futures[j].get());
            }
        }
        LOGGER.info("最终查询数据量：" + totalResult.size());
        LOGGER.info("最终查询耗时：" + (end - start));
        for (FreezerStatus status : totalResult) {
            LOGGER.info(status.toString());
        }

    }


}