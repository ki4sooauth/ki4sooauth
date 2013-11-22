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

public class BrowseCryoutTest
{
    SendMessageUtil sendMessageUtil = new SendMessageUtil();
    BrowseCryout browseCryout = new BrowseCryout();

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void test()
    {
        GooagooMessage<BehaveLog> message = new GooagooMessage<BehaveLog>();

        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setShopId("185EVK63KPRTKH00A1BAQJMCA2H349CC");
        behaveLog.setObjectValue("187UII6HVP926R00A1BAQJMESFHS6DST"); //这个就随便生成了一个
        behaveLog.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behaveLog.setSource("W");
        behaveLog.setObjectType("Y");
        behaveLog.setOperateResult("Y");
        //behaveLog.setObjectSource("0182UOJNLFC4UVH0N5GGV0EIISWR219J");
        behaveLog.setRemoteCode("test5");

        message.setContent(behaveLog);//消息内容
        this.browseCryout.message(behaveLog);
    }

    @After
    public void after()
    {
        //this.sendMessageUtil.close();
    }

    @Test
    public void watch()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_cryout);

        RedisDatabase base = new RedisDatabase(RedisServerConstants.statistics_cryout);
        Set<String> keys = base.keys("*");
        for (String key : keys)
        {
            base.del(key);
            System.out.println("key  : " + key);
            System.out.println("value: " + dao.get(key, 0, -1));
            System.out.println("-----------------------------");
        }
    }
}
