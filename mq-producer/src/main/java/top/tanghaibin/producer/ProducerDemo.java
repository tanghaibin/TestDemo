package top.tanghaibin.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Random;

/**
 * Created by tangh on 2016/8/12.
 */
@Component
public class ProducerDemo {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(){

        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("helllo" + System.currentTimeMillis());
            }
        });
    }
}
