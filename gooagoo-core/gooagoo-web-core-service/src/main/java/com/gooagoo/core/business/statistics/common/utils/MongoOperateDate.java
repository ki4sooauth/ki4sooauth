package com.gooagoo.core.business.statistics.common.utils;

import java.util.Date;
import java.util.List;

import com.gooagoo.constants.MongoConstants;
import com.gooagoo.gmongo.GridFSDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 此类是对 统计数据 中关于mongo的公共查询方式 的整理
 * @author Austin
 *
 */
public class MongoOperateDate
{
    /**
     * 查询指定集合中的 pnum值
     * @param collection
     * @param id
     * @param dateType
     * @param innerKey
     * @param dateTime
     * @return
     */
    public static int getPnumValue(DBCollection collection, String id, String dateType, String innerKey, Date dateTime)
    {
        int result = 0;
        DBCursor cur = collection.find();
        while (cur.hasNext())
        {
            DBObject next = cur.next();
            Object keySource = next.get("_id");

            if (keySource.equals(StatisticsDataUtil.jointIdForMongo(id, dateType, dateTime)))
            {
                if (next.get(innerKey) instanceof DBObject)
                {
                    DBObject aDB = (DBObject) next.get(innerKey);
                    result = (int) Double.parseDouble(aDB.get("pnum").toString());
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 查询指定集合中的pid值
     * @param collection
     * @param id
     * @param dateType
     * @param innerKey
     * @param dateTime
     * @return
     */
    public static String getPidValue(DBCollection collection, String id, String dateType, String innerKey, Date dateTime)
    {
        String result = null;
        DBCursor cur = collection.find();
        while (cur.hasNext())
        {
            DBObject next = cur.next();
            Object keySource = next.get("_id");
            if (keySource.equals(StatisticsDataUtil.jointIdForMongo(id, dateType, dateTime)))
            {
                if (next.get(innerKey) instanceof DBObject)
                {
                    DBObject aDB = (DBObject) next.get(innerKey);
                    result = (String) aDB.get("pid");
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 根据人群id查询人群中的所有用户id或mac
     * @param pid
     * @return
     */
    public static List<String> getGridFSValues(String pid)
    {
        GridFSDao gridFSDao = new GridFSDao(MongoConstants.MONGO_URL, MongoConstants.gridFSDB);

        DBObject query = new BasicDBObject();
        query.put("_id", pid);
        query.put("filename", pid);

        return gridFSDao.getData(query);
    }

    /**
     * 查询集合中的人群信息集合
     * @param collection
     * @param id
     * @param dateType
     * @param innerKey
     * @param dateTime
     * @return
     */
    public static List<String> getPidValuesInfo(DBCollection collection, String id, String dateType, String innerKey, Date dateTime)
    {
        String pidValue = getPidValue(collection, id, dateType, innerKey, dateTime);

        return getGridFSValues(pidValue);
    }
}
