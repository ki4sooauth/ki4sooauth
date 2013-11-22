package com.gooagoo.query.business.statistics;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.AdClickRateQueryService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class AdClickRateQueryServiceImpl implements AdClickRateQueryService
{
    @Override
    public Integer clickRate(String shopId, String bidId)
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_ad);
        return sortedSetDao.getScore(shopId, bidId).intValue();
    }
}
