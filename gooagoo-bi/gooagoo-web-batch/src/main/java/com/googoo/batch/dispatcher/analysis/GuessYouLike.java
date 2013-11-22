package com.googoo.batch.dispatcher.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Engine(BatchTimeCnstants.everyHour)
public class GuessYouLike implements Tyre
{

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 GuessYouLike");
        // 每三天跑批一次，计算用户喜好的商品ID,优惠券ID，活动ID
        MongoDao sourceDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);
        //按用户ID分组
        Map<String, Integer> map = this.getCountMapByGroup(sourceDao, "userId", null);
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            this.guessYouLikeBatch(entry.getKey(), sourceDao, "goodsId");
            this.guessYouLikeBatch(entry.getKey(), sourceDao, "couponId");
            this.guessYouLikeBatch(entry.getKey(), sourceDao, "activityId");
        }
        //生成系统用户的喜欢
        this.guessYouLikeBatch("gooagoo", sourceDao, "goodsId");
        this.guessYouLikeBatch("gooagoo", sourceDao, "couponId");
        this.guessYouLikeBatch("gooagoo", sourceDao, "activityId");
    }

    /*
     * 猜你喜欢
     *  商品、优惠券、活动
     */
    private void guessYouLikeBatch(String userId, MongoDao sourceDao, String field)
    {
        MongoDao purposeDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_RECOMMEND);
        //select 品类ID,count(品类ID) from goodslike where userId='**' group by 品类ID
        DBObject cond = new BasicDBObject();
        cond.put("userId", new BasicDBObject("$ne", userId));
        Map<String, Integer> map = this.getCountMapByGroup(sourceDao, field, cond);

        DBObject beUpdate = new BasicDBObject();
        beUpdate.put("userId", userId);
        beUpdate.put("field", field);
        beUpdate.put(field, this.getTopByMap(map).toArray());
        beUpdate.put("timestamp", new Date().toString());
        purposeDao.update(new BasicDBObject().append("userId", userId).append("field", field), beUpdate);
    }

    private List<DBObject> getBrowseData(MongoDao dao, Date lastTime)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("timestamp", new BasicDBObject("$lte", lastTime));
        return dao.findByMap(map);
    }

    private void doDelOperation(String userId, Date lastTime)
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_RECOMMEND);
        DBObject likeInfo = dao.findById(userId);
        if (likeInfo != null)
        {
            //得到时间戳
            Date likeTime = (Date) likeInfo.get("timestamp");
            if (likeTime.before(lastTime))
            {
                //如果是上一次跑批的，删除
                DBObject dbDel = new BasicDBObject();
                dbDel.put("_id", userId);
                dao.delete(dbDel);
            }
        }
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

    /*    private ArrayList<Map.Entry<String, Integer>> sortMapByValue(Map<String, Integer> map)
        {
            ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
            {
                @Override
                public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
                {
                    return o2.getValue() - o1.getValue();
                }
            });
            return list;
        }*/

    private ArrayList<String> getTopByMap(Map<String, Integer> map)
    {
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
            {
                return o2.getValue() - o1.getValue();
            }
        });
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < (list.size() > 100 ? 100 : list.size()); i++)
        {
            if (list.get(i) == null)
            {
                break;
            }
            if (list.get(i).getKey() != null)
            {
                result.add(list.get(i).getKey());
            }
        }

        return result;
    }

    /*    private void pushOperation(ArrayList<Map.Entry<String, Integer>> list, MongoDao sourceDao, MongoDao purposeDao, String userId)
        {
            for (int i = 0; i < 50; i++)
            {
                //key: categoryId ; value : count
                Map.Entry<String, Integer> entry = list.get(i);
                String categoryId = entry.getKey();
                //select top 1 商品ID,count(商品ID) from goodslike where categoryId=** group by 商品ID order by count desc
                //select 商品ID,count(商品ID) from goodslike where categoryId=** and userId<>** group by 商品ID
                //TreeMap<String, Integer> goodsIdMap = this.getCountMapByGroup(sourceDao, "goodsId", new BasicDBObject().append("$ne", new BasicDBObject("userId", userId)).append("category", categoryId));
                //TreeMap<String, Integer> couponIdMap = this.getCountMapByGroup(sourceDao, "couponId", new BasicDBObject().append("$ne", new BasicDBObject("userId", userId)).append("category", categoryId));
                //TreeMap<String, Integer> activityIdMap = this.getCountMapByGroup(sourceDao, "activityId", new BasicDBObject().append("$ne", new BasicDBObject("userId", userId)).append("category", categoryId));

                DBObject beUpdate = new BasicDBObject();

                //beUpdate.put("$pushAll", new BasicDBObject("goodsId", this.getTopByMap(goodsIdMap)));
                //beUpdate.put("$pushAll", new BasicDBObject("couponId", this.getTopByMap(couponIdMap)));
                //beUpdate.put("$pushAll", new BasicDBObject("activityId", this.getTopByMap(activityIdMap)));
                //beUpdate.put("timestamp", new Date().toString());

                purposeDao.update(new BasicDBObject("_id", userId), beUpdate);
            }
        }*/

}
