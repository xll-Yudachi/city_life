package com.yudachi.citylife.util;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

public class RedisUtil{
    //Redis服务器IP
    private static String addr = "xxx";
    
    //Redis的端口号
    private static int port = 6380;
    
    //访问密码
    private static String auth;

    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int maxActive = 8;
    
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int maxIdle = 8;
    
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int maxWait = 10000;
    
    private static int timeOut = 10000;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean testOnBorrow;

    //非切片额客户端连接
    public static Jedis jedis;

    //非切片连接池
    public static JedisPool jedisPool;

    //切片额客户端连接
    public static ShardedJedis shardedJedis;

    //切片连接池
    public static ShardedJedisPool shardedJedisPool;
    
    private static void initialPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxActive); 
        config.setMaxIdle(maxIdle); 
        config.setMaxWaitMillis(maxWait); 
        config.setTestOnBorrow(testOnBorrow);
        jedisPool = new JedisPool(config, addr, port);
    }
    private static  void initialShardedPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxActive); 
        config.setMaxIdle(maxIdle); 
        config.setMaxWaitMillis(maxWait); 
        config.setTestOnBorrow(testOnBorrow);
        // slave链接 
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo(addr, port, auth)); 

        // 构造池 
        shardedJedisPool = new ShardedJedisPool(config, shards); 
    }

    public static Jedis getJedis(){
        initialPool();
        try {
            jedis = jedisPool.getResource();
            return jedis;
        } catch (Exception e) {
            System.out.println("连接jedisPool失败!");
        }
        return null;
    }
}