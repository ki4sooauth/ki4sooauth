package com.googoo.batch.dispatcher.historyDat.mongo;

import java.util.Set;

import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.mongodb.BasicDBObject;

@Engine(BatchTimeCnstants.redis2mongo)
public class CommodityInfoFile implements Tyre
{
    private final RedisSortedSetDao goodsSerialDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
    private final RedisSortedSetDao goodsCategoryDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);
    private final RedisSortedSetDao goodsBrandDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);

    private final MongoDao goodsSerial_file_dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.makefileDB, CollectionConstants.GOODSSERIAL_FILE_INFO);
    private final MongoDao goodsCategory_file_dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.makefileDB, CollectionConstants.GOODSCATEGORY_FILE_INFO);
    private final MongoDao goodsBrand_file_dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.makefileDB, CollectionConstants.GOODSBRAND_FILE_INFO);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 CommodityInfoFile");
        RedisSortedSetDao[] redisDaos = { this.goodsSerialDao, this.goodsCategoryDao, this.goodsBrandDao };
        MongoDao[] mongoDaos = { this.goodsSerial_file_dao, this.goodsCategory_file_dao, this.goodsBrand_file_dao };
        for (int i = 0; i < 3; i++)
        {
            Set<String> values = redisDaos[i].get("Interaction", 0, -1);
            for (String value : values)
            {
                if (value.matches(".*_.*[H]\\d+"))//统计小时的
                {
                    this.statistic(value, "H", redisDaos[i], mongoDaos[i]);
                }
                if (value.matches(".*_.*[D]\\d+")) //统计天的
                {
                    this.statistic(value, "D", redisDaos[i], mongoDaos[i]);
                }
                if (value.matches(".*_.*[M]\\d+")) //统计月的
                {
                    this.statistic(value, "M", redisDaos[i], mongoDaos[i]);
                }
                if (value.matches(".*_.*[Y]\\d+")) //统计年的
                {
                    this.statistic(value, "Y", redisDaos[i], mongoDaos[i]);
                }
            }
        }
    }

    private void statistic(String value, String dateType, RedisSortedSetDao redisDao, MongoDao mongoDao)
    {
        boolean flag = false;
        int lastIndexOf = value.lastIndexOf("_");
        String id = value.substring(0, lastIndexOf);
        String date = value.substring(lastIndexOf + 1, value.length());
        int score = redisDao.getScore("Interaction", value).intValue();

        StringBuffer _id = new StringBuffer();
        String[] ids = id.split("_");
        _id.append(ids[0]).append("_" + ids[1]).append("_" + ids[3]);

        if (ids.length == 4 && date.startsWith("Y")) //购买行为
        {
            _id.append("_" + "*").append("_" + "*");
            flag = true;
        }
        else if (ids.length == 5 && date.startsWith("Y")) //评论
        {
            _id.append("_" + "*").append(ids[4]);
            flag = true;
        }
        else if (ids.length == 6 && date.startsWith("Y")) //浏览、收藏
        {
            _id.append(ids[4]).append(ids[5]);
            flag = true;
        }
        _id.append("_" + dateType);

        if (flag)
        {
            BasicDBObject query = new BasicDBObject();
            query.put("_id", _id.toString());

            BasicDBObject obj = new BasicDBObject();
            if ("B".equals(ids[2]))
            {
                obj.put("browse." + date, score);
            }
            else if ("F".equals(ids[2]))
            {
                obj.put("collect." + date, score);
            }
            else if ("P".equals(ids[2]))
            {
                obj.put("pay." + date, score);
            }
            else if ("C".equals(ids[2]))
            {
                obj.put("comment." + date, score);
            }
            mongoDao.update(query, new BasicDBObject().append("$set", obj));
        }
    }
}
