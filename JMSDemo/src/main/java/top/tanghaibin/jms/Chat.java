package top.tanghaibin.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by tangh on 2016/6/26.
 */
public class Chat implements javax.jms.MessageListener{

    private TopicSession pubSession;
    private TopicPublisher publisher;
    private TopicConnection connection;
    private String username;

    /**
     * 用于初始化chat（聊天）的构造函数
     * @param topicFactory
     * @param topicName
     * @param username
     * @throws Exception
     */
    public Chat(String topicFactory,String topicName,String username)throws Exception{
        //使用jndi.properties文件获得一个jndi连接
        InitialContext ctx = new InitialContext();
        //查找一个jms连接工厂并创建连接
        TopicConnectionFactory connectionFactory = (TopicConnectionFactory) ctx.lookup(topicFactory);
        TopicConnection topicConnection = connectionFactory.createTopicConnection();
        //创建两个jms回话对象
        TopicSession pubSession = connection.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
        TopicSession subSession = connection.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
        //查找一个jms主题
        Topic chatTopic = (Topic) ctx.lookup(topicName);
        //创建一个jms发布者和订阅者。createSubscriber中附加的参数是一个消息
        //选择器（null）和noLocal标记的一个真值，它表明这个发布者生产的消息不应该被他自己所消费
        TopicPublisher publisher = pubSession.createPublisher(chatTopic);
        TopicSubscriber subscriber = subSession.createSubscriber(chatTopic,null,true);
        //设置一个jms消息侦听器
        subscriber.setMessageListener(this);
        //初始化一个chat应用程序变量
        this.connection = connection;
        this.pubSession = pubSession;
        this.publisher = publisher;
        this.username = username;
        //启动jms连接。允许传送消息
        connection.start();

    }

    /**
     * 接受来自TopicSubscriber的消息
     * @param message
     */
    public void onMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用发布者创建并发送消息
     * @param text
     * @throws JMSException
     */
    protected  void writeMessage(String text) throws JMSException{
        TextMessage message = pubSession.createTextMessage();
        message.setText(username + ":"+text);
        publisher.publish(message);
    }

    /**
     * 关闭jms连接
     * @throws JMSException
     */
    public void close() throws JMSException{

        connection.close();
    }

    public static void main(String [] args){

        if(args.length!=3){
            System.out.println("Factory.Topic.or username missing");
            //augs[0]=topicFacotry;args[1]=topicName;args[2]=username
            try {
                Chat chat = new Chat(args[0],args[1],args[2]);
                //从命令行读取
                BufferedReader commandLine = new java.io.BufferedReader(new InputStreamReader((System.in)));
                //循环，直到输入“exit”为止
                while (true){
                    String s = commandLine.readLine();
                    if(s.equalsIgnoreCase("exit")){
                        chat.close();
                        System.exit(0);
                    }else {
                        chat.writeMessage(s);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
