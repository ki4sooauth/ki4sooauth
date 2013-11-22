package com.gooagoo.current.sub.position;

import com.gooagoo.bi.entity.position.BehaviorGeneral;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 到店人数
 * @author 王宇
 *
 */
@Message(DispatcherConstants.store)
public class ShopNumber implements Customer
{
    @Override
    public void message(Object message)
    {
        BehaviorGeneral position = (BehaviorGeneral) message;
        String mac = position.getMacAddress(); //mac地址
        String userId = position.getUserId();
        if (position.isMember() && StringUtils.hasText(position.getShopId(), position.getEntityId(), userId))
        {
            newShop(position.getShopId(), position.getEntityId(), "_M", "0_" + userId);
            newShop(position.getShopId(), position.getEntityId(), "_A", "0_" + userId);
        }
        else if (StringUtils.hasText(position.getShopId(), position.getEntityId(), userId))
        {
            newShop(position.getShopId(), position.getEntityId(), "_N", "0_" + userId);
            newShop(position.getShopId(), position.getEntityId(), "_A", "0_" + userId);
        }
        else if (StringUtils.hasText(position.getShopId(), position.getEntityId(), mac))
        {
            newShop(position.getShopId(), position.getEntityId(), "_A", "3_" + mac);
        }
    }

    private void newShop(String shopId, String entityId, String member, String account)
    {
        TimeTag tag = new TimeTag();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_arrive);
        sortedSetDao.put(shopId + member, tag.timestamp(), account);
        sortedSetDao.put(shopId + member + tag.day() + tag.hour(), tag.timestamp(), account);
        sortedSetDao.put(shopId + member + tag.day(), tag.timestamp(), account);
        sortedSetDao.put(shopId + member + tag.month(), tag.timestamp(), account);
        sortedSetDao.put(shopId + member + tag.year(), tag.timestamp(), account);

        sortedSetDao.put(entityId + member, tag.timestamp(), account);
        sortedSetDao.put(entityId + member + tag.day() + tag.hour(), tag.timestamp(), account);
        sortedSetDao.put(entityId + member + tag.day(), tag.timestamp(), account);
        sortedSetDao.put(entityId + member + tag.month(), tag.timestamp(), account);
        sortedSetDao.put(entityId + member + tag.year(), tag.timestamp(), account);
    }
}
