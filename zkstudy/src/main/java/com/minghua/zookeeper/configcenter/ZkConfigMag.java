package com.minghua.zookeeper.configcenter;

import org.I0Itec.zkclient.ZkClient;

public class ZkConfigMag {
    private Config config;

    /**
     * 从数据库加载配置
     */
    public Config downloadConfigFromDb(){
        //getDB
        config = new Config("nm", "pw");
        return config;
    }

    /**
     * 配置文件上传到数据库
     */
    public void uploadConfig2Db(String nm, String pw){
        if(config==null) {
            config = new Config();
        }
        config.setUserNm(nm);
        config.setUserPw(pw);
        //updateDB
    }

    /**
     * 配置文件按同步到zk
     */
    public void syncConfig2Zk(){
        ZkClient zk = new ZkClient("localhost:2181");
        if(!zk.exists("/zkConfig")){
            zk.createPersistent("/zkConfig",true);
        }
        zk.writeData("/zkConfig", config);
        zk.close();
    }
}
