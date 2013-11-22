package com.gooagoo.current.sub.position;

import java.util.Set;

import com.gooagoo.bi.entity.position.BehaviorAreaChange;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisListDao;

/**
 * 到区域人次
 * @author 王宇
 *
 */
@Message(DispatcherConstants.area)
public class AreaTime implements Customer
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
        RedisListDao list = new RedisListDao(RedisServerConstants.statistics_arriveNum);
        for (String area : newArea)
        {
            list.put(area + member, account);
            list.put(area + member + tag.day() + tag.hour(), account);
            list.put(area + member + tag.day(), account);
            list.put(area + member + tag.month(), account);
            list.put(area + member + tag.year(), account);
        }
    }
}
