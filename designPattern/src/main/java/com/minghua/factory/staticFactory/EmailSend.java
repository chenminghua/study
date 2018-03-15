package com.minghua.factory.staticFactory;

public class EmailSend implements Sender {
    @Override
    public void send(String msg) {
        System.out.println("send by email :" + msg);
    }
}
