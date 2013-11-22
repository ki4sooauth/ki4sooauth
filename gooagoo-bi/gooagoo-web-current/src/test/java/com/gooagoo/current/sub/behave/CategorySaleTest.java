package com.gooagoo.current.sub.behave;

import java.util.Set;

import org.junit.Test;

import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;

public class CategorySaleTest
{

    @Test
    public void test()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_categorySale);
        for (int i = 0; i < 5; i++)
        {
            dao.edit("category" + 1, 1, "goods" + 2);
        }
    }

    @Test
    public void watch()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_categorySale);
        RedisDatabase base = new RedisDatabase(RedisServerConstants.statistics_categorySale);
        Set<String> keys = base.keys("*");
        for (String key : keys)
        {
            System.out.print(key + " : ");
            Set<String> set = dao.get(key, 0, -1);
            for (String s : set)
            {
                System.out.print(" " + dao.getScore(key, s) + " - " + s);
            }
            System.out.println("");
        }
    }
}
