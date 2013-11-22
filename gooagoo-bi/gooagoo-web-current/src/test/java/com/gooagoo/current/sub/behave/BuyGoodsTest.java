package com.gooagoo.current.sub.behave;

import java.util.Set;

import org.junit.Test;

import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;

public class BuyGoodsTest
{

    @Test
    public void test()
    {
        RedisDatabase goodsSerialBase = new RedisDatabase(RedisServerConstants.statistics_goodsSerial);
        RedisDatabase goodsCategoryBase = new RedisDatabase(RedisServerConstants.statistics_goodsCategory);
        RedisDatabase goodsBrandBase = new RedisDatabase(RedisServerConstants.statistics_goodsBrand);

        RedisSortedSetDao goodsSerialDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
        RedisSortedSetDao goodsCategoryDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);
        RedisSortedSetDao goodsBrandDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);

        RedisDatabase[] bases = { goodsSerialBase, goodsCategoryBase, goodsBrandBase };
        RedisSortedSetDao[] daos = { goodsSerialDao, goodsCategoryDao, goodsBrandDao };

        for (int i = 0; i < 3; i++)
        {
            Set<String> keys = bases[i].keys("*");
            for (String key : keys)
            {
                bases[i].del(key);
            }
        }

    }

}
