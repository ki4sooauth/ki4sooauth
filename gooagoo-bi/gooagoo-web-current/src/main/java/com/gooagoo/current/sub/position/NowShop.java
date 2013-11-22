package com.gooagoo.current.sub.position;

import com.gooagoo.bi.entity.position.BehaviorGeneral;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 当前在店
 * @author 王宇
 *
 */
@Message(DispatcherConstants.store)
public class NowShop implements Customer
{
    @Override
    public void message(Object message)
    {
        RedisSortedSetDao inShop = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);

        BehaviorGeneral position = (BehaviorGeneral) message;
        String mac = position.getMacAddress(); //mac地址
        String userId = position.getUserId();
        if (position.isMember() && StringUtils.hasText(position.getUserId(), position.getShopId(), position.getEntityId()))
        {
            inShop.put(position.getShopId() + "_M", System.currentTimeMillis(), "0_" + userId);
            inShop.put(position.getEntityId() + "_M", System.currentTimeMillis(), "0_" + userId);
            inShop.put(position.getShopId() + "_A", System.currentTimeMillis(), "0_" + userId);
            inShop.put(position.getEntityId() + "_A", System.currentTimeMillis(), "0_" + userId);
        }
        else if (StringUtils.hasText(position.getUserId(), position.getShopId(), position.getEntityId()))
        {
            inShop.put(position.getShopId() + "_N", System.currentTimeMillis(), "0_" + userId);
            inShop.put(position.getEntityId() + "_N", System.currentTimeMillis(), "0_" + userId);
            inShop.put(position.getShopId() + "_A", System.currentTimeMillis(), "0_" + userId);
            inShop.put(position.getEntityId() + "_A", System.currentTimeMillis(), "0_" + userId);
        }
        else if (StringUtils.hasText(mac, position.getShopId(), position.getEntityId()))
        {
            inShop.put(position.getShopId() + "_A", System.currentTimeMillis(), "3_" + mac);
            inShop.put(position.getEntityId() + "_A", System.currentTimeMillis(), "3_" + mac);
        }
    }
}
