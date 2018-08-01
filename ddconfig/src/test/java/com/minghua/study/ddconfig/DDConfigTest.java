package com.minghua.study.ddconfig;

import com.dangdang.config.service.GeneralConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigProfile;
import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * @author: minghua
 * @date: 2018/7/12 15:20
 * @modified By:
 */
public class DDConfigTest {
    @Test
    public void loadFromDDConfig() {
        ZookeeperConfigProfile configProfile = new ZookeeperConfigProfile("192.168.56.102:2181", "/projectx/modulex", "1.0.0");
        GeneralConfigGroup group = new ZookeeperConfigGroup(configProfile, "group");

        String stringProperty = group.get("config.str");
        Preconditions.checkState("hello".equals(stringProperty));
        String intProperty = group.get("config.int");
        Preconditions.checkState(7758 == Integer.parseInt(intProperty));
    }
}
