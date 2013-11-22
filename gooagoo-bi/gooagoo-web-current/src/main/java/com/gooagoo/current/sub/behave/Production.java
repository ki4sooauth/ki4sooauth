package com.gooagoo.current.sub.behave;

import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 统计会员消费次数
 * @author 王宇
 *
 */
@Message(DispatcherConstants.bill)
public class Production implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 Production");
        Bill bill = (Bill) message;
        String shopId = bill.getOrderInfo().getShopId();
        String userId = bill.getOrderInfo().getUserId();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_production);
        TimeTag timeTag = new TimeTag();
        sortedSetDao.edit(shopId, 1, userId);
        sortedSetDao.edit(shopId + timeTag.day(), 1, userId);
    }
}
