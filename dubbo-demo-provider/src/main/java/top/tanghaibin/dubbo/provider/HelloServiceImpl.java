package top.tanghaibin.dubbo.provider;

import top.tanghaibin.dubbo.facade.HelloService;

/**
 * Created by tanghaibin on 2016/8/9.
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public String sayHello(String name) {
        return "你好！"+ name ;
    }
}
