package com.minghua.zookeeper.configcenter;

public class ZkConfigTest {
    public static void main(String[] args) {
        ZkConfigMag mag = new ZkConfigMag();
        Config config = mag.downloadConfigFromDb();
        System.out.println("....加载数据库配置...."+config.toString());
        mag.syncConfig2Zk();
        System.out.println("....同步配置文件到zookeeper....");

        //歇会，这样看比较清晰
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mag.uploadConfig2Db("cwhcc", "passwordcc");
        System.out.println("....修改配置文件...."+config.toString());
        mag.syncConfig2Zk();
        System.out.println("....同步配置文件到zookeeper....");
    }
}
