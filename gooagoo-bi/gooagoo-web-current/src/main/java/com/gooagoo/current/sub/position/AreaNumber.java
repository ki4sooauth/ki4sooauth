package com.gooagoo.current.sub.position;

import java.util.Set;

import com.gooagoo.bi.entity.position.BehaviorAreaChange;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 到区域内人数
 * @author 王宇
 *
 */
@Message(DispatcherConstants.area)
public class AreaNumber implements Customer
{
    @Override
    public void message(Object message)
    {
        BehaviorAreaChange position = (BehaviorAreaChange) message;
        String mac = position.getMacAddress(); //mac地址
        String userId = position.getUserId();
        if (position.isMember() && StringUtils.hasText(userId))
        {
            newArea("_M", position.getNewArea(), "0_" + userId);
        }
        else if (StringUtils.hasText(userId))
        {
            newArea("_N", position.getNewArea(), "0_" + userId);
        }
        else if (StringUtils.hasText(mac))
        {
            newArea("_A", position.getNewArea(), "3_" + mac);
        }
    }

    private void newArea(String member, Set<String> newArea, String account)
    {
        TimeTag tag = new TimeTag();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_arrive);
        for (String area : newArea)
        {
            sortedSetDao.put(area + member, tag.timestamp(), account);
            sortedSetDao.put(area + member + tag.day() + tag.hour(), tag.timestamp(), account);
            sortedSetDao.put(area + member + tag.day(), tag.timestamp(), account);
            sortedSetDao.put(area + member + tag.month(), tag.timestamp(), account);
            sortedSetDao.put(area + member + tag.year(), tag.timestamp(), account);
        }
    }
}
