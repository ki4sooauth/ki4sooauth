package com.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisListDao;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.gooagoo.redis.data.RedisStringDao;

public class RedisTest
{
    private static String id = "login";

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        //clear();

        RedisDatabase database = new RedisDatabase(id);
        Set<String> keys = database.keys("*");
        for (String key : keys)
        {
            String type = database.type(key);
            if ("zset".equals(type))
            {
                zset(key);
            }
            else if ("list".equals(type))
            {
                list(key);
            }
            else if ("string".equals(type))
            {
                string(key);
            }
            else if ("hash".equals(type))
            {
                hash(key);
            }
        }
    }

    private static void hash(String key)
    {
        System.out.println("key:" + key);
        RedisHashDao hashDao = new RedisHashDao(id);
        Map<String, String> map = hashDao.get(key);
        for (String element : map.keySet())
        {
            System.out.println("\t element:" + element + " value:" + map.get(element));
        }
    }

    private static void string(String key)
    {
        RedisStringDao stringDao = new RedisStringDao(id);
        String value = stringDao.get(key);
        System.out.println("key:" + key + "\tvalue:" + value);
    }

    private static void list(String key)
    {
        System.out.println("key:" + key);
        RedisListDao listDao = new RedisListDao(id);
        List<String> list = listDao.get(key);
        for (String string : list)
        {
            System.out.println("\t" + string);
        }
    }

    private static void zset(String key)
    {
        System.out.println("key:" + key);
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(id);
        Set<String> keys = sortedSetDao.get(key, 0, -1);
        for (String string : keys)
        {
            System.out.println("\t element:" + string + " score:" + sortedSetDao.getScore(key, string));
        }
    }

    private static void clear()
    {
        RedisDatabase database = new RedisDatabase(id);
        database.flushDB();
    }

}
