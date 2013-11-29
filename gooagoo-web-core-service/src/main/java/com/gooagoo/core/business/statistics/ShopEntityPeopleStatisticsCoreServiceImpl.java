package com.gooagoo.core.business.statistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.statistics.ShopEntityPeopleStatisticsCoreService;
import com.gooagoo.constants.CollectionConstants;
import com.gooagoo.constants.MongoConstants;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.gmongo.GridFSDao;
import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Service
public class ShopEntityPeopleStatisticsCoreServiceImpl implements ShopEntityPeopleStatisticsCoreService
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
    private String jointKeyForRedis(String shopEntityId, String dateType, String userType, Date dateTime)
    {
        //商家ID/实体店ID/区域ID_用户类型
        //商家ID/实体店ID/区域ID_用户类型_D日_H小时
        //商家ID/实体店ID/区域ID_用户类型_D日
        //商家ID/实体店ID/区域ID_用户类型_M月
        //商家ID/实体店ID/区域ID_用户类型_Y年

        //dateType Y M D H null

        DecimalFormat df = new DecimalFormat("00");
        Calendar time = Calendar.getInstance();

        time.setTime(dateTime);

        String year = String.valueOf(time.get(Calendar.YEAR));
        String month = df.format(time.get(Calendar.MONTH) + 1);
        String day = df.format(time.get(Calendar.DAY_OF_MONTH));
        String hour = df.format(time.get(Calendar.HOUR_OF_DAY));

        StringBuffer key = new StringBuffer(shopEntityId + "_" + userType);
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
     * 拼接Mongo的key
     * @param shopEntityId
     * @param dateType
     * @param dateTime
     * @return
     */
    private String jointKeyForMongo(String shopEntityId, String dateType, Date dateTime)
    {
        //商家ID/实体店ID/区域ID_时间类型

        StringBuffer key = new StringBuffer(shopEntityId);

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
    public int findEntityPeopleNum(String shopEntityId, String userType)
    {
        // 查询指定实体店店内人数
        int result = 0;

        //从redis中 查询
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        String key = shopEntityId + "_" + userType;
        result = (int) sortedSetDao.zcard(key);

        return result;
    }

    @Override
    public List<String> findEntityPeople(String shopEntityId, String userType)
    {
        // 查询指定实体店店内人群
        List<String> result = new ArrayList<String>();

        //redis 查询
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        String key = shopEntityId + "_" + userType;
        Set<String> set = sortedSetDao.get(key, 0, sortedSetDao.zcard(key));

        result.addAll(set);

        return result;
    }

    @Override
    public int findEntityAreaPeopleNum(String areaId, String userType)
    {
        // 查询实体店指定区域内人数
        int result = 0;

        //从redis中 查询
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        String key = areaId + "_" + userType;
        result = (int) sortedSetDao.zcard(key);

        return result;
    }

    @Override
    public List<String> findEntityAreaPeople(String areaId, String userType)
    {
        // 查询实体店指定区域内人群
        List<String> result = new ArrayList<String>();

        //redis 查询
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_in_shop);
        String key = areaId + "_" + userType;
        Set<String> set = sortedSetDao.get(key, 0, sortedSetDao.zcard(key));

        result.addAll(set);

        return result;
    }

    @Override
    public int findArriveEntityPeopleNum(String shopEntityId, String dateType, String userType, Date dateTime)
    {
        // 查询到达实体店人数
        int result = 0;
        if (this.isToday(dateTime))
        {
            // redis 查询到达商家人数
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_arriveNum);
            String key = this.jointKeyForRedis(shopEntityId, dateType, userType, dateTime);
            result = (int) sortedSetDao.zcard(key);
        }
        else
        {
            //从 Mongo 中查询
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.footmarkDB, CollectionConstants.FM_FOOTMARK_NUM);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(shopEntityId, dateType, dateTime)))
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
    public int findArriveEntityTimes(String shopEntityId, String dateType, String userType, Date dateTime)
    {
        // 查询到达实体店次数
        int result = 0;
        if (this.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_arrive);
            String key = this.jointKeyForRedis(shopEntityId, dateType, userType, dateTime);
            result = (int) sortedSetDao.zcard(key);
        }
        else
        {
            //从 Mongo 中查询
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.footmarkDB, CollectionConstants.FM_FOOTMARK_NUMS);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(shopEntityId, dateType, dateTime)))
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
    public List<String> findArriveEntityPeople(String shopEntityId, String dateType, String userType, Date dateTime)
    {
        // 查询到达实体店人群
        List<String> result = new ArrayList<String>();
        if (this.isToday(dateTime))
        {
            //redis 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_arrive);
            String key = this.jointKeyForRedis(shopEntityId, dateType, userType, dateTime);
            Set<String> set = sortedSetDao.get(key, 0, sortedSetDao.zcard(key));

            result.addAll(set);
        }
        else
        {
            //从Mongo中查
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.footmarkDB, CollectionConstants.FM_FOOTMARK_NUM);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(shopEntityId, dateType, dateTime)))
                {
                    if (next.get(userType) instanceof DBObject)
                    {
                        DBObject aDB = (DBObject) next.get(userType);

                        GridFSDao fsDao = new GridFSDao(MongoConstants.MONGO_URL, MongoConstants.gridFSDB);
                        result = fsDao.getData(aDB);
                        break;
                    }
                }
            }
        }

        return result;
    }

    @Override
    public int findArriveEntityAreaPeopleNum(String areaId, String dateType, String userType, Date dateTime)
    {
        // 查询到达指定区域人数
        int result = 0;
        if (this.isToday(dateTime))
        {
            // redis 查询到达商家人数
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_arrive);
            String key = this.jointKeyForRedis(areaId, dateType, userType, dateTime);
            result = (int) sortedSetDao.zcard(key);
        }
        else
        {
            //从 Mongo 中查询
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.footmarkDB, CollectionConstants.FM_FOOTMARK_NUM);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(areaId, dateType, dateTime)))
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
    public int findArriveEntityAreaTimes(String areaId, String dateType, String userType, Date dateTime)
    {
        // 查询到达指定区域次数
        int result = 0;
        if (this.isToday(dateTime))
        {
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_arriveNum);
            String key = this.jointKeyForRedis(areaId, dateType, userType, dateTime);
            result = (int) sortedSetDao.zcard(key);
        }
        else
        {
            //从 Mongo 中查询
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.footmarkDB, CollectionConstants.FM_FOOTMARK_NUMS);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(areaId, dateType, dateTime)))
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
    public List<String> findArriveEntityAreaPeople(String areaId, String dateType, String userType, Date dateTime)
    {
        // 查询到达指定区域人群
        List<String> result = new ArrayList<String>();
        if (this.isToday(dateTime))
        {
            //redis 查询
            RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_arrive);
            String key = this.jointKeyForRedis(areaId, dateType, userType, dateTime);
            Set<String> set = sortedSetDao.get(key, 0, sortedSetDao.zcard(key));

            result.addAll(set);
        }
        else
        {
            //从Mongo中查
            DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, MongoConstants.footmarkDB, CollectionConstants.FM_FOOTMARK_NUM);

            DBCursor cur = collection.find();
            while (cur.hasNext())
            {
                DBObject next = cur.next();
                Object keySource = next.get("_id");

                if (keySource.equals(this.jointKeyForMongo(areaId, dateType, dateTime)))
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

}
