package top.tanghaibin.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tanghaibin on 2016/10/28.
 */
public class Sender {

    public static void main(final String... args) throws Exception {

        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("rabbit.xml");
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        template.setRoutingKey("a.3252");
        template.convertAndSend("Hello, world!");
        Thread.sleep(1000);
        ctx.destroy();
    }
}
