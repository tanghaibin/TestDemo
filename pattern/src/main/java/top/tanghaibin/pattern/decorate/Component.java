package top.tanghaibin.pattern.decorate;

/**
 * Created by 唐海斌 on 2016/9/7.
 *
 *装饰模式
 *   四部分组成
 *      1） 抽象构件角色（Component）：定义一个抽象接口，以规范准备接收附加责任的对象。
 *      2） 具体构件角色(Concrete Component)：这是被装饰者，定义一个将要被装饰增加功能的类。
 *      3） 装饰角色(Decorator)：持有一个构件对象的实例，并定义了抽象构件定义的接口。
 *      4） 具体装饰角色(Concrete Decorator)：负责给构件添加增加的功能。
 */
public interface Component {

    void sayHello();

}
