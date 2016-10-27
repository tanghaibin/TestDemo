package top.tanghaibin.rabbitmq.helloword;

import java.io.File;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by tanghaibin on 2016/9/27.
 */
public class Sender {

    private static final String QUEUES_NAME = "hello";

    public static void main(String [] args) throws Exception{

//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost("localhost");
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(QUEUES_NAME,false,false,false,null);
//        channel.basicPublish("",QUEUES_NAME,null,"hello,two".getBytes());
//
//        channel.close();
//        connection.close();
    }


}


