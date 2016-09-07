package top.tanghaibin.pattern.strategy;

/**
 * Created by 唐海斌 on 2016/9/7.
 *
 * 环境抽象  维护策略抽象的一个引用
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public String doSomething(){
        return this.strategy.doSomething();
    }
}
