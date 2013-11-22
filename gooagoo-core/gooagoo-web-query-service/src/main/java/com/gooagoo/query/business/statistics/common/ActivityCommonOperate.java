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
 * 活动统计 查询次数 人 信息
 * @author Administrator
 *
 */
public class ActivityCommonOperate
{
    public static int getTimes(String activityId, String behaveType, String userType, String dateType, Date dateTime, String channel, String source)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_activity);
            result = RedisOperateData.getInteractionScore(dao, activityId, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.activityDB, CollectionConstants.ACT_ACTIVITY_NUMS);
            String innerKey = userType + "_" + behaveType + "_" + channel + "_" + source;
            result = MongoOperateDate.getPnumValue(collection, activityId, dateType, innerKey, dateTime);
        }
        return result;
    }

    public static List<String> getPoeple(String activityId, String behaveType, String userType, String dateType, Date dateTime, String channel, String source)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_activity);
            result = RedisOperateData.getOrdersetValues(dao, activityId, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.activityDB, CollectionConstants.ACT_ACTIVITY_NUM);
            String innerKey = userType + "_" + behaveType + "_" + channel + "_" + source;
            result = MongoOperateDate.getPidValuesInfo(collection, activityId, dateType, innerKey, dateTime);
        }
        return result;
    }
}
