package com.gooagoo.position.task;

import java.util.Set;
import java.util.TimerTask;

import com.gooagoo.position.constants.BehaviorConstants;
import com.gooagoo.position.constants.RedisConstants;
import com.gooagoo.redis.data.RedisDatabase;

public class CleanCacheTask extends TimerTask
{
    @Override
    public void run()
    {
        RedisDatabase redisDB = new RedisDatabase(RedisConstants.business_behavior_anls);
        String pattern = BehaviorConstants.CACHE_PREFIX_BEHAVIOR + "*";
        Set<String> keys = redisDB.keys(pattern);
        for (String key : keys)
        {
            redisDB.del(key);
        }

        pattern = BehaviorConstants.CACHE_PREFIX_POSITION_LIST + "*";
        keys = redisDB.keys(pattern);
        for (String key : keys)
        {
            redisDB.del(key);
        }
    }
}
