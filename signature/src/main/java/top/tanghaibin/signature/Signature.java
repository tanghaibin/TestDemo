package top.tanghaibin.signature;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created by tangh on 2016/12/7.
 */
public class Signature {

    private final String appKey = "000000";
    private final String appSecret = "tanghaibin";

    public String api(final Integer id, final String name, long tempstap, String signature) {
        if((System.currentTimeMillis() - tempstap) > 1000) {
            return "非法调用";
        }
        String s = DigestUtils.md5Hex((appKey + appSecret + tempstap).getBytes());
        if(s.equals(signature)) {
            return "id:" + id + "\nname:" + name;
        }else{
            return "非法调用";
        }
    }

    @Test
    public void test() {
        final Integer id = 1000;
        final String name = "小明";
        long tempstap = System.currentTimeMillis();
        String signature = DigestUtils.md5Hex((appKey + appSecret + tempstap).getBytes());
        String result = api(id, name, tempstap, signature);
        System.out.println(result);
    }

}
