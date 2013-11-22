package com.gooagoo.current.sub.behave;

import java.util.List;

import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 优惠凭证人群、人次信息统计
 * @author Administrator
 *
 */
@Message(DispatcherConstants.bill)
public class UseCoupon implements Customer
{

    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 UseCoupon");
        Bill bill = (Bill) message;
        String shopId = bill.getOrderInfo().getShopId();
        String userId = bill.getOrderInfo().getUserId();
        List<String> coupons = bill.getCoupons();

        if (StringUtils.hasText(shopId, userId) && coupons != null && coupons.size() != 0)
        {
            String value = "0_" + userId;
            this.put(coupons, value, "A"); //所有用户
            if (UserTools.isMember(userId, shopId))
            {
                this.put(coupons, value, "M"); //会员
            }
            else
            {
                this.put(coupons, value, "N");//非会员
            }
        }
    }

    private void put(List<String> coupons, String value, String member)
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);
        TimeTag time = new TimeTag();
        for (String id : coupons)
        {
            sortedSetDao.put(id + "_U_" + member, time.timestamp(), value);
            sortedSetDao.put(id + "_U_" + member + time.year() + time.month() + time.day(), time.timestamp(), value);
            sortedSetDao.put(id + "_U_" + member + time.year() + time.month() + time.day() + time.hour(), time.timestamp(), value);
            sortedSetDao.put(id + "_U_" + member + time.year() + time.week(), time.timestamp(), value);
            sortedSetDao.put(id + "_U_" + member + time.year() + time.month(), time.timestamp(), value);
            sortedSetDao.put(id + "_U_" + member + time.year(), time.timestamp(), value);

            sortedSetDao.edit("Interaction", 1L, id + "_U_" + member);
            sortedSetDao.edit("Interaction", 1L, id + "_U_" + member + time.year() + time.month() + time.day());
            sortedSetDao.edit("Interaction", 1L, id + "_U_" + member + time.year() + time.month() + time.day() + time.hour());
            sortedSetDao.edit("Interaction", 1L, id + "_U_" + member + time.year() + time.week());
            sortedSetDao.edit("Interaction", 1L, id + "_U_" + member + time.year() + time.month());
            sortedSetDao.edit("Interaction", 1L, id + "_U_" + member + time.year());
        }
    }
}
