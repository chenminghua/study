package com.minghua.mq.consumer01.service.impl;

import com.minghua.mq.consumer01.config.RabbitMQConfig;
import com.minghua.mq.consumer01.model.Product;
import com.minghua.mq.consumer01.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    private RabbitTemplate rabbitTemplate;
    public ProductServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        LOGGER.info(" 消息id:" + correlationData);
        if (ack) {
            LOGGER.info("消息发送确认成功");
        } else {
            LOGGER.info("消息发送确认失败:" + cause);
        }
    }

    @Override
    public void save(Product product) {
        LOGGER.info("will save product:" + product.toString());
        //执行保存
        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTINGKEY, product.getName(), correlationId);
    }
}
