package top.tanghaibin.consumer;

import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;

/**
 * Created by tangh on 2016/8/12.
 */
@Component
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<Message>{

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        ActiveMQTextMessage activeMQTextMessage = (ActiveMQTextMessage) message;
        System.out.println(activeMQTextMessage.getText());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
