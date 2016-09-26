package top.tanghaibin.event.java;

import java.util.EventObject;

/**
 * Created by tanghaibin on 2016/9/26.
 *
 * 事件  封装事件的信息
 */
public class MyEvent extends EventObject {

    private Object source;

    public MyEvent(Object source) {
        super(source);
        this.source = source;
    }

    @Override
    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}
