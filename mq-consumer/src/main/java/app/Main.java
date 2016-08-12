package app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tangh on 2016/8/12.
 */
public class Main {

    public static void main(String [] args){

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        applicationContext.start();
    }
}
