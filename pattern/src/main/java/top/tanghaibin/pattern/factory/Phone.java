package top.tanghaibin.pattern.factory;

/**
 * Created by tangh on 2016/5/13.
 */
public class Phone extends Product {


    @Override
    public void price(String price) {
        System.out.println("手机："+price);
    }
}
