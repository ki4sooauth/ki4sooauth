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

/**
 * 浏览服务工具
 * @author 王宇
 *
 */
@Message(DispatcherConstants.browse)
public class BrowseTools implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 BrowseTools");
        BehaveLog behaveLog = (BehaveLog) message;
        String shopId = behaveLog.getShopId();
        String toolsId = behaveLog.getObjectValue();
        String value = UserTools.account(behaveLog); //用户 有userId,mac和IP三种
        if ("S".equals(behaveLog.getObjectType()) && StringUtils.hasText(shopId, toolsId, value))
        {
            this.put(toolsId, value, "A"); //所有用户
            if (UserTools.isMember(behaveLog.getUserId(), shopId))
            {
                this.put(toolsId, value, "M"); //会员
            }
            else
            {
                this.put(toolsId, value, "N");//非会员
            }
        }
    }

    /**
     * 浏览服务工具
     * @param toolsId 服务工具id
     * @param type 类型 B浏览 U使用
     * @param value
     * @param memberType
     */
    private void put(String toolsId, String value, String memberType)
    {
        TimeTag time = new TimeTag();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_phonetool);
        sortedSetDao.put(toolsId + "_B_" + memberType, time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.year() + time.month() + time.day(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.year() + time.month() + time.day() + time.hour(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.year() + time.month(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.year() + time.week(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.year(), time.timestamp(), value);

        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType);
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.year() + time.month() + time.day());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.year() + time.month() + time.day() + time.hour());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.year() + time.month());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.year() + time.week());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.year());
    }
}