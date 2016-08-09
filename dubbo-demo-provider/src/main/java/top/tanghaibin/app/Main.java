package top.tanghaibin.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tanghaibin on 2016/8/9.
 */
public class Main {

    public static void main(String [] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/provider.xml");
        while(true){
            try {
                System.out.println("服务中");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
