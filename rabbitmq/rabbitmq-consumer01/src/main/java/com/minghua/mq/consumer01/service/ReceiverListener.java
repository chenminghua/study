package com.minghua.mq.consumer01.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ramq.model.Product;

/**
 * @author: minghua
 * @date: 2018/5/28 18:42
 * @modified By:
 */
@Component
@RabbitListener(queues = "spring.demo")
public class ReceiverListener{

    @RabbitHandler
    public void process(Product product) {
        System.out.println("Receiver : " + product);
    }


}

