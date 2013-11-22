package com.gooagoo.core.business.statistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.statistics.CollectStatisticCoreService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Service
public class CollectStatisticCoreServiceImpl implements CollectStatisticCoreService
{
    /**
     * 判断是否是今天
     * @param dateTime
     * @return
     */
    private boolean isToday(Date dateTime)
    {
        boolean flag = false;
        Date todayDate = new Date();
        Calendar tTime = Calendar.getInstance();
        tTime.setTime(todayDate);

        Calendar dTime = Calendar.getInstance();
        dTime.setTime(dateTime);

        int tYear = tTime.get(Calendar.YEAR);
        int tMonth = tTime.get(Calendar.MONTH);
        int tDay = tTime.get(Calendar.DAY_OF_MONTH);

        int dYear = dTime.get(Calendar.YEAR);
        int dMonth = dTime.get(Calendar.MONTH);
        int dDay = dTime.get(Calendar.DAY_OF_MONTH);

        if (tYear == dYear && tMonth == dMonth && tDay == dDay)
        {
            flag = true;
        }

        return flag;
    }

    /**
     * 拼接redis的key值
     * @param shopId
     * @param dateType
     * @param userType
     * @param dateTime
     * @return
     */
    private String jointKeyForRedis(String couponId, String type, String userType, String dateType, Date dateTime, String channel, String source)
    {
        //优惠凭证ID_浏览(B)/收藏(F)_用户类型
        //优惠凭证ID_浏览(B)/收藏(F)_用户类型_渠道
        //优惠凭证ID_浏览(B)/收藏(F)_用户类型_渠道_来源
        //优惠凭证ID_浏览(B)/收藏(F)_用户类型_渠道_来源_D日_H小时
        //优惠凭证ID_浏览(B)/收藏(F)_用户类型_渠道_来源_D日
        //优惠凭证ID_浏览(B)/收藏(F)_用户类型_渠道_来源_W周
        //优惠凭证ID_浏览(B)/收藏(F)_用户类型_渠道_来源_M月
        //优惠凭证ID_浏览(B)/收藏(F)_用户类型_渠道_来源_Y年
        //优惠凭证ID_兑换(E)/分享(S)/使用(U)_用户类型
        //优惠凭证ID_兑换(E)/分享(S)/使用(U)_用户类型_D日_H小时
        //优惠凭证ID_兑换(E)/分享(S)/使用(U)_用户类型_D日
        //优惠凭证ID_兑换(E)/分享(S)/使用(U)_用户类型_W周
        //优惠凭证ID_兑换(E)/分享(S)/使用(U)_用户类型_M月
        //优惠凭证ID_兑换(E)/分享(S)/使用(U)_用户类型_Y年

        //dateType Y M D H null

        DecimalFormat df = new DecimalFormat("00");
        Calendar time = Calendar.getInstance();

        time.setTime(dateTime);

        String year = String.valueOf(time.get(Calendar.YEAR));
        String month = df.format(time.get(Calendar.MONTH) + 1);
        String day = df.format(time.get(Calendar.DAY_OF_MONTH));
        String hour = df.format(time.get(Calendar.HOUR_OF_DAY));

        StringBuffer key = new StringBuffer(couponId + "_" + type + "_" + userType);
        if (source != null)
        {
            key.append("_" + source);
            if (channel != null)
            {
                key.append("_" + channel);
                {
                    if ("Y".equals(dateType))
                    {
                        key.append("_Y" + year);
                    }
                    else if ("M".equals(dateType))
                    {
                        key.append("_M" + month);
                    }
                    else if ("D".equals(dateType))
                    {
                        key.append("_D" + day);
                    }
                    else if ("H".equals(dateType))
                    {
                        key.append("_D" + day + "_H" + hour);
                    }
                    else
                    {
                    }
                }
            }
        }

        return key.toString();
    }

    /**
     * 拼接Mongo的key
     * @param shopId
     * @param dateType
     * @param dateTime
     * @return
     */
    private String jointKeyForMongo(String toolId, String dateType, Date dateTime)
    {
        //商家ID/实体店ID/区域ID_时间类型

        StringBuffer key = new StringBuffer(toolId);

        DecimalFormat df = new DecimalFormat("00");
        Calendar time = Calendar.getInstance();

        time.setTime(dateTime);

        String year = String.valueOf(time.get(Calendar.YEAR));
        String month = df.format(time.get(Calendar.MONTH) + 1);
        String day = df.format(time.get(Calendar.DAY_OF_MONTH));
        String hour = df.format(time.get(Calendar.HOUR_OF_DAY));

        if ("Y".equals(dateType))
        {
            key.append("_Y" + year);
        }
        else if ("M".equals(dateType))
        {
            key.append("_M" + month);
        }
        else if ("D".equals(dateType))
        {
            key.append("_D" + day);
        }
        else if ("H".equals(dateType))
        {
            key.append("_D" + day + "_H" + hour);
        }
        else
        {
        }

        return key.toString();
    }

    @Override
    public int couponCollectTimes(String couponId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        // 查询优惠凭证收藏次数
        int result = 0;
        if (dateTime != null && this.isToday(dateTime))
        {
            //从redis中 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);
            Set<String> set = sortedSetDao.get("Interaction", 0, sortedSetDao.zcard("Interaction"));

            String valueSource = this.jointKeyForRedis(couponId, "F", userType, dateType, dateTime, channel, source);

            for (String value : set)
            {
                //应该判断value的值，得到score值，即为次数
                if (valueSource.equals(value))
                {
                    result = sortedSetDao.getScore("Interaction", value).intValue();
                    break;
                }
            }
        }
        else
        {
            //从Mongo中 查询
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.voucherDB, CollectionConstants.VC_VOUCHER_NUMS);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");
                //TODO 此处mongo中key值是商家ID，没有优惠凭证ID
                if (keySource.equals(this.jointKeyForMongo(couponId, dateType, dateTime)))
                {
                    if (next.get(userType) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(userType);

                        Object pnum = aDB.get("pnum");
                        result = (Integer) pnum;
                        break;
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<String> couponCollectPeople(String couponId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        // 查询优惠凭证收藏人群
        List<String> result = new ArrayList<String>();
        if (this.isToday(dateTime))
        {
            //redis 查询商家所有实体店店内人群
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);
            String key = this.jointKeyForRedis(couponId, "F", userType, dateType, dateTime, channel, source);
            Set<String> set = sortedSetDao.get(key, 0, sortedSetDao.zcard(key));

            result.addAll(set);
        }
        else
        {
            //从Mongo中查
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.voucherDB, CollectionConstants.VC_VOUCHER_NUM);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(couponId, dateType, dateTime)))
                {
                    if (next.get(userType) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(userType);

                        Object pid = aDB.get("pid");

                        //TODO pid应该是一个String数组，此处直接add应该是错误的！
                        result.add((String) pid);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public int activityCollectTimes(String activityId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        // 查询活动收藏次数
        int result = 0;
        if (this.isToday(dateTime))
        {
            //从redis中 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_activity);
            Set<String> set = sortedSetDao.get("Interaction", 0, sortedSetDao.zcard("Interaction"));

            String valueSource = this.jointKeyForRedis(activityId, "F", userType, dateType, dateTime, channel, source);

            for (String value : set)
            {
                //应该判断value的值，得到score值，即为次数
                if (valueSource.equals(value))
                {
                    result = sortedSetDao.getScore("Interaction", value).intValue();
                    break;
                }
            }
        }
        else
        {
            //从Mongo中 查询
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.activityDB, CollectionConstants.ACT_ACTIVITY_NUMS);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");
                //TODO 此处mongo中key值是商家ID，没有优惠凭证ID
                if (keySource.equals(this.jointKeyForMongo(activityId, dateType, dateTime)))
                {
                    String innerKey = userType + "_F";
                    if (next.get(innerKey) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(innerKey);

                        Object pnum = aDB.get("pnum");
                        result = (Integer) pnum;
                        break;
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<String> activityCollectPoeple(String activityId, String userType, String dateType, Date dateTime, String channel, String source)
    {
        // 查询活动收藏人群
        List<String> result = new ArrayList<String>();
        if (this.isToday(dateTime))
        {
            //redis 查询商家所有实体店店内人群
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_activity);
            String key = this.jointKeyForRedis(activityId, "F", userType, dateType, dateTime, channel, source);
            Set<String> set = sortedSetDao.get(key, 0, sortedSetDao.zcard(key));

            result.addAll(set);
        }
        else
        {
            //从Mongo中查
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.activityDB, CollectionConstants.ACT_ACTIVITY_NUMS);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(activityId, dateType, dateTime)))
                {
                    String innerKey = userType + "_F";
                    if (next.get(innerKey) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(innerKey);

                        Object pid = aDB.get("pid");

                        //TODO pid应该是一个String数组，此处直接add应该是错误的！
                        result.add((String) pid);
                    }
                }
            }
        }

        return result;
    }

    private String jointKeyForRedis(String shopId, String goodsSerialNo, String type, String dateType, String userType, Date dateTime, String source)
    {
        //商家ID/实体店ID_商品自定义序列号/品类/品牌_评论C_用户类型
        //商家ID/实体店ID_商品自定义序列号/品类/品牌_评论C_用户类型_来源
        //商家ID/实体店ID_商品自定义序列号/品类/品牌_评论C_用户类型_来源_D日
        //商家ID/实体店ID_商品自定义序列号/品类/品牌_评论C_用户类型_来源_D日_H小时
        //商家ID/实体店ID_商品自定义序列号/品类/品牌_评论C_用户类型_来源_W周
        //商家ID/实体店ID_商品自定义序列号/品类/品牌_评论C_用户类型_来源_月
        //商家ID/实体店ID_商品自定义序列号/品类/品牌_评论C_用户类型_来源_Y年

        //dateType Y M D H null

        DecimalFormat df = new DecimalFormat("00");
        Calendar time = Calendar.getInstance();

        time.setTime(dateTime);

        String year = String.valueOf(time.get(Calendar.YEAR));
        String month = df.format(time.get(Calendar.MONTH) + 1);
        String day = df.format(time.get(Calendar.DAY_OF_MONTH));
        String hour = df.format(time.get(Calendar.HOUR_OF_DAY));

        StringBuffer key = new StringBuffer(shopId + "_" + goodsSerialNo + "_" + type + "_" + userType);
        if (source != null)
        {
            key.append("_" + source);
            if ("Y".equals(dateType))
            {
                key.append("_Y" + year);
            }
            else if ("M".equals(dateType))
            {
                key.append("_M" + month);
            }
            else if ("D".equals(dateType))
            {
                key.append("_D" + day);
            }
            else if ("H".equals(dateType))
            {
                key.append("_D" + day + "_H" + hour);
            }
            else
            {
            }
        }

        return key.toString();
    }

    private String jointKeyForMongo(String shopId, String goodsSerialNo, String dateType, Date dateTime)
    {
        //商家id/实体店id_商品id/品类id/品牌id_时间类型

        StringBuffer key = new StringBuffer(shopId + "_" + goodsSerialNo);

        DecimalFormat df = new DecimalFormat("00");
        Calendar time = Calendar.getInstance();

        time.setTime(dateTime);

        String year = String.valueOf(time.get(Calendar.YEAR));
        String month = df.format(time.get(Calendar.MONTH) + 1);
        String day = df.format(time.get(Calendar.DAY_OF_MONTH));
        String hour = df.format(time.get(Calendar.HOUR_OF_DAY));

        if ("Y".equals(dateType))
        {
            key.append("_Y" + year);
        }
        else if ("M".equals(dateType))
        {
            key.append("_M" + month);
        }
        else if ("D".equals(dateType))
        {
            key.append("_D" + day);
        }
        else if ("H".equals(dateType))
        {
            key.append("_D" + day + "_H" + hour);
        }
        else
        {
        }

        return key.toString();
    }

    @Override
    public int goodsCollectTimes(String shopId, String goodsSerialNo, String dateType, String userType, String channel, String source, Date dateTime)
    {
        // 查询商品收藏次数
        int result = 0;
        if (this.isToday(dateTime))
        {
            // redis 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);

            Set<String> set = sortedSetDao.get("Interaction", 0, sortedSetDao.zcard("Interaction"));

            String valueSource = this.jointKeyForRedis(shopId, goodsSerialNo, "F", dateType, userType, dateTime, source);

            for (String value : set)
            {
                //应该判断value的值，得到score值，即为次数
                if (valueSource.equals(value))
                {
                    result = sortedSetDao.getScore("Interaction", value).intValue();
                    break;
                }
            }
        }
        else
        {
            //从 Mongo 中查询
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.COM_COMMODITY_NUMS);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(shopId, goodsSerialNo, dateType, dateTime)))
                {
                    //innerKey 用户类型_行为类型_渠道类型_来源类型
                    String innerKey = userType + "_F_" + source;
                    if (next.get(innerKey) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(innerKey);

                        Object pnum = aDB.get("pnum");
                        result = (Integer) pnum;
                        break;
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<String> goodsCollectPoeple(String shopId, String goodsSerialNo, String dateType, String userType, String channel, String source, Date dateTime)
    {
        // TODO 查询商品收藏人群
        List<String> result = new ArrayList<String>();
        if (this.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
            String key = this.jointKeyForRedis(shopId, goodsSerialNo, "F", dateType, userType, dateTime, source);
            Set<String> set = sortedSetDao.get(key, 0, sortedSetDao.zcard(key));

            result.addAll(set);
        }
        else
        {
            //从Mongo中查
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.consumerDB, CollectionConstants.CS_CONSUMER_NUM);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(shopId, goodsSerialNo, dateType, dateTime)))
                {
                    String innerKey = userType + "_F_" + source;
                    if (next.get(innerKey) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(innerKey);

                        Object pid = aDB.get("pid");

                        //TODO pid应该是一个String数组，此处直接add应该是错误的！
                        result.add((String) pid);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public int categoryCollectTimes(String shopId, String categorySerialNo, String dateType, String userType, String channel, String source, Date dateTime)
    {
        // 查询品类收藏次数
        int result = 0;
        if (this.isToday(dateTime))
        {
            // redis 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);

            Set<String> set = sortedSetDao.get("Interaction", 0, sortedSetDao.zcard("Interaction"));

            String valueSource = this.jointKeyForRedis(shopId, categorySerialNo, "F", dateType, userType, dateTime, source);

            for (String value : set)
            {
                //应该判断value的值，得到score值，即为次数
                if (valueSource.equals(value))
                {
                    result = sortedSetDao.getScore("Interaction", value).intValue();
                    break;
                }
            }
        }
        else
        {
            //从 Mongo 中查询
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.COM_COMMODITY_NUMS);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(shopId, categorySerialNo, dateType, dateTime)))
                {
                    //innerKey 用户类型_行为类型_渠道类型_来源类型
                    String innerKey = userType + "_F_" + source;
                    if (next.get(innerKey) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(innerKey);

                        Object pnum = aDB.get("pnum");
                        result = (Integer) pnum;
                        break;
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<String> categoryCollectPoeple(String shopId, String categorySerialNo, String dateType, String userType, String channel, String source, Date dateTime)
    {
        // 查询品类收藏人群
        List<String> result = new ArrayList<String>();
        if (this.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);
            String key = this.jointKeyForRedis(shopId, categorySerialNo, "F", dateType, userType, dateTime, source);
            Set<String> set = sortedSetDao.get(key, 0, sortedSetDao.zcard(key));

            result.addAll(set);
        }
        else
        {
            //从Mongo中查
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.consumerDB, CollectionConstants.CS_CONSUMER_NUM);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(shopId, categorySerialNo, dateType, dateTime)))
                {
                    String innerKey = userType + "_F_" + source;
                    if (next.get(innerKey) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(innerKey);

                        Object pid = aDB.get("pid");

                        //TODO pid应该是一个String数组，此处直接add应该是错误的！
                        result.add((String) pid);
                    }
                }
            }
        }

        return result;
    }

    @Override
    public int brandCollectTimes(String shopId, String categorySerialNo, String dateType, String userType, String channel, String source, Date dateTime)
    {
        // 查询品牌收藏次数
        int result = 0;
        if (this.isToday(dateTime))
        {
            // redis 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);

            Set<String> set = sortedSetDao.get("Interaction", 0, sortedSetDao.zcard("Interaction"));

            String valueSource = this.jointKeyForRedis(shopId, categorySerialNo, "F", dateType, userType, dateTime, source);

            for (String value : set)
            {
                //应该判断value的值，得到score值，即为次数
                if (valueSource.equals(value))
                {
                    result = sortedSetDao.getScore("Interaction", value).intValue();
                    break;
                }
            }
        }
        else
        {
            //从 Mongo 中查询
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.COM_COMMODITY_NUMS);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(shopId, categorySerialNo, dateType, dateTime)))
                {
                    //innerKey 用户类型_行为类型_渠道类型_来源类型
                    String innerKey = userType + "_F_" + source;
                    if (next.get(innerKey) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(innerKey);

                        Object pnum = aDB.get("pnum");
                        result = (Integer) pnum;
                        break;
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<String> brandCollectPoeple(String shopId, String brandId, String dateType, String userType, String channel, String source, Date dateTime)
    {
        // 查询品类收藏人群
        List<String> result = new ArrayList<String>();
        if (this.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);
            String key = this.jointKeyForRedis(shopId, brandId, "F", dateType, userType, dateTime, source);
            Set<String> set = sortedSetDao.get(key, 0, sortedSetDao.zcard(key));

            result.addAll(set);
        }
        else
        {
            //从Mongo中查
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.consumerDB, CollectionConstants.CS_CONSUMER_NUM);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(shopId, brandId, dateType, dateTime)))
                {
                    String innerKey = userType + "_F_" + source;
                    if (next.get(innerKey) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(innerKey);

                        Object pid = aDB.get("pid");

                        //TODO pid应该是一个String数组，此处直接add应该是错误的！
                        result.add((String) pid);
                    }
                }
            }
        }

        return result;
    }

}
