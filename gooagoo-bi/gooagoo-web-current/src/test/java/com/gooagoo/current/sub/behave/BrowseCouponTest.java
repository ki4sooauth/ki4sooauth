package com.gooagoo.current.sub.behave;

import java.util.Date;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.current.utils.SendMessageUtil;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;

public class BrowseCouponTest
{
    SendMessageUtil sendMessageUtil = new SendMessageUtil();
    BrowseCoupon browseCoupon = new BrowseCoupon();

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
        behaveLog.setRemoteCode("gusm04");

        message.setContent(behaveLog);//消息内容
        this.browseCoupon.message(behaveLog);
    }

    @Test
    public void addOld() throws Exception
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);

        String id = "183M1GFTPVBSGU30KH62O3P83M56O017";
        String member = "A"; //用户类型
        String value = "01822N0IJLPA8N700C5V4PBJ43P1R5JO";//用户ID
        String channel = "3";
        String source = "W";
        Date date = TimeUtils.convertStringToDate("2013-09-09");
        TimeTag time = new TimeTag(date);

        sortedSetDao.put(id + "_B_" + member, time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel, time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source, time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source + time.day(), time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source + time.day() + time.hour(), time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source + time.week(), time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source + time.month(), time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source + time.year(), time.timestamp(), value);

        sortedSetDao.edit("Interaction", 1L, id + "_B_" + member);
        sortedSetDao.edit("Interaction", 1L, id + "_B_" + member + "_" + channel);
        sortedSetDao.edit("Interaction", 1L, id + "_B_" + member + "_" + channel + "_" + source);
        sortedSetDao.edit("Interaction", 1L, id + "_B_" + member + "_" + channel + "_" + source + time.day());
        sortedSetDao.edit("Interaction", 1L, id + "_B_" + member + "_" + channel + "_" + source + time.day() + time.hour());
        sortedSetDao.edit("Interaction", 1L, id + "_B_" + member + "_" + channel + "_" + source + time.week());
        sortedSetDao.edit("Interaction", 1L, id + "_B_" + member + "_" + channel + "_" + source + time.month());
        sortedSetDao.edit("Interaction", 1L, id + "_B_" + member + "_" + channel + "_" + source + time.year());
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
        Set<String> keys = base.keys("*");
        for (String key : keys)
        {
            System.out.println("key  : " + key);
            System.out.println("value: " + dao.get(key, 0, -1));
            System.out.println("-----------------------------");
            base.del(key);
        }
    }
}
