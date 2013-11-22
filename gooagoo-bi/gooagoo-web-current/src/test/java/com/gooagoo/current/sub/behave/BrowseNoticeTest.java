package com.gooagoo.current.sub.behave;

import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.math.RandomUtils;
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
import com.gooagoo.redis.data.RedisHashDao;
import com.gooagoo.redis.data.RedisSortedSetDao;

public class BrowseNoticeTest
{
    SendMessageUtil sendMessageUtil = new SendMessageUtil();
    BrowseNotice browseNotice = new BrowseNotice();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        GooagooMessage<BehaveLog> message = new GooagooMessage<BehaveLog>();

        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setShopId("01822MAPVKNP054085QBQVEIISWR0JGT");
        behaveLog.setObjectValue("0182IB2S8OTFVMB0U2LBVCEIISWR2647"); //这个就随便生成了一个
        behaveLog.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behaveLog.setSource("W");
        behaveLog.setObjectType("N");
        //behaveLog.setObjectSource("0182UOJNLFC4UVH0N5GGV0EIISWR219J");
        behaveLog.setRemoteCode("test6");

        message.setContent(behaveLog);//消息内容
        this.browseNotice.message(behaveLog);
    }

    @After
    public void after()
    {
        //sendMessageUtil.close();
    }

    @Test
    public void addOld() throws Exception
    {
        String id = "183M1GFTPVBSGU30KH62O3P83M56O017";
        String member = "A";
        String value = "01822N0IJLPA8N700C5V4PBJ43P1R5JO";
        String source = "W";
        Date date = TimeUtils.convertStringToDate("2013-09-10");
        TimeTag time = new TimeTag(date);
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_notice);
        sortedSetDao.put(id + "_" + member, time.timestamp(), value);
        sortedSetDao.put(id + "_" + member + "_" + source, time.timestamp(), value);
        sortedSetDao.put(id + "_" + member + "_" + source + time.day(), time.timestamp(), value);
        sortedSetDao.put(id + "_" + member + "_" + source + time.day() + time.hour(), time.timestamp(), value);
        sortedSetDao.put(id + "_" + member + "_" + source + time.week(), time.timestamp(), value);
        sortedSetDao.put(id + "_" + member + "_" + source + time.month(), time.timestamp(), value);
        sortedSetDao.put(id + "_" + member + "_" + source + time.year(), time.timestamp(), value);

        sortedSetDao.edit("Interaction", 1L, id + "_" + member);
        sortedSetDao.edit("Interaction", 1L, id + "_" + member + "_" + source);
        sortedSetDao.edit("Interaction", 1L, id + "_" + member + "_" + source + time.day());
        sortedSetDao.edit("Interaction", 1L, id + "_" + member + "_" + source + time.day() + time.hour());
        sortedSetDao.edit("Interaction", 1L, id + "_" + member + "_" + source + time.week());
        sortedSetDao.edit("Interaction", 1L, id + "_" + member + "_" + source + time.month());
        sortedSetDao.edit("Interaction", 1L, id + "_" + member + "_" + source + time.year());
    }

    @Test
    public void watch()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_notice);
        RedisDatabase base = new RedisDatabase(RedisServerConstants.statistics_notice);
        Set<String> keys = base.keys("*");
        for (String key : keys)
        {
            base.del(key);
            System.out.println("key  : " + key);
            System.out.println("value: " + dao.get(key, 0, -1));
            System.out.println("-----------------------------");
        }
    }

    @Test
    public void addUser()
    {
        String[] shops = { "shop001", "shop002", "shop003", "shop004", "shop005" };
        String[] users = { "user001", "user002", "user003", "user004", "user005" };
        RedisHashDao hashDao = new RedisHashDao(RedisServerConstants.business_user_shop);
        for (int i = 0; i < 50; i++)
        {
            hashDao.put(users[RandomUtils.nextInt(5)] + "_" + shops[RandomUtils.nextInt(5)], "isMember", "true");
        }
    }

    @Test
    public void watchUser()
    {
        RedisDatabase base = new RedisDatabase(RedisServerConstants.business_user_shop);
        Set<String> keys = base.keys("*");
        for (String key : keys)
        {
            System.out.println(key);
        }
    }
}
