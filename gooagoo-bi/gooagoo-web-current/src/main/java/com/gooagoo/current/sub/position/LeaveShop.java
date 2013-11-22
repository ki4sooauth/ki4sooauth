package com.gooagoo.current.sub.position;

import java.util.Set;

import com.gooagoo.bi.entity.position.BehaviorLeaveShop;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 离店
 * @author 王宇
 *
 */
@Message(DispatcherConstants.leave)
public class LeaveShop implements Customer
{
    @Override
    public void message(Object message)
    {
        BehaviorLeaveShop position = (BehaviorLeaveShop) message;
        Set<String> area = userPosition(position.getMacAddress());
        RedisSortedSetDao inShop = new RedisSortedSetDao(RedisServerConstants.statistics_user_position);
        String userId = position.getUserId();
        String mac = position.getMacAddress();

        if (position.isMember() && StringUtils.hasText(userId, position.getShopId(), position.getEntityId()))
        {
            inShop.delElement(position.getShopId() + "_M", "0" + userId);
            inShop.delElement(position.getShopId() + "_A", "0" + userId);
            inShop.delElement(position.getEntityId() + "_M", "0" + userId);
            inShop.delElement(position.getEntityId() + "_A", "0" + userId);
            for (String string : area)
            {
                inShop.delElement(string + "_M", "0" + userId);
                inShop.delElement(string + "_A", "0" + userId);
            }
        }
        else if (StringUtils.hasText(userId, position.getShopId(), position.getEntityId()))
        {
            inShop.delElement(position.getShopId() + "_N", "0" + userId);
            inShop.delElement(position.getShopId() + "_A", "0" + userId);
            inShop.delElement(position.getEntityId() + "_N", "0" + userId);
            inShop.delElement(position.getEntityId() + "_A", "0" + userId);
            for (String string : area)
            {
                inShop.delElement(string + "_N", "0" + userId);
                inShop.delElement(string + "_A", "0" + userId);
            }
        }
        else
        {
            inShop.delElement(position.getShopId() + "_N", "3" + mac);
            inShop.delElement(position.getShopId() + "_A", "3" + mac);
            inShop.delElement(position.getEntityId() + "_N", "3" + mac);
            inShop.delElement(position.getEntityId() + "_A", "3" + mac);
            for (String string : area)
            {
                inShop.delElement(string + "_N", "0" + userId);
                inShop.delElement(string + "_A", "0" + userId);
            }
        }
    }

    private Set<String> userPosition(String mac)
    {
        RedisDatabase database = new RedisDatabase(RedisServerConstants.statistics_user_position);
        RedisSortedSetDao inShop = new RedisSortedSetDao(RedisServerConstants.statistics_user_position);
        Set<String> area = inShop.get(mac, 0, -1);
        database.del(mac);
        return area;
    }

}
