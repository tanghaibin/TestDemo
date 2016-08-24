package top.tanghaibin.security.des;

import top.tanghaibin.exception.BizException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * Created by 唐海斌 on 2016/8/24.
 *
 * des密匙加密解密sdk
 *
 */
public class DESSdk {

    /**
     * 加密
     * @param datasource byte[]  需要加密的数据
     * @param key String  密匙
     * @return byte[]  加密后的字节数组
     */
    public static byte[] encrypt(byte[] datasource, String key) {
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Exception e){
            throw new BizException(e.getMessage(),e);
        }
    }




    /**
     * 解密
     * @param src byte[]  需要解密的字节数组
     * @param key String  密匙
     * @return byte[]  解密后的字节数组
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, String key) {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        try {
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            return cipher.doFinal(src);
        }catch (Exception e){
            throw new BizException(e.getMessage(),e);
        }
    }


    public static void main(String [] args){
        /**********************加密*************************/
        String datasource = "我是好人";
        String key = "12345414141";
        byte [] result = encrypt(datasource.getBytes(),key);
        System.out.println("加密后:"+result);
        /**********************解密******************************/
        byte [] result2 = decrypt(result,key);
        System.out.println("解密后:"+new String(result2));
    }
}
