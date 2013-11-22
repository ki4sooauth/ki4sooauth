package com.gooagoo.current.sub.behave;

import java.util.Map;

import com.gooagoo.api.business.query.marketing.cache.CouponCacheQueryService;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.Marketing;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Message(DispatcherConstants.browse)
public class BrowseCoupon implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 BrowseCoupon");
        try
        {
            Marketing marketing = new Marketing();
            BehaveLog behaveLog = (BehaveLog) message;

            String id = behaveLog.getObjectValue();
            String value = UserTools.account(behaveLog); //用户 有userId,mac和IP三种
            String source = behaveLog.getSource();
            String channel = marketing.getChannel(behaveLog.getObjectSource()); //来源
            if ("C".equals(behaveLog.getObjectType()) && StringUtils.hasText(id, value, source))
            {
                CouponCacheQueryService couponService = SpringBeanUtils.getBean(CouponCacheQueryService.class);
                Map<String, String> coupon = couponService.findCoupon(id);
                String shopId = coupon.get("shopId");

                this.put(id, value, "A", channel, source); //所有用户
                this.put(id, value, "A", channel, "*"); //所有用户
                this.put(id, value, "A", channel + behaveLog.getObjectSource(), source); //所有用户
                this.put(id, value, "A", channel + behaveLog.getObjectSource(), "*"); //所有用户
                this.put(id, value, "A", "*", source); //所有用户
                this.put(id, value, "A", "*", "*"); //所有用户
                if (UserTools.isMember(behaveLog.getUserId(), shopId))
                {
                    this.put(id, value, "M", channel, source); //会员
                    this.put(id, value, "M", channel, "*"); //会员
                    this.put(id, value, "M", channel + behaveLog.getObjectSource(), source); //会员
                    this.put(id, value, "M", channel + behaveLog.getObjectSource(), "*"); //会员
                    this.put(id, value, "M", "*", source); //会员
                    this.put(id, value, "M", "*", "*"); //会员
                }
                else
                {
                    this.put(id, value, "N", channel, source);//非会员
                    this.put(id, value, "N", channel, "*");//非会员
                    this.put(id, value, "N", channel + behaveLog.getObjectSource(), source);//非会员
                    this.put(id, value, "N", channel + behaveLog.getObjectSource(), "*");//非会员
                    this.put(id, value, "N", "*", source);//非会员
                    this.put(id, value, "N", "*", "*");//非会员
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("", e);
        }
    }

    private void put(String id, String value, String member, String channel, String source)
    {
        if (StringUtils.hasText(id, value, member, channel, source))
        {
            TimeTag time = new TimeTag();
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);
            String baseKey = id + "_B_" + member + "_" + channel + "_" + source;

            sortedSetDao.put(baseKey, time.timestamp(), value);
            sortedSetDao.put(baseKey + time.year() + time.month() + time.day(), time.timestamp(), value);
            sortedSetDao.put(baseKey + time.year() + time.month() + time.day() + time.hour(), time.timestamp(), value);
            sortedSetDao.put(baseKey + time.year() + time.week(), time.timestamp(), value);
            sortedSetDao.put(baseKey + time.year() + time.month(), time.timestamp(), value);
            sortedSetDao.put(baseKey + time.year(), time.timestamp(), value);

            sortedSetDao.edit("Interaction", 1L, baseKey);
            sortedSetDao.edit("Interaction", 1L, baseKey + time.year() + time.month() + time.day());
            sortedSetDao.edit("Interaction", 1L, baseKey + time.year() + time.month() + time.day() + time.hour());
            sortedSetDao.edit("Interaction", 1L, baseKey + time.year() + time.week());
            sortedSetDao.edit("Interaction", 1L, baseKey + time.year() + time.month());
            sortedSetDao.edit("Interaction", 1L, baseKey + time.year());
        }
    }
}
