package com.minghua.spbtmgdb.service.impl;

import com.minghua.spbtmgdb.domain.User;
import com.minghua.spbtmgdb.service.UserService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @author: minghua
 * @date: 2018/6/28 18:20
 * @modified By:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private GridFsTemplate gridFsTemplate;


    @Override
    public void saveUser(User user) {
        String fileUrl;
        String savefilename = null;
        try {
            DBObject metadata = new BasicDBObject();

            for (String key : map.keySet()) {
                metadata.put(key, map.get(key));
            }
            GridFSFile store = gridFsTemplate.store(content, filename, contentType, metadata);
            savefilename = store.getFilename();

            LOGGER.info("图片成功保存到mongo，更新索引完成");
        } catch (Exception e) {
            this.delete((String) map.get("sn"), savefilename);
            LOGGER.error("更新索引失败,已回滚此图片在mongo的保存操作");
            throw e;
        }
    }

    /**
     * 删除文件
     *
     * @param sn
     * @return
     */
    public void delete(String sn, String filename) {

        Query query = new Query();
        Criteria criteria = new Criteria().andOperator(new GridFsCriteria("metadata.sn").is(sn),
                new GridFsCriteria("filename").is(filename));
        query.addCriteria(criteria);

        gridFsTemplate.delete(query);
    }
}
