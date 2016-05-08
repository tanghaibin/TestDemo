package top.tanghaibin.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2016/3/16.
 */
public class Receive {

    public static void main(String []  args)throws Exception{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://127.0.0.1:61616");

        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("MessageQueue");
        MessageConsumer consumer = session.createConsumer(destination);

        while(true){
            ObjectMessage message = (ObjectMessage) consumer.receive(10000);
            if(null != message){
                String messageContent = (String) message.getObject();
                System.out.println(messageContent);
            }else{
                break;
            }
        }
    }
}
