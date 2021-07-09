package com.xyz.base.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * redis配置类
 */
@Configuration
public class RedisConfig {
    @Resource
    private RedisConnectionFactory redisConnectionFactory;
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // string key 序列化
        redisTemplate.setStringSerializer(new StringRedisSerializer());
        // string key 序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // hash key 序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // hash value 序列化
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        return redisTemplate;
    }
}
