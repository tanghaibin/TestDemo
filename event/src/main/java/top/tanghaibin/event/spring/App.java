package top.tanghaibin.event.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tanghaibin on 2016/9/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
@ComponentScan("top.tanghaibin.event.spring")
public class App {

    @Autowired
    private Publisher publisher;

    @Test
    public void test(){
        publisher.publishEvent(new CustomEvent("31314141"));
        publisher.publishEvent(new MessageEvent("这是一条消息"));
    }
}
