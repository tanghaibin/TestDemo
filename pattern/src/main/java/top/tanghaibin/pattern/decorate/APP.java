package top.tanghaibin.pattern.decorate;

/**
 * Created by 唐海斌 on 2016/9/7.
 */
public class APP {

    public static void main(String [] args){

        Component component2  = new ConcreteDecoratorB(new ConcreteDecoratorA(new ConcreteComponent()));
        component2.sayHello();
    }
}
