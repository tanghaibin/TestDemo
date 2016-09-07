package top.tanghaibin.pattern.decorate;

/**
 * Created by 唐海斌 on 2016/9/7.
 */
public class Decorator implements Component {

    private Component component;

    public Decorator (Component component){
        this.component = component;
    }
    @Override
    public void sayHello() {
        component.sayHello();
    }
}
