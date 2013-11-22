package com.googoo.batch.dispatcher.everyMinutes;

import java.util.Set;

import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.googoo.batch.constants.BatchTimeCnstants;

/**
 * 将当年在店用户加入实时统计
 * @author 王宇
 *
 */
@Engine(BatchTimeCnstants.everyTenMinutes)
public class NowInShop implements Tyre
{
    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 NowInShop");
        TimeTag tag = new TimeTag();
        RedisDatabase inShopDatabase = new RedisDatabase(RedisServerConstants.statistics_in_shop);
        RedisSortedSetDao arrive = new RedisSortedSetDao(RedisServerConstants.statistics_arrive);
        RedisSortedSetDao inShopsSortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        Set<String> all = inShopDatabase.keys("*"); //目前定位的所有用户
        for (String key : all)
        {
            Set<String> user = inShopsSortedSetDao.get(key, 0, -1);
            if (user != null)
            {
                for (String element : user)
                {
                    arrive.put(key + tag.day() + tag.hour(), inShopsSortedSetDao.getScore(key, element).doubleValue(), element);
                }
            }
        }

    }
}
