package com.blog.servicezuul.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {


    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        return  new JedisConnectionFactory();
    }

    @Bean
    public StringRedisSerializer stringRedisSerializer(){
        return new StringRedisSerializer();
    }

    @Bean
    public RedisObjectSerializer redisObjectSerializer(){
        return new RedisObjectSerializer();
    }

    @Bean
    public RedisTemplate redisTemplate(){
       RedisTemplate redisTemplate = new RedisTemplate();
       redisTemplate.setKeySerializer(stringRedisSerializer());
       redisTemplate.setValueSerializer(redisObjectSerializer());
       redisTemplate.setConnectionFactory(jedisConnectionFactory());
       return redisTemplate;
    }
}
