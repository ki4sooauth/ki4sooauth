package com.gooagoo.current.sub.behave;

import com.gooagoo.api.generator.query.sys.AdsManageGeneratorQueryService;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Message(DispatcherConstants.browse)
public class ClickAds implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 ClickAds");
        BehaveLog behaveLog = (BehaveLog) message;
        if ("2".equals(behaveLog.getObjectType()))
        {
            String bidId = behaveLog.getObjectValue();
            AdsManageGeneratorQueryService query = SpringBeanUtils.getBean(AdsManageGeneratorQueryService.class);
            AdsManage adsManage = query.selectByPrimaryKey(bidId);
            if (adsManage != null && StringUtils.hasText(adsManage.getWinnerShooId()))
            {
                String shopId = adsManage.getWinnerShooId();
                RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_ad);
                sortedSetDao.edit(shopId, 1, bidId);
            }
        }
    }
}
