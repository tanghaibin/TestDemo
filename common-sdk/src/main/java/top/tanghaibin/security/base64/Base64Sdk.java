package top.tanghaibin.security.base64;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import top.tanghaibin.exception.BizException;

/**
 * Created by 唐海斌 on 2016/8/24.
 *
 * base64 编码于解码
 */
public class Base64Sdk {

    /**
     * 加密
     * @param data 要编码的数据
     * @return
     */
    public static String encodeBase64(byte [] data){
        if(data == null && data.length == 0) throw new BizException("未知加密数据");
        return Base64.encode(data);
    }

    /**
     * 加密
     * @param data 要编码的数据
     * @return
     */
    public static String encodeBase64(String data){
        if(data == null && "".equals(data.trim())) throw new BizException("未知加密数据");
        return Base64.encode(data.getBytes());
    }

    /**
     * 解码
     * @param data 要接码的数据
     * @return
     */
    public static String decodeBase64(String data){
        if(data == null && "".equals(data.trim())) throw new BizException("未知解密数据");
        return new String(Base64.decode(data));
    }

    public static void main(String [] args){

        String data = "我是好人";
        String result = encodeBase64(data);
        System.out.println("加密："+result);
        result = decodeBase64(result);
        System.out.println("解密:"+result);
    }
}
