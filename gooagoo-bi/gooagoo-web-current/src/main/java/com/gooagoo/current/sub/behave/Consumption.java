package com.gooagoo.current.sub.behave;

import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 消费人群，消费金额，消费次数统计
 * @author Administrator
 *
 */
@Message(DispatcherConstants.bill)
public class Consumption implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 Consumption");
        Bill bill = (Bill) message;
        String shopId = bill.getOrderInfo().getShopId();
        String store = bill.getOrderInfo().getShopEntityId();
        String billId = bill.getOrderInfo().getOrderId();
        String userId = bill.getOrderInfo().getUserId();
        if (StringUtils.hasText(shopId, billId, store, userId))
        {
            String account = "0_" + userId;
            OrderInfo orderInfo = bill.getOrderInfo();
            this.put(shopId, store, orderInfo.getPayPrice(), account, "A"); //所有用户
            if (UserTools.isMember(userId, shopId))
            {
                this.put(shopId, store, orderInfo.getPayPrice(), account, "M"); //会员
            }
            else
            {
                this.put(shopId, store, orderInfo.getPayPrice(), account, "N");//非会员
            }
        }
    }

    private void put(String shopId, String store, double money, String value, String member)
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_consumption);
        TimeTag time = new TimeTag();

        for (String shop : new String[] { shopId + "_", store + "_" })
        {
            sortedSetDao.put(shop + member, time.timestamp(), value);
            sortedSetDao.put(shop + member + time.year() + time.month() + time.day(), time.timestamp(), value);
            sortedSetDao.put(shop + member + time.year() + time.month() + time.day() + time.hour(), time.timestamp(), value);
            sortedSetDao.put(shop + member + time.year() + time.week(), time.timestamp(), value);
            sortedSetDao.put(shop + member + time.year() + time.month(), time.timestamp(), value);
            sortedSetDao.put(shop + member + time.year(), time.timestamp(), value);

            sortedSetDao.edit("money", money, shop + member);
            sortedSetDao.edit("money", money, shop + member + time.year() + time.month() + time.day());
            sortedSetDao.edit("money", money, shop + member + time.year() + time.month() + time.day() + time.hour());
            sortedSetDao.edit("money", money, shop + member + time.year() + time.week());
            sortedSetDao.edit("money", money, shop + member + time.year() + time.month());
            sortedSetDao.edit("money", money, shop + member + time.year());

            sortedSetDao.edit("count", 1, shop + member);
            sortedSetDao.edit("count", 1, shop + member + time.year() + time.month() + time.day());
            sortedSetDao.edit("count", 1, shop + member + time.year() + time.month() + time.day() + time.hour());
            sortedSetDao.edit("count", 1, shop + member + time.year() + time.week());
            sortedSetDao.edit("count", 1, shop + member + time.year() + time.month());
            sortedSetDao.edit("count", 1, shop + member + time.year());
        }

    }
}
