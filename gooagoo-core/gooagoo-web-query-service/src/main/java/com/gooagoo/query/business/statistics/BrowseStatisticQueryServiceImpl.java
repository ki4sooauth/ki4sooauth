package com.gooagoo.query.business.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.BrowseStatisticQueryService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.query.business.statistics.common.ActivityCommonOperate;
import com.gooagoo.query.business.statistics.common.CouponCommonOperate;
import com.gooagoo.query.business.statistics.common.GoodsCommonOperate;
import com.gooagoo.query.business.statistics.common.MongoOperateDate;
import com.gooagoo.query.business.statistics.common.RedisOperateData;
import com.gooagoo.query.business.statistics.common.utils.StatisticsDataUtil;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.mongodb.DBCollection;

@Service
public class BrowseStatisticQueryServiceImpl implements BrowseStatisticQueryService
{

    @Override
    public int toolBrowsTimes(String shopId, String toolId, String userType, String dateType, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_tools);
            result = RedisOperateData.getInteractionScore(dao, toolId, "B", userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.shopToolDB, CollectionConstants.ST_SHOPTOOL_NUMS);
            String innerKey = userType + "_B";
            result = MongoOperateDate.getPnumValue(collection, toolId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public List<String> toolsBrowsPeople(String shopId, String toolId, String userType, String dateType, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_tools);
            result = RedisOperateData.getOrdersetValues(dao, toolId, "B", userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.shopToolDB, CollectionConstants.ST_SHOPTOOL_NUM);
            String innerKey = userType + "_B";
            result = MongoOperateDate.getPidValuesInfo(collection, toolId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public int couponBrowsTimes(String couponId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        return CouponCommonOperate.getTimes(couponId, "B", userType, dateType, dateTime, channel, source);
    }

    @Override
    public List<String> couponBrowsPeople(String couponId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        return CouponCommonOperate.getPeople(couponId, "B", userType, dateType, dateTime, channel, source);
    }

    @Override
    public int activityBrowsTimes(String activityId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        return ActivityCommonOperate.getTimes(activityId, "B", userType, dateType, dateTime, channel, source);
    }

    @Override
    public List<String> activityBrowsPoeple(String activityId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        return ActivityCommonOperate.getPoeple(activityId, "B", userType, dateType, dateTime, channel, source);
    }

    @Override
    public int goodsBrowsTimes(String shopId, String goodsSerialNo, String dateType, String userType, String channel, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsSerialTimes(shopId + "_" + goodsSerialNo, "B", dateType, userType, channel, source, dateTime);
    }

    @Override
    public List<String> goodsBrowsPoeple(String shopId, String goodsSerialNo, String dateType, String userType, String channel, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsSerialPoeple(shopId + "_" + goodsSerialNo, "B", dateType, userType, channel, source, dateTime);
    }

    @Override
    public int categoryBrowsTimes(String shopId, String categorySerialNo, String dateType, String userType, String channel, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsCategoryTimes(shopId + "_" + categorySerialNo, "B", dateType, userType, channel, source, dateTime);
    }

    @Override
    public List<String> categoryBrowsPoeple(String shopId, String categorySerialNo, String dateType, String userType, String channel, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsCategoryPoeple(shopId + "_" + categorySerialNo, "B", dateType, userType, channel, source, dateTime);
    }

    @Override
    public int brandBrowsTimes(String shopId, String brandId, String dateType, String userType, String channel, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsBrandTimes(shopId + "_" + brandId, "B", dateType, userType, channel, source, dateTime);
    }

    @Override
    public List<String> brandBrowsPoeple(String shopId, String brandId, String dateType, String userType, String channel, Date dateTime, String source)
    {
        return GoodsCommonOperate.goodsBrandPoeple(shopId + "_" + brandId, "B", dateType, userType, channel, source, dateTime);
    }

    @Override
    public int cryoutBrowsTimes(String cryoutId, String dateType, String userType, String source, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_cryout);
            result = RedisOperateData.getInteractionScore(dao, cryoutId, "B", userType, null, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.cryoutDB, CollectionConstants.CO_CRYOUT_NUMS);
            String innerKey = userType + "_" + source;
            result = MongoOperateDate.getPnumValue(collection, cryoutId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public List<String> cryoutBrowsPeople(String cryoutId, String dateType, String userType, String source, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_cryout);
            result = RedisOperateData.getOrdersetValues(dao, cryoutId, "B", userType, null, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.cryoutDB, CollectionConstants.CO_CRYOUT_NUM);
            String innerKey = userType + "_" + source;
            result = MongoOperateDate.getPidValuesInfo(collection, cryoutId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public int noticeBrowsTimes(String noticeId, String dateType, String userType, String source, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_notice);
            result = RedisOperateData.getInteractionScore(dao, noticeId, "B", userType, null, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.noticeDB, CollectionConstants.NT_NOTICE_NUMS);
            String innerKey = userType + "_" + source;
            result = MongoOperateDate.getPnumValue(collection, noticeId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public List<String> noticeBrowsPeople(String noticeId, String dateType, String userType, String source, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_notice);
            result = RedisOperateData.getOrdersetValues(dao, noticeId, "B", userType, null, source, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.noticeDB, CollectionConstants.NT_NOTICE_NUM);
            String innerKey = userType + "_" + source;
            result = MongoOperateDate.getPidValuesInfo(collection, noticeId, dateType, innerKey, dateTime);
        }
        return result;
    }

    @Override
    public int purchaseAndcuriosityBrowsTimes(String purchaseId, String dateType, String userType, Date dateTime)
    {
        int result = 0;
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_inquisitive);
            result = RedisOperateData.getInteractionScore(dao, purchaseId, null, userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.shopingPryDB, CollectionConstants.SP_SHOPPING_NUMS);
            result = MongoOperateDate.getPnumValue(collection, purchaseId, dateType, userType, dateTime);
        }
        return result;
    }

    @Override
    public List<String> purchaseAndcuriosityBrowsPeople(String purchaseId, String dateType, String userType, Date dateTime)
    {
        List<String> result = new ArrayList<String>();
        if (StatisticsDataUtil.isToday(dateTime))
        {
            RedisSortedSetDao dao = new RedisSortedSetDao(RedisServerConstants.statistics_inquisitive);
            result = RedisOperateData.getOrdersetValues(dao, purchaseId, null, userType, null, null, dateType, dateTime);
        }
        else
        {
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.shopingPryDB, CollectionConstants.SP_SHOPPING_NUM);
            result = MongoOperateDate.getPidValuesInfo(collection, purchaseId, dateType, userType, dateTime);
        }
        return result;
    }

}
