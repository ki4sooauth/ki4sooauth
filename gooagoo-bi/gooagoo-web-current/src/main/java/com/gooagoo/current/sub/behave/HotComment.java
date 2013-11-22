package com.gooagoo.current.sub.behave;

import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Message(DispatcherConstants.comment)
public class HotComment implements Customer
{

    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 HotComment");
        BehaveLog behaveLog = (BehaveLog) message;
        String goodsId = behaveLog.getObjectValue();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_hot);
        sortedSetDao.edit("hotComment", 1, goodsId);
    }
}
