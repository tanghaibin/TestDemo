package top.tanghaibin.pattern.decorate;

/**
 * Created by 唐海斌 on 2016/9/7.
 * 具体构件（要包装的对象）
 */
public class ConcreteComponent implements Component {

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
