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
import java.util.Date;
import java.util.List;

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

        //1W台设备，每台设备30天数据(估算8000条数据)
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
    public void delete() {
    }

    @Test
    public void findUser() {
        FreezerStatus freezerStatus  = deviceService.findDevStatus("");
        LOGGER.info("从mongodb中查询到的数据：" + freezerStatus.toString());
    }

    @Test
    public void listUser() {
        List<FreezerStatus> users = deviceService.listDevStatus();
        LOGGER.info("从mongdb中查询到的数据： " + users.toString());
    }
}