package com.minghua.spbtmgdb.service.impl;

import com.minghua.spbtmgdb.domain.User;
import com.minghua.spbtmgdb.service.UserService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
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
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final String AVATAR_FILE_TYPE = "image";
    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void saveUser(User user, InputStream ins) {
        try {
            DBObject metadata = new BasicDBObject();

            metadata.put("user", user.getId());
            metadata.put("type", "avatar");
            GridFSFile store = gridFsTemplate.store(ins, System.currentTimeMillis() + "", AVATAR_FILE_TYPE, metadata);
            LOGGER.info(store.getId().toString());
            LOGGER.info("图片成功保存到mongo，更新索引完成");
        } catch (Exception e) {
            LOGGER.error("更新索引失败,已回滚此图片在mongo的保存操作");
        }
    }

    /**
     * 删除文件
     *
     * @param sn
     * @return
     */
    @Override
    public void delete(String sn, String filename) {

        Query query = new Query();
        Criteria criteria = new Criteria().andOperator(new GridFsCriteria("metadata.user").is(1),
                new GridFsCriteria("filename").is("1530510232811"));
        query.addCriteria(criteria);

        gridFsTemplate.delete(query);
    }

    @Override
    public User findUser(String id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    @Override
    public List<User> listUser() {
        //find by same email
        String email = "minghua.cc@qq.com";
        Query query = new Query();
        Criteria criteria = Criteria.where("email").is(email);
        query.addCriteria(criteria);
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

    @Override
    public OutputStream findUserAvatar(int id) throws IOException {
        Query query = new Query();
        Criteria criteria = new Criteria().andOperator(new GridFsCriteria("metadata.user").is(id),
                new GridFsCriteria("metadata.type").is("avatar"));
        query.addCriteria(criteria);
        GridFSDBFile gridFSDBFile = gridFsTemplate.findOne(query);

        InputStream ins = gridFSDBFile.getInputStream();
        File file = new File("D:\\var\\image\\loaded.png");
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            try {
                os.write(buffer, 0, bytesRead);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //os.close();
        ins.close();
        return os;
    }



}
