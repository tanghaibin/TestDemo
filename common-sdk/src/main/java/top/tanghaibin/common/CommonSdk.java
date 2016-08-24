package top.tanghaibin.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 唐海斌 on 2016/8/24.
 */
public class CommonSdk {

    /**
     * 判断对象是否为空 list Integer String map set
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (null == obj) return true;
        if (obj instanceof String) {
            if ("".equals(((String) obj).trim())) return true;
        } else if (obj instanceof List) {
            List<Object> list = (List<Object>) obj;
            return list.isEmpty();
        } else if (obj instanceof Map) {
            Map<Object, Object> map = (Map<Object, Object>) obj;
            return map.isEmpty();
        } else if (obj instanceof Set) {
            Set<Object> set = (Set<Object>) obj;
            return set.isEmpty();
        }else if(obj instanceof Byte){
            Byte [] b = (Byte[]) obj;
            if(b.length==0) return true;
        }
        return false;
    }
}
