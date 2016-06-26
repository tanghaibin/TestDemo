package top.tanghaibin.pattern.factory;

/**
 * Created by tangh on 2016/5/13.
 */
public class Computer extends Product {
    @Override
    public void price(String price) {
        System.out.println("电脑:"+price);
    }
}
