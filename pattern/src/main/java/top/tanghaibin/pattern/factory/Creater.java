package top.tanghaibin.pattern.factory;

/**
 * Created by tangh on 2016/5/13.
 *
 * 产品制作抽象接口
 */
public interface Creater {

    Product createProduct(Class clazz) throws Exception;
}
