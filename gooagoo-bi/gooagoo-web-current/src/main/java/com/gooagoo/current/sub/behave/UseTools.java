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
 * 使用服务工具
 * @author 王宇
 *
 */
@Message(DispatcherConstants.server)
public class UseTools implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 UseTools");
        BehaveLog behaveLog = (BehaveLog) message;
        String shopId = behaveLog.getShopId();
        String toolsId = behaveLog.getObjectValue();
        String value = this.checkUser(behaveLog); //用户 有userId,mac和IP三种
        if (StringUtils.hasText(shopId, toolsId, value))
        {
            this.put(shopId, toolsId, value, "A"); //所有用户
            if (UserTools.isMember(behaveLog.getUserId(), shopId))
            {
                this.put(shopId, toolsId, value, "M"); //会员
            }
            else
            {
                this.put(shopId, toolsId, value, "N");//非会员
            }
        }
    }

    /**
     * 使用服务工具
     * @param toolsId 服务工具id
     * @param type 类型 B浏览 U使用
     * @param value
     * @param memberType
     */
    private void put(String shopId, String toolsId, String value, String memberType)
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_tools);
        TimeTag time = new TimeTag();

        sortedSetDao.put(shopId + "_" + toolsId + "_U_" + memberType + time.year() + time.month() + time.day() + time.hour(), time.timestamp(), value);
        sortedSetDao.put(shopId + "_" + toolsId + "_U_" + memberType + time.year() + time.month() + time.day(), time.timestamp(), value);
        sortedSetDao.put(shopId + "_" + toolsId + "_U_" + memberType + time.year() + time.month(), time.timestamp(), value);
        sortedSetDao.put(shopId + "_" + toolsId + "_U_" + memberType + time.year() + time.week(), time.timestamp(), value);
        sortedSetDao.put(shopId + "_" + toolsId + "_U_" + memberType + time.year(), time.timestamp(), value);
        sortedSetDao.put(shopId + "_" + toolsId + "_U_" + memberType, time.timestamp(), value);

        sortedSetDao.edit("Interaction", 1L, shopId + "_" + toolsId + "_U_" + memberType + time.year() + time.month() + time.day());
        sortedSetDao.edit("Interaction", 1L, shopId + "_" + toolsId + "_U_" + memberType + time.year() + time.month() + time.day() + time.hour());
        sortedSetDao.edit("Interaction", 1L, shopId + "_" + toolsId + "_U_" + memberType + time.year() + time.month());
        sortedSetDao.edit("Interaction", 1L, shopId + "_" + toolsId + "_U_" + memberType + time.year() + time.week());
        sortedSetDao.edit("Interaction", 1L, shopId + "_" + toolsId + "_U_" + memberType + time.year());
        sortedSetDao.edit("Interaction", 1L, shopId + "_" + toolsId + "_U_" + memberType);
    }

    private String checkUser(BehaveLog behaveLog)
    {
        if (StringUtils.hasText(behaveLog.getUserId()))
        {
            return "0_" + behaveLog.getUserId();
        }
        else if (StringUtils.hasText(behaveLog.getIpAddress()))
        {
            return "2_" + behaveLog.getIpAddress();
        }
        else
        {
            return null;
        }
    }
}
