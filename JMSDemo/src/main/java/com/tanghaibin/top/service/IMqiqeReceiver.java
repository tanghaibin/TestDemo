package com.tanghaibin.top.service;

import javax.jms.JMSException;

/**
 * Created by Administrator on 2015/12/25.
 */

public interface IMqiqeReceiver {
    public String reveiver() throws JMSException;
}
