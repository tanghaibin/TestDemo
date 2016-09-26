package top.tanghaibin.event.spring;

import org.springframework.context.ApplicationEvent;

/**
 * Created by tanghaibin on 2016/9/26.
 */
public class MessageEvent extends ApplicationEvent{

    private Object message;

    public Object getMessage() {
        return message;
    }


    public MessageEvent(Object source) {
        super(source);
        this.message = source;
    }
}
