package com.gooagoo.current.sub.tidy;

import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Message(DispatcherConstants.attention)
public class AnalysisAttention implements Customer
{
    @Override
    public void message(Object message)
    {
        BehaveLog behaveLog = (BehaveLog) message;
        String userId = behaveLog.getUserId();
        String shopId = behaveLog.getShopId();
        String source = behaveLog.getSource();
        if (StringUtils.hasText(userId, shopId, source))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_attention);
            sortedSetDao.put(shopId + "_" + source, System.currentTimeMillis(), userId);
            sortedSetDao.put(shopId, System.currentTimeMillis(), userId);
        }
    }
}
