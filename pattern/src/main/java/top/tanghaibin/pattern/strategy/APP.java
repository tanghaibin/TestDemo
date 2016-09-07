package top.tanghaibin.pattern.strategy;

/**
 * Created by 唐海斌 on 2016/9/7.
 */
public class APP {

    public static void main(String [] args){

        String result = new Context(new StrategyImpl()).doSomething();
        String result2 = new Context(new StrategyImpl2()).doSomething();

        System.out.println(result + ":" + result2);

    }
}
