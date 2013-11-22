package com.gooagoo.current.sub.behave;

import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 热卖
 * @author 王宇
 *
 */
@Message(DispatcherConstants.bill)
public class HotSale implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 HotSale");
        Bill bill = (Bill) message;
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_hot);
        for (OrderDetailInfo orderDetailInfo : bill.getOrderDetailInfos())
        {
            sortedSetDao.edit("hotSale", 1, orderDetailInfo.getGoodsId());
        }
    }
}
