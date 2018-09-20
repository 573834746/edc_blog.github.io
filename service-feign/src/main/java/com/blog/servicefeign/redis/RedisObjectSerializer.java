package com.blog.servicefeign.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class RedisObjectSerializer implements RedisSerializer {


    private Converter<Object,byte[]> serializer  = new SerializingConverter();

    private Converter<byte[],Object> deserializer = new DeserializingConverter();

    @Override
    public byte[] serialize(Object o) throws SerializationException {
       if (o == null){
           return null;
       }
       return serializer.convert(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes==null){
            return  null;
        }
        return deserializer.convert(bytes);
    }
}
