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

public class BrowseToolsTest
{
    SendMessageUtil sendMessageUtil = new SendMessageUtil();
    BrowseTools browseTools = new BrowseTools();

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
        //behaveLog.setSource("W");
        //behaveLog.setObjectSource("0182UOJNLFC4UVH0N5GGV0EIISWR219J");
        behaveLog.setRemoteCode("test1");

        message.setContent(behaveLog);//消息内容
        this.browseTools.message(behaveLog);
    }

    @Test
    public void addOld() throws Exception
    {
        String toolsId = "183M1GFTPVBSGU30KH62O3P83M56O017";
        String memberType = "A"; //用户类型
        String value = "01822N0IJLPA8N700C5V4PBJ43P1R5JO";//用户ID
        Date date = TimeUtils.convertStringToDate("2013-09-10");
        TimeTag time = new TimeTag(date);

        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_tools);
        sortedSetDao.put(toolsId + "_B_" + memberType, time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.day(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.day() + time.hour(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.month(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.week(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.year(), time.timestamp(), value);

        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType);
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.day());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.day() + time.hour());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.month());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.week());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.year());
    }

    @After
    public void after()
    {
        this.sendMessageUtil.close();
    }

    @Test
    public void watch()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_tools);

        RedisDatabase base = new RedisDatabase(RedisServerConstants.statistics_tools);
        Set<String> keys = base.keys("*");
        for (String key : keys)
        {
            System.out.println("key  : " + key);
            System.out.println("value: " + dao.get(key, 0, -1));
            System.out.println("-----------------------------");
            //base.del(key);
        }
    }
}
