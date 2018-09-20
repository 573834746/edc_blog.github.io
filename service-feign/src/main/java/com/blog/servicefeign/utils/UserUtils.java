package com.blog.servicefeign.utils;

import com.blog.servicefeign.pojo.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    @Autowired
    RedisTemplate redisTemplate;

    public UsersVo getUserFromRedis(String uuid){
        if(uuid==null){
            return null;
        }
        Object o = redisTemplate.opsForValue().get(uuid);
        if(o==null){
            return null;
        }
        return (UsersVo) o;
    }
}
