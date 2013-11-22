package com.gooagoo.current.sub.behave;

import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Message(DispatcherConstants.exchange)
public class ExchangeIntegral implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 ExchangeCoupon");
        BehaveLog behaveLog = (BehaveLog) message;
        String id = behaveLog.getObjectValue();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_integral);
        sortedSetDao.edit(id, 1, "score");
    }
}
