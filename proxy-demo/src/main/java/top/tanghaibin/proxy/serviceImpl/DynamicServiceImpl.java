package top.tanghaibin.proxy.serviceImpl;

import top.tanhgaibin.proxy.service.DynamicService;

/**
 * Created by tangh on 2016/5/4.
 */
public class DynamicServiceImpl implements DynamicService {
    public void delete(Integer id) {
        System.out.println("删除动态"+id);
    }
}
