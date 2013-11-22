package com.gooagoo.redis.data;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.gooagoo.redis.innerTools.RedisPools;
import com.gooagoo.redis.log.RedisLog;

public class RedisDatabase
{
    private JedisPool pool;

    public RedisDatabase(String id)
    {
        this.pool = RedisPools.getPool(id);
    }

    public Long count()
    {
        Jedis jedis = this.pool.getResource();
        long count = 0L;
        try
        {
            count = jedis.dbSize();
            RedisLog.debug("count:" + count);
        }
        catch (Exception e)
        {
            RedisLog.error("count", e);
        }
        RedisPools.release(jedis, this.pool);
        return count;
    }

    public Set<String> keys(String pattern)
    {
        Jedis jedis = this.pool.getResource();
        Set<String> keys = null;
        try
        {
            keys = jedis.keys(pattern);
            RedisLog.debug("pattern:" + pattern);
        }
        catch (Exception e)
        {
            RedisLog.error("keys", e);
        }
        RedisPools.release(jedis, this.pool);
        return keys;
    }

    /** 
     * 检查key是否存在 
     * @param key 
     * @return 
     */
    public boolean exists(String key)
    {
        Jedis jedis = this.pool.getResource();
        boolean bool = false;
        try
        {
            bool = jedis.exists(key);
            RedisLog.debug("key:" + key + " exists:" + bool);
        }
        catch (Exception e)
        {
            RedisLog.error("exists", e);
        }
        RedisPools.release(jedis, this.pool);
        return bool;
    }

    /** 
     * 返回key值的类型  none(key不存在),string(字符串),list(列表),set(集合),zset(有序集),hash(哈希表)  
     * @param key 
     * @return 
     */
    public String type(String key)
    {
        Jedis jedis = this.pool.getResource();
        String type = null;
        try
        {
            type = jedis.type(key);
            RedisLog.debug("key:" + key + " type:" + type);
        }
        catch (Exception e)
        {
            RedisLog.error("type", e);
        }
        RedisPools.release(jedis, this.pool);
        return type;
    }

    /**
     * 清空数据库
     */
    public void flushDB()
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            String result = jedis.flushDB();
            RedisLog.debug("flushDB:" + result);
        }
        catch (Exception e)
        {
            RedisLog.error("flushDB", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    /** 
     * 为给定key设置生命周期 
     * @param key 
     * @param seconds 生命周期 秒为单位 
     */
    public void setExpire(String key, int seconds)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.expire(key, seconds);
            RedisLog.debug("key:" + key + "seconds:" + seconds);
        }
        catch (Exception e)
        {
            RedisLog.error("Expire", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    public void del(String... keys)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.del(keys);
            RedisLog.debug("delete key:" + keys);
        }
        catch (Exception e)
        {
            RedisLog.error("del", e);
        }
        RedisPools.release(jedis, this.pool);
    }
}
