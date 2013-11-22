package com.gooagoo.query.business.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.ConsumeStatisticQueryService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.query.business.statistics.common.MongoOperateDate;
import com.gooagoo.query.business.statistics.common.RedisOperateData;
import com.gooagoo.query.business.statistics.common.utils.StatisticsDataUtil;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Service
public class ConsumeStatisticQueryServiceImpl implements ConsumeStatisticQueryService
{
    @Override
    public int consumeNums(String shopId, String dateType, String userType, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_consumption);
            String key = StatisticsDataUtil.jointKeyForRedis(shopId, null, userType, null, null, dateType, dateTime);
            Set<String> set = sortedSetDao.get(key, 0, -1);
            result = set.size();
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.consumerDB, CollectionConstants.CS_CONSUMER_NUM);
            String key = StatisticsDataUtil.jointIdForMongo(shopId, dateType, dateTime);
            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");
                if (keySource.equals(key))
                {
                    if (next.get(userType) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(userType);
                        result = (int) Double.parseDouble(aDB.get("pnum").toString());
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public int consumeTimes(String shopId, String dateType, String userType, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_consumption);
            Set<String> set = sortedSetDao.get("count", 0, sortedSetDao.zcard("count"));

            String valueSource = StatisticsDataUtil.jointKeyForRedis(shopId, null, userType, null, null, dateType, dateTime);

            for (String value : set)
            {
                //应该判断value的值，得到score值，即为次数
                if (valueSource.equals(value))
                {
                    result = sortedSetDao.getScore("count", value).intValue();
                    break;
                }
            }
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.consumerDB, CollectionConstants.CS_CONSUMER_CNUMS);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");
                if (keySource.equals(StatisticsDataUtil.jointIdForMongo(shopId, dateType, dateTime)))
                {
                    if (next.get(userType) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(userType);

                        result = (int) Double.parseDouble(aDB.get("pnum").toString());
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<String> consumePeople(String shopId, String dateType, String userType, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_consumption);
            RedisOperateData.getOrdersetValues(dao, shopId, null, userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.consumerDB, CollectionConstants.CS_CONSUMER_NUM);
            result = MongoOperateDate.getPidValuesInfo(collection, shopId, dateType, userType, dateTime);
        }
        return result;
    }

    @Override
    public double consumeAmount(String shopId, String dateType, String userType, Date dateTime)
    {
        // 查询消费金额
        double result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            //从redis中 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_consumption);
            Set<String> set = sortedSetDao.get("money", 0, sortedSetDao.zcard("money"));

            String valueSource = StatisticsDataUtil.jointKeyForRedis(shopId, null, userType, null, null, dateType, dateTime);

            for (String value : set)
            {
                //应该判断value的值，得到score值，即为次数
                if (valueSource.equals(value))
                {
                    result = sortedSetDao.getScore("money", value);
                    break;
                }
            }
        }
        else
        {
            //从Mongo中 查询
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.consumerDB, CollectionConstants.CS_CONSUMER_MNUMS);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");
                if (keySource.equals(StatisticsDataUtil.jointIdForMongo(shopId, dateType, dateTime)))
                {
                    if (next.get(userType) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(userType);

                        Object pnum = aDB.get("pnum");
                        result = (Double) pnum;
                        break;
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<String> consumeAmountPeople(String shopId, String dateType, String userType, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_consumption);
            Set<String> set = sortedSetDao.get("money", 0, sortedSetDao.zcard("money"));
            result.addAll(set);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.consumerDB, CollectionConstants.CS_CONSUMER_NUM);
            result = MongoOperateDate.getPidValuesInfo(collection, shopId, dateType, userType, dateTime);
        }
        return result;
    }

}
