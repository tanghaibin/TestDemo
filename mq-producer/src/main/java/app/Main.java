package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.tanghaibin.producer.ProducerDemo;

/**
 * Created by tangh on 2016/8/12.
 */
public class Main {

    public static void main(String [] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ProducerDemo producerDemo = (ProducerDemo) applicationContext.getBean("producerDemo");
        producerDemo.sendMessage();
    }
}
