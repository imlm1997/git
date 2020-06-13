package com.qf;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class JedisDemo {


    @Test
    public void test1() {
        Jedis jedis = new Jedis("47.104.101.140",6379);

        String name = jedis.get("name");
        System.out.println(name);

        jedis.set("password","123");
        System.out.println(jedis.get("password"));

        jedis.close();

    }
    @Test
    public void test2() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();

        poolConfig.setMaxIdle(30); //最大闲置个数

        poolConfig.setMinIdle(10); //最小闲置个数

        poolConfig.setMaxTotal(50); //最大连接个数
        // 创建一个redis的连接池
        JedisPool pool = new JedisPool(poolConfig, "47.104.101.140", 6379);
        // 从池子中获取redis的链接资源
        Jedis jedis = pool.getResource();
        // 添加数据
        jedis.set("age","18");
        System.out.println(jedis.get("age"));
        // 关闭资源
        jedis.close();
        pool.close();


    }
}
