package com.minghua.factory.staticFactory;

public class TestSend {
    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.send("Happy new year!");
    }
}
