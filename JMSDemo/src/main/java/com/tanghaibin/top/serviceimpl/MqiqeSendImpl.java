package com.tanghaibin.top.serviceimpl;

/**
 * Created by Administrator on 2015/12/25.
 */
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;


import com.tanghaibin.top.service.IMqiqeSend;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


public class MqiqeSendImpl implements IMqiqeSend {

    private JmsTemplate jmsTemplate;

    @Override
    public void send(final String motorist) {
        jmsTemplate.send(
                new MessageCreator() {
                    public Message createMessage(Session session) throws JMSException {
                        MapMessage message = session.createMapMessage();
                        message.setString("lastName", "fg\n");
                        message.setString("firstName", "mqiqe\n");
                        message.setString("messageStr", motorist);
                        return message;
                    }
                });
    }

    /**
     * @param jmsTemplate the jmsTemplate to set
     */
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}