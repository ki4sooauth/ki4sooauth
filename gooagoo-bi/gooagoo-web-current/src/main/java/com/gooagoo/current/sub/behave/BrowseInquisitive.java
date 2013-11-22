package com.gooagoo.current.sub.behave;

import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Message(DispatcherConstants.browse)
public class BrowseInquisitive implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 BrowseInquisitive");
        BehaveLog behaveLog = (BehaveLog) message;
        String id = behaveLog.getObjectValue();
        String value = UserTools.account(behaveLog); //用户 有userId,mac和IP三种
        String source = behaveLog.getSource(); //来源 W M
        if (StringUtils.hasText(id, source, value))
        {
            this.put(id, source, value, "A"); //所有用户
            if ("Q".equals(behaveLog.getObjectType()) && UserTools.isMember(behaveLog.getUserId(), behaveLog.getShopId()))
            {
                this.put(id, source, value, "M"); //会员
            }
            else
            {
                this.put(id, source, value, "N");//非会员
            }
        }
    }

    private void put(String id, String source, String value, String memberType)
    {
        TimeTag time = new TimeTag();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_inquisitive);
        sortedSetDao.put(id + "_" + memberType + time.year() + time.month() + time.day(), time.timestamp(), value);
        sortedSetDao.put(id + "_" + memberType + time.year() + time.month() + time.day() + time.hour(), time.timestamp(), value);
        sortedSetDao.put(id + "_" + memberType + time.year() + time.month(), time.timestamp(), value);
        sortedSetDao.put(id + "_" + memberType + time.year() + time.week(), time.timestamp(), value);
        sortedSetDao.put(id + "_" + memberType + time.year(), time.timestamp(), value);
        sortedSetDao.put(id + "_" + memberType, time.timestamp(), value);

        sortedSetDao.edit("Interaction", 1L, id + "_" + memberType + time.year() + time.month() + time.day());
        sortedSetDao.edit("Interaction", 1L, id + "_" + memberType + time.year() + time.month() + time.day() + time.hour());
        sortedSetDao.edit("Interaction", 1L, id + "_" + memberType + time.year() + time.month());
        sortedSetDao.edit("Interaction", 1L, id + "_" + memberType + time.year() + time.week());
        sortedSetDao.edit("Interaction", 1L, id + "_" + memberType + time.year());
        sortedSetDao.edit("Interaction", 1L, id + "_" + memberType);
    }
}
