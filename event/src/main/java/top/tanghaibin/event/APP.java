package top.tanghaibin.event;

/**
 * Created by tanghaibin on 2016/9/26.
 */
public class APP {

    public static void main(String [] args){

        EventSource eventSource = new EventSource();
        eventSource.addEventListener(new MyEventListener());
        eventSource.setName("xiaoming");
    }
}
