package com.gooagoo.core.business.statistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.gooagoo.api.business.core.statistics.ExchangeStatisticCoreService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ExchangeStatisticCoreServiceImpl implements ExchangeStatisticCoreService
{

    @Override
    public int marketingTimes(String marketingId)
    {
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_integral);
        Double score = sortedSetDao.getScore(marketingId, "score");
        return score.intValue();
    }

    @Override
    public int couponExchangeTimes(String couponId, String userType, String dateType, Date dateTime)
    {
        // 查询优惠凭证兑换次数
        int result = 0;
        if (this.isToday(dateTime))
        {
            //从redis中 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);
            Set<String> set = sortedSetDao.get("Interaction", 0, sortedSetDao.zcard("Interaction"));

            String valueSource = this.jointValueForRedis(couponId, "E", userType, dateType, dateTime);

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
    public List<String> couponExchangePeople(String couponId, String userType, String dateType, Date dateTime)
    {
        // 查询优惠凭证兑换人群
        List<String> result = new ArrayList<String>();
        if (this.isToday(dateTime))
        {
            //redis 查询商家所有实体店店内人群
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);
            String key = this.jointKeyForRedis(couponId, "E", dateType, userType, dateTime);
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
    public int goodsExchangeTimes(String goodsId, String userType, String dateType, Date dateTime)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<String> goodsExchangePeople(String goodsId, String userType, String dateType, Date dateTime)
    {
        // TODO Auto-generated method stub
        return null;
    }

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
     * 拼接value
     * @param toolId
     * @param type
     * @param userType
     * @param dateType
     * @param dateTime
     * @return
     */
    private String jointValueForRedis(String toolId, String type, String userType, String dateType, Date dateTime)
    {
        //服务工具ID_浏览(B)/使用(U)_用户类型
        //服务工具ID_浏览(B)/使用(U)_用户类型_D日_H小时
        //服务工具ID_浏览(B)/使用(U)_用户类型_D日
        //服务工具ID_浏览(B)/使用(U)_用户类型_W周
        //服务工具ID_浏览(B)/使用(U)_用户类型_M月
        //服务工具ID_浏览(B)/使用(U)_用户类型_Y年

        StringBuffer value = new StringBuffer();
        value.append(toolId);
        value.append("_" + type + "_");

        DecimalFormat df = new DecimalFormat("00");
        Calendar time = Calendar.getInstance();

        time.setTime(dateTime);

        String year = String.valueOf(time.get(Calendar.YEAR));
        String month = df.format(time.get(Calendar.MONTH) + 1);
        String day = df.format(time.get(Calendar.DAY_OF_MONTH));
        String hour = df.format(time.get(Calendar.HOUR_OF_DAY));

        if ("Y".equals(dateType))
        {
            value.append("_Y" + year);
        }
        else if ("M".equals(dateType))
        {
            value.append("_M" + month);
        }
        else if ("D".equals(dateType))
        {
            value.append("_D" + day);
        }
        else if ("H".equals(dateType))
        {
            value.append("_D" + day + "_H" + hour);
        }
        else
        {
        }

        return value.toString();
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

    /**
     * 拼接redis的key值
     * @param shopId
     * @param dateType
     * @param userType
     * @param dateTime
     * @return
     */
    private String jointKeyForRedis(String couponId, String type, String userType, String dateType, Date dateTime)
    {
        //服务工具ID_浏览(B)/使用(U)_用户类型
        //服务工具ID_浏览(B)/使用(U)_用户类型_D日_H小时
        //服务工具ID_浏览(B)/使用(U)_用户类型_D日
        //服务工具ID_浏览(B)/使用(U)_用户类型_W周
        //服务工具ID_浏览(B)/使用(U)_用户类型_M月
        //服务工具ID_浏览(B)/使用(U)_用户类型_Y年

        //dateType Y M D H null

        DecimalFormat df = new DecimalFormat("00");
        Calendar time = Calendar.getInstance();

        time.setTime(dateTime);

        String year = String.valueOf(time.get(Calendar.YEAR));
        String month = df.format(time.get(Calendar.MONTH) + 1);
        String day = df.format(time.get(Calendar.DAY_OF_MONTH));
        String hour = df.format(time.get(Calendar.HOUR_OF_DAY));

        StringBuffer key = new StringBuffer(couponId + "_" + type + "_" + userType);
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

}
