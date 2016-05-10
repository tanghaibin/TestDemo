package top.tanghaibin.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by tangh on 2016/5/10.
 */
@Configuration//标注用此类作为spring的配置类；提供bean的定义；就如同xml中配置<bean>
@ComponentScan("top.tanghaibin.redis")
public class LocalRedisConfig {

    @Bean
    public RedisConnectionFactory jedisConnectionFactory(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.maxActive = 10;
        poolConfig.maxIdle = 5;
        poolConfig.minIdle = 1;
        poolConfig.testOnBorrow = true;
        poolConfig.testOnReturn = true;
        poolConfig.testWhileIdle = true;
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

}