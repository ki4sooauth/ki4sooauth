package com.gooagoo.current.sub.behave;

import java.util.Set;

import org.junit.Test;

import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisDatabase;

public class BrowseGoodsTest
{

    @Test
    public void test()
    {
        BehaveLog b = new BehaveLog();
        b.setObjectValue("01822TIHISRNTBT07GRNHGEIISWR2K8D");
        b.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        b.setSource("W");
        b.setObjectSource("0182UOJNLFC4UVH0N5GGV0EIISWR219J");
        b.setObjectType("G");

        BrowseGoods goods = new BrowseGoods();
        goods.message(b);
    }

    @Test
    public void del()
    {
        RedisDatabase baseSerial = new RedisDatabase(RedisServerConstants.statistics_goodsSerial);
        RedisDatabase baseBrand = new RedisDatabase(RedisServerConstants.statistics_goodsBrand);
        RedisDatabase baseCategory = new RedisDatabase(RedisServerConstants.statistics_goodsCategory);

        RedisDatabase[] bases = { baseSerial, baseBrand, baseCategory };
        for (RedisDatabase base : bases)
        {
            Set<String> keys = base.keys("*");
            for (String key : keys)
            {
                base.del(key);
            }
        }
    }

}
