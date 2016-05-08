package top.top.tanghaibin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by tangh on 2016/5/4.
 */
public class MyHandler implements InvocationHandler{

    private Object obj;

    public MyHandler(Object obj){
        this.obj = obj;
    }

    /**
     *
     * @param proxy 生成的代理对象
     * @param method 调用的需要调用的方法名字
     * @param args 调用方法参数值
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("调用   " + method.getName());
        System.out.println("写日志。。。。。。。");
        method.invoke(obj, args);
        System.out.println(method.getName() + "调用完毕");
        return null;
    }
}
