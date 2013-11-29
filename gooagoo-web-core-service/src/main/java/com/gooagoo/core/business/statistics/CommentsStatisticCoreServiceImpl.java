package com.gooagoo.core.business.statistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.gooagoo.api.business.core.statistics.CommentsStatisticCoreService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class CommentsStatisticCoreServiceImpl implements CommentsStatisticCoreService
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

    /**
     * 拼接Mongo的key
     * @param shopId
     * @param dateType
     * @param dateTime
     * @return
     */
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
    public String getGoodsGrade(String goodsId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int goodsCommentTimes(String shopId, String goodsSerialNo, String dateType, String userType, Date dateTime, String source)
    {
        // 查询商品评论次数
        int result = 0;
        if (this.isToday(dateTime))
        {
            // redis 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);

            Set<String> set = sortedSetDao.get("Interaction", 0, sortedSetDao.zcard("Interaction"));

            String valueSource = this.jointKeyForRedis(shopId, goodsSerialNo, "C", dateType, userType, dateTime, source);

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
                    String innerKey = userType + "_C_" + source;
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
    public List<String> goodsCommentPeople(String shopId, String goodsSerialNo, String dateType, String userType, Date dateTime, String source)
    {
        // TODO 查询商品评论人群
        List<String> result = new ArrayList<String>();
        if (this.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
            String key = this.jointKeyForRedis(shopId, goodsSerialNo, "C", dateType, userType, dateTime, source);
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
                    String innerKey = userType + "_C_" + source;
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
    public int categoryCommentTimes(String shopId, String categoryId, String dateType, String userType, Date dateTime, String source)
    {
        // 查询品类评论次数
        int result = 0;
        if (this.isToday(dateTime))
        {
            // redis 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);

            Set<String> set = sortedSetDao.get("Interaction", 0, sortedSetDao.zcard("Interaction"));

            String valueSource = this.jointKeyForRedis(shopId, categoryId, "C", dateType, userType, dateTime, source);

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

                if (keySource.equals(this.jointKeyForMongo(shopId, categoryId, dateType, dateTime)))
                {
                    //innerKey 用户类型_行为类型_渠道类型_来源类型
                    String innerKey = userType + "_C_" + source;
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
    public List<String> categoryCommentPeople(String shopId, String categoryId, String dateType, String userType, Date dateTime, String source)
    {
        // TODO 查询品类评论人群
        List<String> result = new ArrayList<String>();
        if (this.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);
            String key = this.jointKeyForRedis(shopId, categoryId, "C", dateType, userType, dateTime, source);
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

                if (keySource.equals(this.jointKeyForMongo(shopId, categoryId, dateType, dateTime)))
                {
                    String innerKey = userType + "_C_" + source;
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
    public int brandCommentTimes(String shopId, String brandId, String dateType, String userType, Date dateTime, String source)
    {
        // 查询品牌评论次数
        int result = 0;
        if (this.isToday(dateTime))
        {
            // redis 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);

            Set<String> set = sortedSetDao.get("Interaction", 0, sortedSetDao.zcard("Interaction"));

            String valueSource = this.jointKeyForRedis(shopId, brandId, "C", dateType, userType, dateTime, source);

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

                if (keySource.equals(this.jointKeyForMongo(shopId, brandId, dateType, dateTime)))
                {
                    //innerKey 用户类型_行为类型_渠道类型_来源类型
                    String innerKey = userType + "_C_" + source;
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
    public List<String> brandCommentPeople(String shopId, String brandId, String dateType, String userType, Date dateTime, String source)
    {
        // TODO 查询品牌评论次数
        List<String> result = new ArrayList<String>();
        if (this.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);
            String key = this.jointKeyForRedis(shopId, brandId, "C", dateType, userType, dateTime, source);
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
                    String innerKey = userType + "_C_" + source;
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
