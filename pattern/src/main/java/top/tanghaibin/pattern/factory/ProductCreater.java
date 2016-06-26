package top.tanghaibin.pattern.factory;

/**
 * Created by tangh on 2016/5/13.
 */
public class ProductCreater implements Creater {

    public  Product createProduct(Class clazz) throws Exception {
        if(!clazz.getSuperclass().getName().equals("top.tanghaibin.pattern.factory.Product")){
            throw new Exception("产品类型不支持");
        }
        return (Product)clazz.newInstance();
    }
}
