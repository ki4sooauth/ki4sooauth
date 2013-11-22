package com.gooagoo.redis.data;

import java.util.Iterator;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.gooagoo.redis.innerTools.RedisPools;
import com.gooagoo.redis.log.RedisLog;

public class RedisListDao
{
    private final JedisPool pool;

    public RedisListDao(String id)
    {
        this.pool = RedisPools.getPool(id);
    }

    public void set(String key, List<String> list)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            RedisLog.debug("key:" + key + " list:" + list);
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext())
            {
                jedis.rpush(key, iterator.next());
            }
        }
        catch (Exception e)
        {
            RedisLog.error("set", e);
        }

        RedisPools.release(jedis, this.pool);
    }

    public void put(String key, String... strings)
    {
        Jedis jedis = this.pool.getResource();
        try
        {
            RedisLog.debug("key:" + key + " values:" + strings);
            jedis.rpush(key, strings);
        }
        catch (Exception e)
        {
            RedisLog.error("put", e);
        }
        RedisPools.release(jedis, this.pool);
    }

    /**
     * 获取整个list
     * @param key
     * @return
     */
    public List<String> get(String key)
    {
        Jedis jedis = this.pool.getResource();
        List<String> list = null;
        try
        {
            list = jedis.lrange(key, 0, -1);
            RedisLog.debug("key:" + key + " list:" + list);
        }
        catch (Exception e)
        {
            RedisLog.error("get", e);
        }
        RedisPools.release(jedis, this.pool);
        return list;
    }

    /** 
     * 判断member元素是否是集合key的成员。是（true），否则（false）    
     * @param key 
     * @param field 
     * @return 
     */
    public boolean isMember(String key, String field)
    {
        Jedis jedis = this.pool.getResource();
        boolean isMember = false;
        try
        {
            RedisLog.debug("key:" + key + " field:" + field);
            isMember = jedis.sismember(key, field);
        }
        catch (Exception e)
        {
            RedisLog.error("isMember", e);
        }
        RedisPools.release(jedis, this.pool);
        return isMember;
    }

    /** 
     * 获取List中指定范围的元素
     * LRANGE key start stop返回列表key中指定区间内的元素，区间以偏移量start和stop指定。 
          * 下标(index)参数start和stop都以0为底，也就是说，以0表示列表的第一个元素，以1表示列表的第二个元素，以此类推。 
          * 也可以使用负数下标，以-1表示列表的最后一个元素，-2表示列表的倒数第二个元素，以此类推。 
     * @param key List别名 
     * @param start 开始下标 
     * @param end 结束下标 
     * @return 
     */
    public List<String> getRange(String key, long start, long end)
    {
        Jedis jedis = this.pool.getResource();
        List<String> list = null;
        try
        {
            list = jedis.lrange(key, start, end);
            RedisLog.debug("key:" + key + " start:" + start + " end:" + end);
        }
        catch (Exception e)
        {
            RedisLog.error("getRange", e);
        }
        RedisPools.release(jedis, this.pool);
        return list;
    }
}
