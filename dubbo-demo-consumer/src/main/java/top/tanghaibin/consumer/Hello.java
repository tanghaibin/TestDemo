package top.tanghaibin.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.tanghaibin.dubbo.facade.HelloService;

/**
 * Created by tanghaibin on 2016/8/9.
 */
public class Hello {

    public static void main(String [] args){

        ApplicationContext atc = new ClassPathXmlApplicationContext("/consumer.xml");

        HelloService helloService = (HelloService) atc.getBean("helloService");

        String test = helloService.sayHello("唐海斌");

        System.out.println(test);

    }
}
