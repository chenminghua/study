package com.qiushui.rabbitmq.mqtt;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.junit.Test;

import java.net.URISyntaxException;

/**
 * @author: minghua
 * @date: 2018/7/3 19:24
 * @modified By:
 */
public class Client {
    @Test
    public void mqtt() {
        MQTT mqtt = new MQTT();
        try {
            mqtt.setHost("192.168.56.102", 1883);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        // or
        //mqtt.setHost("tcp://localhost:1883");
        BlockingConnection connection = mqtt.blockingConnection();
        try {
            connection.connect();
            System.out.println(connection.isConnected());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection.publish("foo", "Hello".getBytes(), QoS.AT_LEAST_ONCE, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
