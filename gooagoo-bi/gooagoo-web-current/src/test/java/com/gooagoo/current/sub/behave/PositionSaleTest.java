package com.gooagoo.current.sub.behave;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.current.utils.SendMessageUtil;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;

public class PositionSaleTest
{
    SendMessageUtil sendMessageUtil = new SendMessageUtil();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_positionSale);
        for (int i = 0; i < 5; i++)
        {
            dao.edit("position" + 3, 1, "goods" + i);
        }
    }

    @Test
    public void watch()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_positionSale);
        RedisDatabase base = new RedisDatabase(RedisServerConstants.statistics_positionSale);
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

    @Test
    public void find()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_positionSale);
        Set<String> set = dao.getDesc("position3", 0, 2);
        for (String s : set)
        {
            System.out.println(s + " , score :" + dao.getScore("position3", s));
        }
        //System.out.println(set);
    }

    @After
    public void after()
    {
        this.sendMessageUtil.close();
    }
}
