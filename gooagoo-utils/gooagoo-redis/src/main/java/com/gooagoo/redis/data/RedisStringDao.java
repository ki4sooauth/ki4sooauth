package com.gooagoo.redis.data;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.gooagoo.redis.innerTools.RedisPools;
import com.gooagoo.redis.log.RedisLog;

public class RedisStringDao
{
    private final JedisPool pool;

    public RedisStringDao(String id)
    {
        this.pool = RedisPools.getPool(id);
    }

    public void set(String key, String value)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.set(key, value);
            RedisLog.debug("key:" + key + " value:" + value);
        }
        catch (Exception e)
        {
            RedisLog.error("set", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    /** 
     * 添加有生命周期的元素
     * @param key  
     * @param seconds 生命周期 秒为单位 
     * @param value 
     */
    public void set(String key, int seconds, String value)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.setex(key, seconds, value);
            RedisLog.debug("key:" + key);
        }
        catch (Exception e)
        {
            RedisLog.error("set", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    /** 
     * 获取key的值 
     * @param key 
     * @return 
     */
    public String get(String key)
    {
        Jedis jedis = this.pool.getResource();
        String value = null;
        try
        {
            value = jedis.get(key);
            RedisLog.debug("key:" + key + " value:" + value);
        }
        catch (Exception e)
        {
            RedisLog.error("get", e);
        }
        RedisPools.release(jedis, this.pool);
        return value;
    }

    /** 
     * 如果key已经存在并且是一个字符串，将value追加到key原来的值之后 
     * @param key 
     * @param value 
     */
    public void append(String key, String value)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.append(key, value);
            RedisLog.debug("key:" + key + " value:" + value);
        }
        catch (Exception e)
        {
            RedisLog.error("append", e);
        }
        RedisPools.release(jedis, this.pool);
    }
}
