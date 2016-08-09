package top.tanghaibin.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by tanghaibin on 2016/8/9.
 */
public class Main {

    public static void main(String [] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/provider.xml");

        context.start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
