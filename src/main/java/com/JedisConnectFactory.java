package com;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectFactory {
    private static final JedisPool jedisPoll;

    static {
        JedisPoolConfig poolConfig =new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(0);
        poolConfig.setMaxWaitMillis(1000);

        jedisPoll = new JedisPool(poolConfig,"192.168.",6379,1000,"Lgd");

    }

    public static Jedis getJedis(){
        return jedisPoll.getResource();
    }
}
