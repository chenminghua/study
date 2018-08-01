package com.minghua.spbtmgdb.service;

import com.minghua.spbtmgdb.domain.FreezerStatus;
import com.minghua.spbtmgdb.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author: minghua
 * @date: 2018/6/28 18:19
 * @modified By:
 */
public interface DeviceService {

    void saveDeviceStatus(FreezerStatus freezerStatus);

    FreezerStatus findDevStatus(String devSn);

    List<FreezerStatus> listDevStatus(String devSn, Integer limit);
}
