package com.tanghaibin.top.serviceimpl;

/**
 * Created by Administrator on 2015/12/25.
 */

import com.tanghaibin.top.service.IMqiqeReceiver;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.MapMessage;


public class MqiqeReceiverImpl implements IMqiqeReceiver {

    private JmsTemplate jmsTemplate;

    @Override
    public String reveiver() throws JMSException {
        System.out.println("开始接受信息。。。");
        MapMessage message = (MapMessage) jmsTemplate.receive();
        String str = "lastName:" + message.getString("lastName") + "firstName:"
                + message.getString("firstName") + "messageStr:"
                + message.getString("messageStr");
        System.out.println("接受完信息。。。");
        return str;
    }
    /**
     * @param jmsTemplate the jmsTemplate to set
     */
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}