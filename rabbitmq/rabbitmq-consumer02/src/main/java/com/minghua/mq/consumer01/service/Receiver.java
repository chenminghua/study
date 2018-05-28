package com.minghua.mq.consumer01.service;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @author: minghua
 * @date: 2018/5/28 18:20
 * @modified By:
 */
public class Receiver implements ChannelAwareMessageListener {
    public Logger logger = LoggerFactory.getLogger(this.getClass());

//
//    @Resource
//    private PersonDao personDao;

    @Autowired
    private RabbitTemplate template;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            String s = new String(message.getBody());
            logger.info("##### = {}", s);
//            ObjectMapper objectMapper = new ObjectMapper();
//            PersonDO personDO = objectMapper.readValue(new String(message.getBody()), PersonDO.class);
            System.out.println("consumer 02 收到的消息是：" + s);
            //模拟耗时操作
            //TimeUnit.SECONDS.sleep(10);
            //boolean result = personDao.addPerson(personDO) > 0;
            boolean result = true;
            if (!result) {
                logger.error("消息消费失败");
            } else {
                logger.info("消息消费成功");
            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);//手动消息应答
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);//true 重新放入队列
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);//对于处理不了的异常消息
//            ObjectMapper objectMapper = new ObjectMapper();
//            PersonDO personDO = objectMapper.readValue(new String(message.getBody()), PersonDO.class);
//            //发送到失败队列
//            template.convertAndSend(AmqpConfig.EXCHANGE, AmqpConfig.ROUTINGKEY_FAIL, personDO);
        }
    }
}