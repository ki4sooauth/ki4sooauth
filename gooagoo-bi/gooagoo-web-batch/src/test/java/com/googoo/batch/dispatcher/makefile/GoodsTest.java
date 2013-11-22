package com.googoo.batch.dispatcher.makefile;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisHashDao;

public class GoodsTest
{

    @Test
    public void test()
    {
        Goods goods = new Goods();
        goods.run();
    }

    @Test
    public void watch()
    {
        RedisHashDao dao = new RedisHashDao(RedisServerConstants.business_goods);
        RedisDatabase keyDao = new RedisDatabase(RedisServerConstants.business_goods);
        Set<String> keys = keyDao.keys("*");
        for (String key : keys)
        {
            Map<String, String> map = dao.get(key);
            if (map != null)
            {
                map.put("goodsId", key);
                System.out.println(map.get("shopEntityId") + " - " + map.get("goodsSerial") + " - " + map.get("goodsId"));
            }
        }

    }
}
