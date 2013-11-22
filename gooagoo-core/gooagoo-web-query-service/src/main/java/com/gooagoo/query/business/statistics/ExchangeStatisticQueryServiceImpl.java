package com.gooagoo.query.business.statistics;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.ExchangeStatisticQueryService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.query.business.statistics.common.CouponCommonOperate;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Service
public class ExchangeStatisticQueryServiceImpl implements ExchangeStatisticQueryService
{

    @Override
    public int marketingTimes(String marketingId)
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_integral);
        Double score = sortedSetDao.getScore(marketingId, "score");
        return score.intValue();
    }

    @Override
    public int couponExchangeTimes(String couponId, String userType, String dateType, Date dateTime)
    {
        return CouponCommonOperate.getTimes(couponId, "E", userType, dateType, dateTime, null, null);
    }

    @Override
    public List<String> couponExchangePeople(String couponId, String userType, String dateType, Date dateTime)
    {
        return CouponCommonOperate.getPeople(couponId, "E", userType, dateType, dateTime, null, null);
    }

    @Override
    public int goodsExchangeTimes(String goodsId, String userType, String dateType, Date dateTime)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<String> goodsExchangePeople(String goodsId, String userType, String dateType, Date dateTime)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
