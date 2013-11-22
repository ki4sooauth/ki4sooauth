package com.gooagoo.current;

import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;

public class InitDatabase
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        positionSale();

    }

    public static void categorySale()
    {
        RedisDatabase database = new RedisDatabase(RedisServerConstants.statistics_categorySale);
        database.flushDB();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_categorySale);
        sortedSetDao.put("品类id", 1, "商品id");
    }

    public static void positionSale()
    {
        RedisDatabase database = new RedisDatabase(RedisServerConstants.statistics_positionSale);
        database.flushDB();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_positionSale);
        sortedSetDao.put("189B22UOLGUFQS00A1BAQJA6LPNDK9KJ", 2568, "188JMPE37458G000A1BAQJA6QBRK2V56");
        sortedSetDao.put("189B22UOLGUFQS00A1BAQJA6LPNDK9KJ", 2810, "188JOQNSQNKPHN00A1BAQJA6DIRK2VOD");
        sortedSetDao.put("189B22UOLGUFQS00A1BAQJA6LPNDK9KJ", 3244, "188JPDOTPRT3P100A1BAQJA6JERK2VU9");
        sortedSetDao.put("189B22UOLGUFQS00A1BAQJA6LPNDK9KJ", 4879, "188JQKD7DPGD6400A1BAQJA654RK20G0");
        sortedSetDao.put("189B22UOLGUFQS00A1BAQJA6LPNDK9KJ", 9821, "188JQS8CQRKC1H00A1BAQJA661RK20GT");
        sortedSetDao.put("189B22UOLGUFQS00A1BAQJA6LPNDK9KJ", 3686, "188JR7N1G03DCG00A1BAQJA68DRK20J9");
        sortedSetDao.put("189B22UOLGUFQS00A1BAQJA6LPNDK9KJ", 3870, "188JRBNPB06JKK00A1BAQJA69HRK20KD");
        sortedSetDao.put("189B22UOLGUFQS00A1BAQJA6LPNDK9KJ", 6705, "188JRH9JJKOC3900A1BAQJA6B9RK20M5");
        sortedSetDao.put("189B22UOLGUFQS00A1BAQJA6LPNDK9KJ", 4128, "188O3C5M56RRON00A1BAQJA63E4BI6JV");
        sortedSetDao.put("189B22UOLGUFQS00A1BAQJA6LPNDK9KJ", 6580, "189I9960K3RKOA00A1BAQJA6U6MU4BHH");

    }
}
