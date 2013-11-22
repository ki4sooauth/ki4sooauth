package com.gooagoo.current.sub.behave;

import java.util.Date;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;

public class BrowseActiveTest
{
    BrowseActive browseActive = new BrowseActive();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        GooagooMessage<BehaveLog> message = new GooagooMessage<BehaveLog>();
        //message.setSource(3);//消息来源
        //message.setBehaveCode("gusm02");//调用的接口编码（位置引擎中表示定位（001）与行为（002）的识别标志）
        //message.setBehaveType("9");//行为类型（特指用户行为类型，商家及管理员暂无）
        //message.setFlag(true);//操作结果，true-成功，false-失败

        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setShopId("01822IAKR5SKU02085QBP2EIISWR0JGT");
        behaveLog.setObjectValue("0182AIEG0LNI34H0NCQU1KEIISWR2HCH"); //活动ID
        behaveLog.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behaveLog.setSource("W");
        behaveLog.setObjectSource("018237FSEHNVTOI005B2D4J4VOR9U6KK");//判断渠道
        behaveLog.setObjectType("A");
        behaveLog.setRemoteCode("gusm02");
        message.setContent(behaveLog);//消息内容
        this.browseActive.message(behaveLog);
    }

    @Test
    public void addOldData() throws Exception
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_activity);

        String id = "01822R97QK2FRDT085QBV2EIISWR0JGT";
        String member = "A"; //用户类型
        String value = "01822N0IJLPA8N700C5V4PBJ43P1R5JO";//用户ID
        String channel = "3";
        String source = "W";
        Date date = TimeUtils.convertStringToDate("2013-09-08");
        TimeTag time = new TimeTag(date);

        sortedSetDao.put(id + "_B_" + member, time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel, time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source, time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source + time.day(), time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source + time.day() + time.hour(), time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source + time.week(), time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source + time.month(), time.timestamp(), value);
        sortedSetDao.put(id + "_B_" + member + "_" + channel + "_" + source + time.year(), time.timestamp(), value);

    }

    @Test
    public void watch()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_activity);

        RedisDatabase base = new RedisDatabase(RedisServerConstants.statistics_activity);
        Set<String> keys = base.keys("*_B_*");
        for (String key : keys)
        {
            System.out.println("key  : " + key);
            System.out.println("value: " + dao.get(key, 0, -1));
            System.out.println("-----------------------------");
        }

    }

    @Test
    public void del()
    {
        RedisDatabase base = new RedisDatabase(RedisServerConstants.statistics_activity);
        Set<String> keys = base.keys("*");
        for (String key : keys)
        {
            base.del(key);
        }
    }
}
