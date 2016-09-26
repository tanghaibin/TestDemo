package top.tanghaibin.event.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by tanghaibin on 2016/9/26.
 */
@Component
public class MessageListener implements ApplicationListener {

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof MessageEvent){
            System.out.println("messageEvent:"+ ((MessageEvent)applicationEvent).getMessage());
        }
    }
}
