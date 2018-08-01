package com.minghua.spbtmgdb.service.impl;

import com.minghua.spbtmgdb.domain.FreezerStatus;
import com.minghua.spbtmgdb.service.DeviceService;
import com.sun.istack.internal.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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
    public List<FreezerStatus> listDevStatus(String devSn, @Nullable Integer limit) {
        int limit1 = (limit == null || limit.equals(0) ? 10: limit.intValue());
        Query query = new Query();
        Sort sort = new Sort("dateTime");
        Criteria criteria = Criteria.where("devSn").is(devSn);
        query.addCriteria(criteria);
        query.with(sort);
        query.limit(limit1);
        List<FreezerStatus> devStatus = mongoTemplate.find(query, FreezerStatus.class);
        return devStatus;
    }
}
