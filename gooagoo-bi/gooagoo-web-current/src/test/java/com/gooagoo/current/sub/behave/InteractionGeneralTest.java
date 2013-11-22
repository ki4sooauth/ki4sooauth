package com.gooagoo.current.sub.behave;

import java.util.Set;

import org.junit.Test;

import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisDatabase;

public class InteractionGeneralTest
{

    @Test
    public void test()
    {

    }

    @Test
    public void del()
    {
        RedisDatabase base = new RedisDatabase(RedisServerConstants.statistics_interaction);
        Set<String> keys = base.keys("*");
        for (String key : keys)
        {
            base.del(key);
        }

    }

    @Test
    public void delMember()
    {
        RedisDatabase member = new RedisDatabase(RedisServerConstants.statistics_member);
        Set<String> keys = member.keys("*");
        for (String key : keys)
        {
            member.del(key);
        }
    }
}
