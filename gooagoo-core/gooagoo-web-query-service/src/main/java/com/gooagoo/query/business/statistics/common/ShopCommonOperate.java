package com.gooagoo.query.business.statistics.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.query.business.statistics.common.utils.StatisticsDataUtil;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.mongodb.DBCollection;

public class ShopCommonOperate
{
    public static int getCurrentNum(String id, String userType, RedisSortedSetDao dao)
    {
        int result = 0;
        String key = id + "_" + userType;
        result = (int) dao.zcard(key);
        return result;
    }

    public static List<String> getCurrentPeople(String id, String userType, RedisSortedSetDao dao)
    {
        List<String> result = new ArrayList<String>();
        String key = id + "_" + userType;
        Set<String> set = dao.get(key, 0, -1);
        result.addAll(set);
        return result;
    }

    public static int getNum(String id, String dateType, String userType, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_arriveNum);
            String key = StatisticsDataUtil.jointKeyForRedis(id, null, userType, null, null, dateType, dateTime);
            result = (int) sortedSetDao.zcard(key);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.footmarkDB, CollectionConstants.FM_FOOTMARK_NUM);
            result = MongoOperateDate.getPnumValue(collection, id, dateType, userType, dateTime);
        }
        return result;
    }

    public static int getTimes(String id, String dateType, String userType, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_arrive);
            String key = StatisticsDataUtil.jointKeyForRedis(id, null, userType, null, null, dateType, dateTime);
            result = (int) sortedSetDao.zcard(key);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.footmarkDB, CollectionConstants.FM_FOOTMARK_NUMS);
            result = MongoOperateDate.getPnumValue(collection, id, dateType, userType, dateTime);
        }
        return result;
    }

    public static List<String> getPeople(String id, String dateType, String userType, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_arrive);
            String key = StatisticsDataUtil.jointKeyForRedis(id, null, userType, null, null, dateType, dateTime);
            Set<String> set = sortedSetDao.get(key, 0, sortedSetDao.zcard(key));
            result.addAll(set);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.footmarkDB, CollectionConstants.FM_FOOTMARK_NUM);
            result = MongoOperateDate.getPidValuesInfo(collection, id, dateType, userType, dateTime);
        }
        return result;
    }

    public static int getMemberNum(String id, String userType, Date startTime, Date endTime)
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_member);
        Long l = sortedSetDao.zcount(id + "_" + userType, startTime.getTime(), endTime.getTime());
        return l.intValue();
    }

    public static List<String> getMemberPeople(String shopId, String userType, Date startTime, Date endTime)
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_member);
        Set<String> set = sortedSetDao.zrangeByScore(shopId + "_" + userType, startTime.getTime(), endTime.getTime());
        return new ArrayList<String>(set);
    }

}
