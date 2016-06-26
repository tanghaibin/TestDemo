package top.tanghaibin.pattern.factory;

import java.util.HashMap;

/**
 * Created by tangh on 2016/5/13.
 */
public class APP {

    public static void main(String [] args){
        Creater productCreater = new ProductCreater();
        try {
            Product product = productCreater.createProduct(Computer.class);
            product.price("5000");
            product = productCreater.createProduct(Phone.class);
            product.price("3000");
            productCreater.createProduct(HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
