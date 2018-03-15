package com.minghua.factory.staticFactory;

public class SendFactory {
    public static Sender produceMail() {
        return new EmailSend();
    }

    public static Sender produceSms() {
        return new SmsSend();
    }
}
