package com.gooagoo.current.sub.position;

import com.gooagoo.bi.entity.position.BehaviorGeneral;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisListDao;

/**
 * 到店人次
 * @author 王宇
 *
 */
@Message(DispatcherConstants.store)
public class ShopTime implements Customer
{
    @Override
    public void message(Object message)
    {
        BehaviorGeneral position = (BehaviorGeneral) message;
        String mac = position.getMacAddress(); //mac地址
        String userId = position.getUserId();
        if (position.isMember())
        {
            put(position.getShopId(), position.getEntityId(), "_N", "0_" + userId);
            put(position.getShopId(), position.getEntityId(), "_A", "0_" + userId);
        }
        else if (StringUtils.hasText(position.getUserId()))
        {
            put(position.getShopId(), position.getEntityId(), "_M", "0_" + userId);
            put(position.getShopId(), position.getEntityId(), "_A", "0_" + userId);
        }
        else
        {
            put(position.getShopId(), position.getEntityId(), "_A", "3_" + mac);
        }
    }

    private void put(String shopId, String entityId, String member, String account)
    {
        TimeTag tag = new TimeTag();
        RedisListDao list = new RedisListDao(RedisServerConstants.statistics_arriveNum);
        list.put(shopId + member, account);
        list.put(shopId + member + tag.day() + tag.hour(), account);
        list.put(shopId + member + tag.day(), account);
        list.put(shopId + member + tag.month(), account);
        list.put(shopId + member + tag.year(), account);

        list.put(entityId + member, account);
        list.put(entityId + member + tag.day() + tag.hour(), account);
        list.put(entityId + member + tag.day(), account);
        list.put(entityId + member + tag.month(), account);
        list.put(entityId + member + tag.year(), account);
    }
}
