package top.tanghaibin.pattern.strategy;

/**
 * Created by 唐海斌 on 2016/9/7.
 *策略模式：封装各种不同的算法在不同的类中； 实现相同的接口； 与 工厂模式的区别：策略封装对象的行为，工厂封装类的创建
 * 策略模式有三个对象
 * 环境抽象 策略抽象  具体策略对象
 *
 * 当前为 策略抽象
 */
public interface Strategy {

     String doSomething();
}
