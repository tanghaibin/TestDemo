package top.tanghaibin.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by tangh on 2016/5/8.
 */
public class RedisTest {

    JedisPool pool = new JedisPool(new JedisPoolConfig(),"localhost");
    Jedis jedis = pool.getResource();

    @Test
    public void testSet(){
        jedis.set("ONE","1");
        System.out.println(jedis.get("ONE"));
    }
}
