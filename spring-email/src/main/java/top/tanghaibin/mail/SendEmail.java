package top.tanghaibin.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by tangh on 2016/5/12.
 */
public class SendEmail {

    public static void main(String [] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        SimpleMailMessage simpleMailMessage = applicationContext.getBean(SimpleMailMessage.class);
//        MailSender mailSender = applicationContext.getBean(MailSender.class);
//        mailSender.send(simpleMailMessage);
        applicationContext.getBean(SendService.class).send();
    }

}
