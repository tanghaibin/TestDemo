package top.tanghaibin.pattern.decorate;

/**
 * Created by 唐海斌 on 2016/9/7.
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component){
        super(component);
    }

    @Override
    public void sayHello() {
        super.sayHello();
        System.out.println("hello b");
    }
}
