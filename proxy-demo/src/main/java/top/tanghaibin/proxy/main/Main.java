package top.tanghaibin.proxy.main;

import org.junit.Test;
import top.tanghaibin.proxy.serviceImpl.UserServiceImpl;
import top.tanhgaibin.proxy.service.UserService;
import top.top.tanghaibin.proxy.MyHandler;

import java.lang.reflect.Proxy;
import java.util.*;

/**
 * Created by tangh on 2016/5/4.
 */
public class Main {

    public static void main(String [] args){

        MyHandler myHandler = new MyHandler(new UserServiceImpl());
        /**
         * 生成代理对象
         * 第一个参数：指定使用哪一个类加载器加载创建好的动态代理对象；这里使用我们的handler的类加载器
         * 第二个参数：接口；这里指定的接口 动态代理对象会去实现该接口
         * 第三个参数：自定义的handler  我们在使用代理对象调用方法的时候关联到哪一个handler上面；从而去调用handler中的invoke方法
         * 这里之所以能转换为UserService  因为我们指定了接口（第二个参数）；该代理对象会去实现该接口（多态）所以能强制转换为UserService 类型
         */

        Class [] interfaces = UserServiceImpl.class.getInterfaces();
        UserService userService = (UserService) Proxy.newProxyInstance(MyHandler.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), myHandler);
        userService.login("tanghaibin","123");
    System.out.println(fun(3));
    System.out.println(fun2(3));
    System.out.println(testArrayList());
    }

   public static int fun(int n){
       int count = 1;
       for(int i = 1;i<=n;++i){
           count *= i;
       }
       return count;
   }

    public static int fun2(int n){

        int count = 1;

        if(n>1){
            count = n * fun2(n-1);
        }

        return count;
    }


    public static List testArrayList(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("b");
        List<String> list2 = new ArrayList<String>();
        list2.add("b");
        //list.removeAll(list2);
        return list;
    }

    @Test
    public void test(){
        Integer [] array = {80,20,58,90,10};
//        Arrays.sort(array);
//        System.out.println(Arrays.asList(array));

        Arrays.sort(array,new CustomComparator());
        System.out.println(Arrays.asList(array));
    }

    class CustomComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            if(o1 instanceof Integer && o2 instanceof Integer){
                Integer a = (Integer) o1;
                Integer b = (Integer) o2;
                if(a>b){
                    return -1;
                }else{
                    return 1;
                }
            }
            return 0;
        }
    }
}
