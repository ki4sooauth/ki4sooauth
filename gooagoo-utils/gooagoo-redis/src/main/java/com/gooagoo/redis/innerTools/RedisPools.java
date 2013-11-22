package com.gooagoo.redis.innerTools;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.gooagoo.redis.entity.RedisConfig;
import com.gooagoo.redis.log.RedisLog;

public class RedisPools
{
    private static Map<String, JedisPool> pools = new HashMap<String, JedisPool>();
    private static Map<String, RedisConfig> map = new HashMap<String, RedisConfig>();

    static
    {
        try
        {
            RedisLog.info("开始读取redis配置文件");
            ResourceBundle bundle = ResourceBundle.getBundle("redisConfig");
            Enumeration<String> en = bundle.getKeys();
            RedisConfig temp = null;
            while (en.hasMoreElements())
            {
                String string = en.nextElement();
                String[] value = bundle.getString(string).split(":");
                temp = new RedisConfig();
                temp.setServer(value[0]);
                temp.setPort(value[1]);
                temp.setDatabase(value[2]);
                map.put(string, temp);
                RedisLog.debug(string + " = " + bundle.getString(string));
            }
        }
        catch (Exception e)
        {
            RedisLog.error("读取redis配置文件异常", e);
        }
    }

    public static synchronized JedisPool getPool(String id)
    {
        if (!pools.containsKey(id))
        {
            RedisLog.debug("new pools Id:" + id);
            RedisConfig conf = map.get(id);
            JedisPoolConfig config = new JedisPoolConfig();//Jedis池配置
            config.setMaxActive(300);//最大活动的对象个数
            config.setMaxIdle(100);//对象最大空闲时间
            config.setMaxWait(10000);//获取对象时最大等待时间

            config.setTestOnBorrow(true);
            JedisPool sPool = new JedisPool(config, conf.getServer(), conf.getPort(), 3000, null, conf.getDatabase());
            pools.put(id, sPool);
            return sPool;
        }
        else
        {
            RedisLog.debug("pools Id:" + id);
            return pools.get(id);
        }
    }

    public static void release(Jedis jedis, JedisPool pool)
    {
        try
        {
            pool.returnResource(jedis);
            RedisLog.debug("returnResource");
        }
        catch (Exception e)
        {
            RedisLog.error("returnBrokenResource", e);
            if (jedis != null)
            {
                pool.returnBrokenResource(jedis);
            }
        }
    }
}
