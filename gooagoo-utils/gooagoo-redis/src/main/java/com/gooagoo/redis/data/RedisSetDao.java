package com.gooagoo.redis.data;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.gooagoo.redis.innerTools.RedisPools;
import com.gooagoo.redis.log.RedisLog;

public class RedisSetDao
{
    private final JedisPool pool;

    public RedisSetDao(String id)
    {
        this.pool = RedisPools.getPool(id);
    }

    /**
     * 向set中添加元素
     * @param key
     * @param members
     */
    public void put(String key, String... members)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.sadd(key, members);
            RedisLog.debug("key:" + key + " members" + members);
        }
        catch (Exception e)
        {
            RedisLog.error("put", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    /** 
     * 返回set中，所有的域和值 
     * @param key 
     * @return 
     */
    public Set<?> get(String key)
    {
        Jedis jedis = this.pool.getResource();
        Set<?> set = null;
        try
        {
            set = jedis.smembers(key);
            RedisLog.debug("key:" + key + " set" + set);
        }
        catch (Exception e)
        {
            RedisLog.error("get", e);
        }
        RedisPools.release(jedis, this.pool);
        return set;
    }

    /** 
     * 删除名称为key的set中的元素member
     * @param key List别名 
     * @param field 键 
     */
    public void delElement(String key, String... members)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.srem(key, members);
            RedisLog.debug("key:" + key + " members" + members);
        }
        catch (Exception e)
        {
            RedisLog.error("del", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    /**
     * 返回集合的元素个数
     * @param key
     * @return
     */
    public long countSet(String key)
    {
        Jedis jedis = this.pool.getResource();
        Long scard = null;
        try
        {
            scard = jedis.scard(key);
            RedisLog.debug("key:" + key + " scard:" + scard);
        }
        catch (Exception e)
        {
            RedisLog.error("countSet", e);
        }
        RedisPools.release(jedis, this.pool);
        return scard;
    }
}
