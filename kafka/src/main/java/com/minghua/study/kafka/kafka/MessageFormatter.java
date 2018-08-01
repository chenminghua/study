package com.minghua.study.kafka.kafka;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author: minghua
 * @date: 2018/7/5 19:39
 * @modified By:
 */
public class MessageFormatter implements Formatter {
    @Override
    public String format(ILoggingEvent event) {
        return event.getFormattedMessage();
    }
}
