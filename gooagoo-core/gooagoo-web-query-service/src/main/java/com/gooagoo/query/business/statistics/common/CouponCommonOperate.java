package com.gooagoo.query.business.statistics.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.query.business.statistics.common.utils.StatisticsDataUtil;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.mongodb.DBCollection;

/**
 * 惠凭证统计
 * @author Administrator
 *
 */
public class CouponCommonOperate
{
    public static int getTimes(String couponId, String behaveType, String userType, String dateType, Date dateTime, String channel, String source)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);
            result = RedisOperateData.getInteractionScore(dao, couponId, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.voucherDB, CollectionConstants.VC_VOUCHER_NUMS);
            String innerKey = userType;
            result = MongoOperateDate.getPnumValue(collection, couponId, dateType, innerKey, dateTime);
        }
        return result;
    }

    public static List<String> getPeople(String couponId, String behaveType, String userType, String dateType, Date dateTime, String channel, String source)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);
            result = RedisOperateData.getOrdersetValues(dao, couponId, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.voucherDB, CollectionConstants.VC_VOUCHER_NUM);
            String innerKey = userType;
            result = MongoOperateDate.getPidValuesInfo(collection, couponId, dateType, innerKey, dateTime);
        }
        return result;
    }
}
