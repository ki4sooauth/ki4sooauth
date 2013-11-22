package com.gooagoo.redis.data;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.gooagoo.redis.innerTools.ObjectUtils;
import com.gooagoo.redis.innerTools.RedisPools;
import com.gooagoo.redis.log.RedisLog;

public class RedisObjectDao
{
    private final JedisPool pool;

    public RedisObjectDao(String id)
    {
        this.pool = RedisPools.getPool(id);
    }

    public void set(String key, Object obj)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            RedisLog.debug("key:" + key + " obj:" + obj);
            jedis.set(key.getBytes(), ObjectUtils.serialize(obj));
        }
        catch (Exception e)
        {
            RedisLog.error("set", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    @SuppressWarnings("unchecked")
    public <T> T getGenerics(String key, Class<T> Clazz)
    {
        Jedis jedis = this.pool.getResource();
        Object obj = null;
        try
        {
            RedisLog.debug("key:" + key + " Clazz:" + Clazz);
            byte[] byteObj = jedis.get(key.getBytes());
            obj = ObjectUtils.unserialize(byteObj);
        }
        catch (Exception e)
        {
            RedisLog.error("getGenerics", e);
        }
        RedisPools.release(jedis, this.pool);
        return (T) obj;
    }

    public Object get(String key)
    {
        Jedis jedis = this.pool.getResource();
        Object obj = null;
        try
        {
            byte[] byteObj = jedis.get(key.getBytes());
            obj = ObjectUtils.unserialize(byteObj);
            RedisLog.debug("key:" + key + " obj:" + obj);
        }
        catch (Exception e)
        {
            RedisLog.error("get", e);
        }
        RedisPools.release(jedis, this.pool);
        return obj;
    }
}
