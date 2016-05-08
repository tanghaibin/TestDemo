package com.tanghaibin.top;

import com.tanghaibin.top.service.IMqiqeReceiver;
import com.tanghaibin.top.service.IMqiqeSend;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015/12/24.
 */
@Component
public class JMSTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("/applicationContext.xml");
        IMqiqeSend demoSend = (IMqiqeSend) applicationContext.getBean("mqiqeSend");
        IMqiqeReceiver mqiqeReceiver = (IMqiqeReceiver) applicationContext.getBean("mqiqeReceiver");
        for(int i=0;i<5;++i){
            demoSend.send("hello,world!");
            System.out.println("send Message:hello,world!");
            try {
                System.out.println(mqiqeReceiver.reveiver());
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("end");
        }
    }
}
