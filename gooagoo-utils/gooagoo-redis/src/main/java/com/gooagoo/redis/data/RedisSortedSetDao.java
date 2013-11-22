package com.gooagoo.redis.data;

import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.gooagoo.redis.innerTools.RedisPools;
import com.gooagoo.redis.log.RedisLog;

public class RedisSortedSetDao
{
    private final JedisPool pool;

    public RedisSortedSetDao(String id)
    {
        this.pool = RedisPools.getPool(id);
    }

    /**
     * 向有序集合中添加元素
     * @param key 键
     * @param score 分数
     * @param value 元素
     */
    public void put(String key, double score, String value)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.zadd(key, score, value);
            RedisLog.debug("key:" + key + " score:" + score + " value:" + value);
        }
        catch (Exception e)
        {
            RedisLog.error("put", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    /**
     * 向有序集合中添加元素
     * @param key 键
     * @param score 分数
     * @param value 元素
     */
    public void put(String key, Map<Double, String> scoreMembers)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.zadd(key, scoreMembers);
            RedisLog.debug("key:" + key + " scoreMembers:" + scoreMembers);
        }
        catch (Exception e)
        {
            RedisLog.error("put", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    public Double getScore(String key, String member)
    {
        Jedis jedis = this.pool.getResource();
        Double value = null;
        try
        {
            value = jedis.zscore(key, member);
            RedisLog.debug("key:" + key + " member:" + member + " score:" + value);
        }
        catch (Exception e)
        {
            RedisLog.error("getScore", e);
        }
        RedisPools.release(jedis, this.pool);
        if (value != null)
        {
            return value;
        }
        else
        {
            return 0.0;
        }
    }

    public Set<String> get(String key, long start, long end)
    {
        Jedis jedis = this.pool.getResource();
        Set<String> value = null;
        try
        {
            value = jedis.zrange(key, start, end);
            RedisLog.debug("key:" + key + " start:" + start + " end:" + end);
        }
        catch (Exception e)
        {
            RedisLog.error("get", e);
        }
        RedisPools.release(jedis, this.pool);
        return value;
    }

    public Set<String> getDesc(String key, long start, long end)
    {
        Jedis jedis = this.pool.getResource();
        Set<String> value = null;
        try
        {
            value = jedis.zrevrange(key, start, end);
            RedisLog.debug("key:" + key + " start:" + start + " end:" + end);
        }
        catch (Exception e)
        {
            RedisLog.error("getDesc", e);
        }
        RedisPools.release(jedis, this.pool);
        return value;
    }

    /**
     * 正序取指定区间内的集合
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> getAsc(String key, long start, long end)
    {
        Jedis jedis = this.pool.getResource();
        Set<String> value = null;
        try
        {
            value = jedis.zrange(key, start, end);
            RedisLog.debug("key:" + key + " start:" + start + " end:" + end);
        }
        catch (Exception e)
        {
            RedisLog.error("getAsc", e);
        }
        RedisPools.release(jedis, this.pool);
        return value;
    }

    /**
     * 返回集合在score指定区间内的元素
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<String> zrangeByScore(String key, long min, long max)
    {
        Jedis jedis = this.pool.getResource();
        Set<String> value = null;
        try
        {
            value = jedis.zrangeByScore(key, min, max);
            RedisLog.debug("key:" + key + " min:" + min + " max:" + max);
        }
        catch (Exception e)
        {
            RedisLog.error("zrangeByScore", e);
        }
        RedisPools.release(jedis, this.pool);
        return value;
    }

    /**
     * 返回集合内元素的个数
     * @param key
     * @return
     */
    public long zcard(String key)
    {
        Jedis jedis = this.pool.getResource();
        long value = 0;
        try
        {
            value = jedis.zcard(key);
            RedisLog.debug("key:" + key + " zcard:" + value);
        }
        catch (Exception e)
        {
            RedisLog.error("zrangeByScore", e);
        }
        RedisPools.release(jedis, this.pool);
        return value;
    }

    /**
     * 删除score在指定区间内的元素
     * @param key
     * @param start
     * @param end
     */
    @SuppressWarnings("unused")
    public void zremrangeByScore(String key, double start, double end)
    {
        Jedis jedis = this.pool.getResource();
        Set<String> value = null;
        try
        {
            jedis.zremrangeByScore(key, start, end);
            RedisLog.debug("key:" + key + " start:" + start + " end:" + end);
        }
        catch (Exception e)
        {
            RedisLog.error("zrangeByScore", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    /**
     * 删除set内单个元素
     * @param key
     * @param members
     */
    public void delElement(String key, String... members)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.zrem(key, members);
            RedisLog.debug("key:" + key + " members" + members);
        }
        catch (Exception e)
        {
            RedisLog.error("delElement", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    /**
     * 编辑有序集合value元素的分数
     * @param key
     * @param score
     * @param value
     */
    public void edit(String key, double score, String value)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            jedis.zincrby(key, score, value);
            RedisLog.debug("key:" + key + " score:" + score + " value:" + value);
        }
        catch (Exception e)
        {
            RedisLog.error("edit", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    public long zcount(String key, double min, double max)
    {
        Jedis jedis = this.pool.getResource();
        long count = 0;
        try
        {
            count = jedis.zcount(key, min, max);
            RedisLog.debug("key:" + key + " min:" + min + " max:" + max + " count:" + count);
        }
        catch (Exception e)
        {
            RedisLog.error("edit", e);
        }
        RedisPools.release(jedis, this.pool);
        return count;
    }
}
