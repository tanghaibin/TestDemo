package top.tanghaibin.pattern.decorate;

/**
 * Created by 唐海斌 on 2016/9/7.
 * 具体装饰角色
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component){
        super(component);
    }

    @Override
    public void sayHello() {
        super.sayHello();
        System.out.println("hello a");
    }
}
