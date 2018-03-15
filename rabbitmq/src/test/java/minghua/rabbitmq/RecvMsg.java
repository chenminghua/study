package minghua.rabbitmq;

import minghua.common.utils.P;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-9
 */
public class RecvMsg {

    private final static String QUEUE_NAME = "learn_mq";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("test");
        factory.setHost("10.3.40.117");
        factory.setUsername("admin");
        factory.setPassword("0816jichusuo");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            P.rintln(" [x] Received '" + message + "'");
        }
    }
}
