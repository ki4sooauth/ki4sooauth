package com.googoo.batch.dispatcher.analysis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.googoo.batch.utils.Timestamp;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class GuessYouLikeTest
{

    @Test
    public void test()
    {
        //fail("Not yet implemented");
        GuessYouLike like = new GuessYouLike();
        like.run();
    }

    @Test
    public void watchSource()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);
        List<DBObject> list = dao.findAll();
        for (DBObject obj : list)
        {
            System.out.println(obj);
        }

        //        System.out.println("-----------------");
        //
        //        Date lastTime = Timestamp.lastTime(Timestamp.GUESS_YOU_LIKE);
        //        System.out.println(lastTime);
        //        Map<String, Object> map = new HashMap<String, Object>();
        //        map.put("timestamp", new BasicDBObject("$lte", lastTime));
        //        //dao.findByCondition(dbObject, clazz);
        //        List<DBObject> list2 = dao.findByMap(map);
        //        for (DBObject obj : list2)
        //        {
        //            System.out.println(obj);
        //        }

    }

    @Test
    public void watchPurpose()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_RECOMMEND);
        List<DBObject> list = dao.findAll();
        for (DBObject obj : list)
        {
            System.out.println(obj);
        }
    }

    @Test
    public void test1()
    {
        MongoDao sourceDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);
        String userId = "gooagoo";
        DBObject cond = new BasicDBObject();
        cond.put("userId", new BasicDBObject("$ne", userId));
        Map<String, Integer> map = this.getCountMapByGroup(sourceDao, "goodsId", cond);
        System.out.println(map);
    }

    @Test
    public void groupByUserId()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);

        Date lastTime = Timestamp.lastTime(Timestamp.GUESS_YOU_LIKE);
        System.out.println(lastTime);
        DBObject cond = new BasicDBObject();
        cond.put("timestamp", new BasicDBObject("$lte", lastTime));

        Map<String, Integer> map = this.getCountMapByGroup(dao, "userId", cond);

        System.out.println(map);
    }

    private Map<String, Integer> getCountMapByGroup(MongoDao dao, String key, DBObject cond)
    {
        String reduce = "function(doc, aggr){aggr.count += 1;}";
        DBObject keyDB = new BasicDBObject();
        keyDB.put(key, true);
        BasicDBList dblist = dao.group(keyDB, cond, new BasicDBObject().append("count", 0), reduce);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (Object obj : dblist)
        {
            BasicDBObject dbobj = (BasicDBObject) obj;
            String keyValue = (String) dbobj.get(key);
            Double coun = Double.parseDouble(dbobj.get("count").toString());
            Integer count = coun.intValue();
            if (keyValue != null)
            {
                map.put(keyValue, count);
            }
        }
        return map;
    }
}
