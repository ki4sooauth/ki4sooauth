package com.gooagoo.current.sub.behave;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.current.utils.SendMessageUtil;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;

public class FavoriteCouponTest
{
    SendMessageUtil sendMessageUtil = new SendMessageUtil();
    FavoriteCoupon coupon = new FavoriteCoupon();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        GooagooMessage<BehaveLog> message = new GooagooMessage<BehaveLog>();

        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setShopId("01822R97QK2FRDT085QBV2EIISWR0JGT");
        behaveLog.setObjectValue("183M1GFTPVBSGU30KH62O3P83M56O017"); //这个就随便生成了一个
        behaveLog.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behaveLog.setSource("W");
        behaveLog.setObjectSource("0182UOJNLFC4UVH0N5GGV0EIISWR219J");
        //behaveLog.setRemoteCode("gusm04");

        message.setContent(behaveLog);//消息内容
        this.coupon.message(behaveLog);
    }

    @After
    public void after()
    {
        //this.sendMessageUtil.close();
    }

    @Test
    public void watch()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);

        RedisDatabase base = new RedisDatabase(RedisServerConstants.statistics_coupon);
        Set<String> keys = base.keys("*_F_*");
        for (String key : keys)
        {
            System.out.println("key  : " + key);
            System.out.println("value: " + dao.get(key, 0, -1));
            System.out.println("-----------------------------");
        }
    }
}
