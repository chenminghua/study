package com.minghua.ramq.config;

import minghua.utils.P;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-14
 */
@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "spring-boot-mq-exchange";
    public static final String QUEUE_NAME = "spring-boot-mq-queue";
    public static final String ROUTING_KEY = "spring-boot-mq-rk";
    @Value("${mq.rabbit.host}")
    private String mqRabbitHost;

    @Value("${mq.rabbit.port}")
    private int mqRabbitPort;

    @Value("${mq.rabbit.username}")
    private String mqRabbitUserName;

    @Value("${mq.rabbit.password}")
    private String mqRabbitPassword;

    @Value("${mq.rabbit.virtualHost}")
    private String mqRabbitVirtualHost;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(this.mqRabbitHost, this.mqRabbitPort);
        connectionFactory.setUsername(this.mqRabbitUserName);
        connectionFactory.setPassword(this.mqRabbitPassword);
        connectionFactory.setVirtualHost(this.mqRabbitVirtualHost);
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }

    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(ROUTING_KEY);
    }

    @Bean
    public SimpleMessageListenerContainer messageContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(queue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                    byte[] body = message.getBody();
                    P.rintln("消费端接收到的消息是：" + new String(body));
                    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                }
        });
        return container;
    }

}
