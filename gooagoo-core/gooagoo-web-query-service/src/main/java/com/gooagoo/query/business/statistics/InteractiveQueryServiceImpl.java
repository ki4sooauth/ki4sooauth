package com.gooagoo.query.business.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.InteractiveQueryService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.query.business.statistics.common.MongoOperateDate;
import com.gooagoo.query.business.statistics.common.RedisOperateData;
import com.gooagoo.query.business.statistics.common.utils.StatisticsDataUtil;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.mongodb.DBCollection;

@Service
public class InteractiveQueryServiceImpl implements InteractiveQueryService
{
    @Override
    public int findPhoneInterPeopleNum(String shopId, String dateType, String userType, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_interaction);
            result = RedisOperateData.getInteractionScore(dao, shopId, "1", userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.interactionDB, CollectionConstants.IA_INTERACTION_NUM);
            String innerKey = "1_" + userType;
            result = MongoOperateDate.getPnumValue(collection, shopId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public int findPhoneInterTimes(String shopId, String dateType, String userType, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_interaction);
            result = RedisOperateData.getInteractionScore(dao, shopId, "1", userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.interactionDB, CollectionConstants.IA_INTERACTION_NUMS);
            String innerKey = "1_" + userType;
            result = MongoOperateDate.getPnumValue(collection, shopId, dateType, innerKey, dateTime);
        }

        return result;
    }

    @Override
    public List<String> findPhoneInterPeople(String shopId, String dateType, String userType, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_interaction);
            result = RedisOperateData.getOrdersetValues(dao, shopId, "1", userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.interactionDB, CollectionConstants.IA_INTERACTION_NUM);
            String innerKey = "1_" + userType;
            result = MongoOperateDate.getPidValuesInfo(collection, shopId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public int findWebInterPeopleNum(String shopId, String dateType, String userType, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_interaction);
            result = RedisOperateData.getInteractionScore(dao, shopId, "3", userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.interactionDB, CollectionConstants.IA_INTERACTION_NUM);
            String innerKey = "3_" + userType;
            result = MongoOperateDate.getPnumValue(collection, shopId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public int findWebInterTimes(String shopId, String dateType, String userType, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_interaction);
            result = RedisOperateData.getInteractionScore(dao, shopId, "3", userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.interactionDB, CollectionConstants.IA_INTERACTION_NUMS);
            String innerKey = "3_" + userType;
            result = MongoOperateDate.getPnumValue(collection, shopId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public List<String> findWebInterPeople(String shopId, String dateType, String userType, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_interaction);
            result = RedisOperateData.getOrdersetValues(dao, shopId, "3", userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.interactionDB, CollectionConstants.IA_INTERACTION_NUM);
            String innerKey = "3_" + userType;
            result = MongoOperateDate.getPidValuesInfo(collection, shopId, dateType, innerKey, dateTime);
        }
        return result;
    }

}
