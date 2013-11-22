package com.gooagoo.current.sub.behave;

import com.gooagoo.api.generator.query.marketing.NoticeInfoGeneratorQueryService;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Message(DispatcherConstants.browse)
public class BrowseNotice implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 BrowseNotice");
        try
        {
            BehaveLog behaveLog = (BehaveLog) message;
            String ids = behaveLog.getObjectValue();
            String value = UserTools.account(behaveLog); //用户 有userId,mac和IP三种
            String source = behaveLog.getSource();
            if ("N".equals(behaveLog.getObjectType()) && StringUtils.hasText(value, source))
            {
                NoticeInfoGeneratorQueryService noticeInfoService = SpringBeanUtils.getBean(NoticeInfoGeneratorQueryService.class);
                String[] arrIds = ids.split(",");
                for (String id : arrIds)
                {
                    NoticeInfo noticeInfo = noticeInfoService.selectByPrimaryKey(id);
                    this.put(id, value, "A", source); //所有用户
                    this.put(id, value, "A", "*"); //所有用户
                    if (UserTools.isMember(behaveLog.getUserId(), noticeInfo.getShopId()))
                    {
                        this.put(id, value, "M", source); //会员
                        this.put(id, value, "M", "*"); //所有用户
                    }
                    else
                    {
                        this.put(id, value, "N", source);//非会员
                        this.put(id, value, "N", "*"); //所有用户
                    }
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("", e);
        }
    }

    private void put(String id, String value, String member, String source)
    {
        TimeTag time = new TimeTag();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_notice);
        String baseKey = id + "_B_" + member + "_" + source;

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
