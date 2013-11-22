package com.gooagoo.current.sub.position;

import java.util.List;
import java.util.Set;

import com.gooagoo.bi.entity.position.BehaviorAreaChange;
import com.gooagoo.bi.entity.position.Leave;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 当前区域内用户
 * @author 王宇
 *
 */
@Message(DispatcherConstants.area)
public class NowArea implements Customer
{
    @Override
    public void message(Object message)
    {
        BehaviorAreaChange position = (BehaviorAreaChange) message;
        String mac = position.getMacAddress(); //mac地址
        String userId = position.getUserId();
        if (position.getNewArea() != null && position.getNewArea().size() != 0)
        {
            newArea(mac, userId, position.isMember(), position.getNewArea());
        }
        oldArea(mac, userId, position.isMember(), position.getOldArea());
    }

    public void oldArea(String mac, String userId, boolean isMember, List<Leave> old)
    {
        RedisSortedSetDao inShop = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        for (Leave shopArea : old)
        {
            if (isMember)
            {
                inShop.delElement(shopArea.getId() + "_M", "0_" + userId);
                inShop.delElement(shopArea.getId() + "_A", "0_" + userId);
            }
            else if (StringUtils.hasText(userId))
            {
                inShop.delElement(shopArea.getId() + "_N", "0_" + userId);
                inShop.delElement(shopArea.getId() + "_A", "0_" + userId);
            }
            else
            {
                inShop.delElement(shopArea.getId() + "_A", "3_" + mac);
            }
        }
    }

    public void newArea(String mac, String userId, boolean isMember, Set<String> newArea)
    {
        long time = System.currentTimeMillis();
        RedisSortedSetDao inShop = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        for (String string : newArea)
        {
            if (isMember)
            {
                inShop.put(string + "_M", time, "0_" + userId);
                inShop.put(string + "_A", time, "0_" + userId);
            }
            else if (StringUtils.hasText(userId))
            {
                inShop.put(string + "_N", time, "0_" + userId);
                inShop.put(string + "_A", time, "0_" + userId);
            }
            else
            {
                inShop.put(string + "_A", time, "3_" + mac);
            }
        }
    }
}
