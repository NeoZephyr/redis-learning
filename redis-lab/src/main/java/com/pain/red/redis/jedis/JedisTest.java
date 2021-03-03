package com.pain.red.redis.jedis;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = JedisUtils.getResource();
        System.out.println(jedis.ping("hello"));
        jedis.close();
    }
}
