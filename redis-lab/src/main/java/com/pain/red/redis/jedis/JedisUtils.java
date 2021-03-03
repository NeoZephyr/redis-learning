package com.pain.red.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
    private static JedisPool jedisPool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(5);
        config.setMaxIdle(5);
        config.setMinIdle(0);
        config.setMaxWaitMillis(100);
        jedisPool = new JedisPool(config, "192.168.100.100", 6379, 100, "123456");
    }

    public static Jedis getResource() {
        if (jedisPool != null) {
            return jedisPool.getResource();
        }

        return null;
    }
}
