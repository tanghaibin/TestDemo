package top.tanghaibin.pattern.strategy;

/**
 * Created by 唐海斌 on 2016/9/7.
 *
 * 策略抽象的实现（封装各种算法 每个类都有各自的算法）
 */
public class StrategyImpl2 implements Strategy{

    @Override
    public String doSomething() {
        return "去KTV唱歌";
    }
}
