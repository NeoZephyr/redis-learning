package com.pain.red.redis.jedis;

import com.pain.red.redis.RedisApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {RedisApplication.class})
class JedisUtilsTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testPing() {
        redisTemplate.getConnectionFactory().getConnection().ping();
    }

    @Test
    public void testString() {
        redisTemplate.opsForValue().set("username", "pain");
        System.out.println("username: " + redisTemplate.opsForValue().get("username"));
    }
}