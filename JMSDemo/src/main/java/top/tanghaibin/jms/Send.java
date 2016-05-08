package top.tanghaibin.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * Created by Administrator on 2016/3/16.
 */
public class Send {

    public static void main(String []  args)throws Exception{

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(

                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://127.0.0.1:61616");

        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("MessageQueue");
        MessageProducer producer = session.createProducer(destination);

        for(int i = 0;i<100;++i) {
            ObjectMessage message = session.createObjectMessage("hello   test "+ i);
            producer.send(message);
            session.commit();
            Thread.sleep(1000);
        }
    }

}
