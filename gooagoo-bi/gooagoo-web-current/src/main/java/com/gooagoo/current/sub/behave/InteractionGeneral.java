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
 * 用户 发生过关系 的商家
 * @author 王宇
 *
 */
@Message(DispatcherConstants.other)
public class InteractionGeneral implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 InteractionCryout");
        BehaveLog behaveLog = (BehaveLog) message;
        String value = UserTools.account(behaveLog); //用户 有userId,mac和IP三种
        String userId = StringUtils.filterNull(behaveLog.getUserId());
        String shopId = behaveLog.getShopId();
        String source = behaveLog.getSource();
        if (StringUtils.hasText(shopId, source, value))
        {
            put(shopId, source, value, "A");
            put(shopId, "*", value, "A");
            if (UserTools.isMember(userId, shopId))
            {
                put(shopId, source, value, "M");
                put(shopId, "*", value, "M");
            }
            else
            {
                put(shopId, source, value, "N");
                put(shopId, "*", value, "N");
            }
        }
    }

    public static void put(String shopId, String source, String value, String memberType)
    {
        /*********互动人群*********/
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_interaction);
        TimeTag time = new TimeTag();
        sortedSetDao.put(shopId + "_" + source + "_" + memberType + time.year() + time.month() + time.day(), time.timestamp(), value);
        sortedSetDao.put(shopId + "_" + source + "_" + memberType + time.year() + time.month() + time.day() + time.hour(), time.timestamp(), value);
        sortedSetDao.put(shopId + "_" + source + "_" + memberType + time.year() + time.month(), time.timestamp(), value);
        sortedSetDao.put(shopId + "_" + source + "_" + memberType + time.year() + time.week(), time.timestamp(), value);
        sortedSetDao.put(shopId + "_" + source + "_" + memberType + time.year(), time.timestamp(), value);
        sortedSetDao.put(shopId + "_" + source + "_" + memberType, time.timestamp(), value);

        sortedSetDao.edit("Interaction", 1L, shopId + "_" + source + "_" + memberType + time.year() + time.month() + time.day());
        sortedSetDao.edit("Interaction", 1L, shopId + "_" + source + "_" + memberType + time.year() + time.month() + time.day() + time.hour());
        sortedSetDao.edit("Interaction", 1L, shopId + "_" + source + "_" + memberType + time.year() + time.month());
        sortedSetDao.edit("Interaction", 1L, shopId + "_" + source + "_" + memberType + time.year() + time.week());
        sortedSetDao.edit("Interaction", 1L, shopId + "_" + source + "_" + memberType + time.year());
        sortedSetDao.edit("Interaction", 1L, shopId + "_" + source + "_" + memberType);

        /*********查询商家用户人群*********/
        if (!"M".equals(memberType))
        {
            RedisSortedSetDao member = new RedisSortedSetDao(RedisServerConstants.statistics_member);

            if (member.getScore(shopId + "_" + memberType, value).equals(0))
            {
                member.put(shopId + "_" + memberType, time.timestamp(), value);
            }
        }
    }
}
