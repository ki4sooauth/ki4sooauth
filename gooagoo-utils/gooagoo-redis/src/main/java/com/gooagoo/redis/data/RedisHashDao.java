package com.gooagoo.redis.data;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.gooagoo.redis.innerTools.RedisPools;
import com.gooagoo.redis.log.RedisLog;

public class RedisHashDao
{
    private final JedisPool pool;

    public RedisHashDao(String id)
    {
        this.pool = RedisPools.getPool(id);
    }

    public void set(String key, Map<String, String> map)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.hmset(key, map);
            RedisLog.debug("key:" + key + " map:" + map);
        }
        catch (Exception e)
        {
            RedisLog.error("set", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    public void put(String key, String field, String value)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.hset(key, field, value);
            RedisLog.debug("key:" + key + " field:" + field + " value:" + value);
        }
        catch (Exception e)
        {
            RedisLog.error("set", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    public List<String> get(String key, String... fields)
    {
        Jedis jedis = this.pool.getResource();
        List<String> value = null;
        try
        {
            value = jedis.hmget(key, fields);
            RedisLog.debug("key:" + key + " field:" + fields);
        }
        catch (Exception e)
        {
            RedisLog.error("get", e);
        }
        RedisPools.release(jedis, this.pool);
        return value;
    }

    /** 
     * 返回哈希表key中，所有的域和值 
     * @param key 
     * @return 
     */
    public Map<String, String> get(String key)
    {
        Jedis jedis = this.pool.getResource();
        Map<String, String> map = null;
        try
        {
            map = jedis.hgetAll(key);
            RedisLog.debug("key:" + key + " map:" + map);
        }
        catch (Exception e)
        {
            RedisLog.error("get", e);
        }
        RedisPools.release(jedis, this.pool);
        return map;
    }

    public String getMapElement(String key, String field)
    {
        Jedis jedis = this.pool.getResource();
        String value = null;
        try
        {
            value = jedis.hget(key, field);
            RedisLog.debug("key:" + key + " field:" + field + " value:" + value);
        }
        catch (Exception e)
        {
            RedisLog.error("getElement", e);
        }
        return value;
    }
}
