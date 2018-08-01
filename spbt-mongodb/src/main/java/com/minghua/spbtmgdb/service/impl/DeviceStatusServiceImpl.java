package com.minghua.spbtmgdb.service.impl;

import com.minghua.spbtmgdb.domain.FreezerStatus;
import com.minghua.spbtmgdb.domain.User;
import com.minghua.spbtmgdb.service.DeviceService;
import com.minghua.spbtmgdb.service.UserService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author: minghua
 * @date: 2018/6/28 18:20
 * @modified By:
 */
@Service("deviceStatusService")
public class DeviceStatusServiceImpl implements DeviceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceStatusServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void saveDeviceStatus(FreezerStatus freezerStatus) {
        try {
            mongoTemplate.save(freezerStatus);
            LOGGER.info("保存成功，" + freezerStatus.getDevSn());
        } catch (Exception e) {
            LOGGER.error("添加失败，" + freezerStatus.getDevSn());
        }
    }

    @Override
    public FreezerStatus findDevStatus(String devSn) {
        Query query = new Query();
        Criteria criteria = Criteria.where("devSn").is(devSn);
        query.addCriteria(criteria);
        FreezerStatus freezerStatus = mongoTemplate.findOne(query, FreezerStatus.class);
        return freezerStatus;
    }

    @Override
    public List<FreezerStatus> listDevStatus() {
        //find by same email
        String email = "minghua.cc@qq.com";
        Query query = new Query();
        Criteria criteria = Criteria.where("email").is(email);
        query.addCriteria(criteria);
        List<FreezerStatus> users = mongoTemplate.find(query, FreezerStatus.class);
        return users;
    }
}
