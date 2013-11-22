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
 * 商品统计 查询 人 次数
 * @author Administrator
 *
 */
public class GoodsCommonOperate
{
    public static int goodsSerialTimes(String id, String behaveType, String dateType, String userType, String channel, String source, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
            result = RedisOperateData.getInteractionScore(dao, id, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.COM_COMMODITY_NUMS);
            String innerKey = userType + "_" + behaveType + "_" + channel + "_" + source;
            result = MongoOperateDate.getPnumValue(collection, id, dateType, innerKey, dateTime);
        }
        return result;
    }

    public static List<String> goodsSerialPoeple(String id, String behaveType, String dateType, String userType, String channel, String source, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
            result = RedisOperateData.getOrdersetValues(dao, id, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.COM_COMMODITY_NUM);
            String innerKey = userType + "_" + behaveType + "_" + channel + "_" + source;
            result = MongoOperateDate.getPidValuesInfo(collection, id, dateType, innerKey, dateTime);
        }
        return result;
    }

    public static int goodsBrandTimes(String id, String behaveType, String dateType, String userType, String channel, String source, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);
            result = RedisOperateData.getInteractionScore(dao, id, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.COM_COMMODITY_NUMS);
            String innerKey = userType + "_" + behaveType + "_" + channel + "_" + source;
            result = MongoOperateDate.getPnumValue(collection, id, dateType, innerKey, dateTime);
        }
        return result;
    }

    public static List<String> goodsBrandPoeple(String id, String behaveType, String dateType, String userType, String channel, String source, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);
            result = RedisOperateData.getOrdersetValues(dao, id, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.COM_COMMODITY_NUM);
            String innerKey = userType + "_" + behaveType + "_" + channel + "_" + source;
            result = MongoOperateDate.getPidValuesInfo(collection, id, dateType, innerKey, dateTime);
        }
        return result;
    }

    public static int goodsCategoryTimes(String id, String behaveType, String dateType, String userType, String channel, String source, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);
            result = RedisOperateData.getInteractionScore(dao, id, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.COM_COMMODITY_NUMS);
            String innerKey = userType + "_" + behaveType + "_" + channel + "_" + source;
            result = MongoOperateDate.getPnumValue(collection, id, dateType, innerKey, dateTime);
        }
        return result;
    }

    public static List<String> goodsCategoryPoeple(String id, String behaveType, String dateType, String userType, String channel, String source, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);
            result = RedisOperateData.getOrdersetValues(dao, id, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.COM_COMMODITY_NUM);
            String innerKey = userType + "_" + behaveType + "_" + channel + "_" + source;
            result = MongoOperateDate.getPidValuesInfo(collection, id, dateType, innerKey, dateTime);
        }
        return result;
    }

    public static int goodsExchangeTimes(String id, String behaveType, String dateType, String userType, String channel, String source, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
            result = RedisOperateData.getInteractionScore(dao, id, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.COM_COMMODITY_NUMS);
            String innerKey = userType + "_" + behaveType + "_" + channel + "_" + source;
            result = MongoOperateDate.getPnumValue(collection, id, dateType, innerKey, dateTime);
        }
        return result;
    }

    public static List<String> goodsExchangePoeple(String id, String behaveType, String dateType, String userType, String channel, String source, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
            result = RedisOperateData.getOrdersetValues(dao, id, behaveType, userType, channel, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.COM_COMMODITY_NUM);
            String innerKey = userType + "_" + behaveType + "_" + channel + "_" + source;
            result = MongoOperateDate.getPidValuesInfo(collection, id, dateType, innerKey, dateTime);
        }
        return result;
    }
}
