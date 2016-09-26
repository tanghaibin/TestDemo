package top.tanghaibin.event;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by tanghaibin on 2016/9/26.
 *
 * 事件源
 */
public class EventSource {

    private Set<MyEventListener> set;

    private String name;

    public EventSource(){
        set = new HashSet<MyEventListener>();
    }

    public void addEventListener(MyEventListener listener){
        set.add(listener);
    }

    private void resolveEvent(){
        Iterator<MyEventListener> iterator = set.iterator();
        while(iterator.hasNext()){
            iterator.next().onEvent(new MyEvent(this));
        }
    }

    public void setName(String name){
        this.name = name;
        resolveEvent();
    }
    public String getName(){
        return this.name;
    }
}
