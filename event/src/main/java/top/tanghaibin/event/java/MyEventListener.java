package top.tanghaibin.event.java;

import java.util.EventListener;

/**
 * Created by tanghaibin on 2016/9/26.
 *
 * 事件监听器
 */
public class MyEventListener implements EventListener {

    public void onEvent(MyEvent myEvent){
        System.out.println(((EventSource)myEvent.getSource()).getName());
    }
}
