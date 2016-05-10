package top.tanghaibin.redis;

/**
 * Created by tangh on 2016/5/10.
 */

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class DictionaryDao {


    private RedisTemplate<Object,Object> redisTemplate;

    @Inject
    public DictionaryDao(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }


    /**
     * 对string类型的数据结构进行操作
     * @param key
     */
    public void testStringOption(String key,Object value){
        flush();
        RedisTemplate redisTemplate = this.redisTemplate;
        redisTemplate.setValueSerializer(new StringRedisSerializer());//使用string的序列化
        redisTemplate.opsForValue().set(key,value);
        Object obj = redisTemplate.opsForValue().get(key);
        System.out.println(obj.toString());
    }

    /**
     * 对list列表类型的操作
     * @param value
     */
    public void testListOption(String key,List<Object> value){
        flush();
        Long index = redisTemplate.opsForList().leftPush("testList",value);
        value = redisTemplate.opsForList().range(key,0,-1);
        System.out.println(value);
    }

    /**
     * 对无序set的操作
     * @param key
     * @param value
     */
    public void testSetOption(String key,Object value){
        flush();
        redisTemplate.opsForSet().add(key,value);
        Set<Object> set = redisTemplate.opsForSet().members(key);
        System.out.println(set);
    }

    /**
     * 对有序set进行操作
     * @param key
     * @param map
     */
    public void testOrderSetOption(String key,Map<Object,Integer> map){
        flush();
        Set<Object> set = map.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            Object value = iterator.next();
            Integer number = map.get(value);
            redisTemplate.opsForZSet().add(key,value,number);
        }
        Set<Object> set2 = redisTemplate.opsForZSet().range(key, 0, 2);
        System.out.println(set2);
    }

    /**
     * 对hash进行操作
     * @param key
     * @param map
     */
    public void testHashOption(String key,Map<Object,Object> map){
        flush();
        redisTemplate.opsForHash().putAll(key, map);
        map = redisTemplate.opsForHash().entries(key);
        System.out.println(map);
    }
    /**
     * 清除内存中的数据
     */
    public void flush(){
        redisTemplate.getConnectionFactory().getConnection().flushDb();
    }
}