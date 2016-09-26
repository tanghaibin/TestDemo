package top.tanghaibin.event.spring;

import org.springframework.context.ApplicationEvent;

/**
 * Created by tanghaibin on 2016/9/26.
 */
public class CustomEvent extends ApplicationEvent {

    private Object source;

    @Override
    public Object getSource() {
        return source;
    }

    public CustomEvent(Object source) {
        super(source);
        this.source = source;
    }
}
