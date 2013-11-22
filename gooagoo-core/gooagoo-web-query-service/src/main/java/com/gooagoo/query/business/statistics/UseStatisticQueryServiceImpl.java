package com.gooagoo.query.business.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.UseStatisticQueryService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.query.business.statistics.common.CouponCommonOperate;
import com.gooagoo.query.business.statistics.common.MongoOperateDate;
import com.gooagoo.query.business.statistics.common.RedisOperateData;
import com.gooagoo.query.business.statistics.common.utils.StatisticsDataUtil;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.mongodb.DBCollection;

@Service
public class UseStatisticQueryServiceImpl implements UseStatisticQueryService
{
    @Override
    public int toolUseTimes(String shopId, String toolId, String dateType, String userType, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_tools);
            result = RedisOperateData.getInteractionScore(dao, shopId + "_" + toolId, "U", userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.shopToolDB, CollectionConstants.ST_SHOPTOOL_NUMS);
            String innerKey = userType + "_U";
            result = MongoOperateDate.getPnumValue(collection, shopId + "_" + toolId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public List<String> toolUsePoeple(String shopId, String toolId, String dateType, String userType, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_tools);
            result = RedisOperateData.getOrdersetValues(dao, shopId + "_" + toolId, "U", userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.shopToolDB, CollectionConstants.ST_SHOPTOOL_NUM);
            String innerKey = userType + "_U";
            result = MongoOperateDate.getPidValuesInfo(collection, shopId + "_" + toolId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public int couponUseTimes(String couponId, String userType, String dateType, Date dateTime)
    {
        return CouponCommonOperate.getTimes(couponId, "U", userType, dateType, dateTime, null, null);
    }

    @Override
    public List<String> couponUsePeople(String couponId, String userType, String dateType, Date dateTime)
    {
        return CouponCommonOperate.getPeople(couponId, "U", userType, dateType, dateTime, null, null);
    }

}
