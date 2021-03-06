package ramq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-8-9
 */
public class SendMsg {
    private final static String QUEUE_NAME = "learn_mq";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setHost("192.168.1.110");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String msg = "";
        while (true) {
            System.out.println("Please Input A Message:");
            msg = bufferedReader.readLine();
            if ("exit".equals(msg)) {
                break;
            } else{
                channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
                System.out.println(" [x] Sent '" + msg + "'");
            }
        }
        channel.close();
        connection.close();
    }
}
