package com.minghua.ramq.service.impl;

import com.minghua.ramq.config.RabbitMQConfig;
import com.minghua.ramq.model.Product;
import com.minghua.ramq.service.ProductService;
import minghua.utils.P;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-14
 */
@Service
public class ProductServiceImpl implements ProductService, RabbitTemplate.ConfirmCallback {
    private RabbitTemplate rabbitTemplate;
    public ProductServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        P.rintln(" 消息id:" + correlationData);
        if (ack) {
            P.rintln("消息发送确认成功");
        } else {
            P.rintln("消息发送确认失败:" + cause);
        }
    }

    @Override
    public void save(Product product) {
        P.rintln("will save product:" + product.toString());
        //执行保存
        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, product.getName(),correlationId);
    }
}
