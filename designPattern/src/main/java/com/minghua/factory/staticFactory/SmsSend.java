package com.minghua.factory.staticFactory;

public class SmsSend implements Sender {
    @Override
    public void send(String msg) {
        System.out.println("send by sms with:" + msg);
    }
}
