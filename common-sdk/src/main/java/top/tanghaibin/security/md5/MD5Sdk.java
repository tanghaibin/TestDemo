package top.tanghaibin.security.md5;

import top.tanghaibin.common.CommonSdk;
import top.tanghaibin.exception.BizException;

/**
 * Created by 唐海斌 on 2016/8/24.
 * 用于md5加密
 */
public class MD5Sdk {

    public static String md5(String data){
        if(CommonSdk.isEmpty(data)) throw new BizException("未知加密数据");

        return null;
    }
}
