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

public class FavoriteActiveTest
{
    SendMessageUtil sendMessageUtil = new SendMessageUtil();
    FavoriteActive active = new FavoriteActive();

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
        behaveLog.setObjectValue("183JO6FN69TLH32G8PELDKNPHI5CSCUF"); //这个就随便生成了一个
        behaveLog.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behaveLog.setSource("W");
        behaveLog.setObjectSource("018237FSEHNVTOI005B2D4J4VOR9U6KK");
        behaveLog.setRemoteCode("gusm02");
        message.setContent(behaveLog);//消息内容
        this.active.message(behaveLog);
    }

    @After
    public void after()
    {
        //this.sendMessageUtil.close();
    }

    @Test
    public void watch()
    {
        RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_activity);

        RedisDatabase base = new RedisDatabase(RedisServerConstants.statistics_activity);
        Set<String> keys = base.keys("*_F_*");
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
        Set<String> keys = base.keys("*_F_*");
        for (String key : keys)
        {
            base.del(key);
        }
    }
}
