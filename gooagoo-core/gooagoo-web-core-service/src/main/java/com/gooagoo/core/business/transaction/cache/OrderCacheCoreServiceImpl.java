package com.gooagoo.core.business.transaction.cache;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.transaction.cache.OrderCacheCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisListDao;

@Service
public class OrderCacheCoreServiceImpl implements OrderCacheCoreService
{

    @Override
    public boolean addOrder(String shopEntityId, String dataDetail)
    {
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_billdetail);
        redisListDao.put(shopEntityId, dataDetail);
        return true;
    }

}
