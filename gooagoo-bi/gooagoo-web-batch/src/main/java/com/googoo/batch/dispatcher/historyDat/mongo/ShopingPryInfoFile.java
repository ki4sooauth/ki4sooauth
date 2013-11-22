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
public class ShopingPryInfoFile implements Tyre
{
    private final RedisSortedSetDao redisSortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_inquisitive);
    private final MongoDao shopingpry_file_dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.makefileDB, CollectionConstants.SHOPINGPRY_FILE_INFO);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 ShopingPryInfoFile");
        Set<String> values = this.redisSortedSetDao.get("Interaction", 0, -1);
        for (String value : values)
        {
            if (value.matches(".*_.*[H]\\d+"))//统计小时的
            {
                this.statistic(value, "H");
            }
            if (value.matches(".*_.*[D]\\d+")) //统计天的
            {
                this.statistic(value, "D");
            }
            if (value.matches(".*_.*[M]\\d+")) //统计月的
            {
                this.statistic(value, "M");
            }
            if (value.matches(".*_.*[Y]\\d+")) //统计年的
            {
                this.statistic(value, "Y");
            }
        }
    }

    private void statistic(String value, String dateType)
    {
        int lastIndexOf = value.lastIndexOf("_");
        String id = value.substring(0, lastIndexOf);
        String date = value.substring(lastIndexOf + 1, value.length());
        int score = this.redisSortedSetDao.getScore("Interaction", value).intValue();

        StringBuffer _id = new StringBuffer();
        String[] ids = id.split("_");
        _id.append(ids[0]).append("_" + ids[1]).append("_" + dateType);

        BasicDBObject query = new BasicDBObject();
        query.put("_id", _id.toString());

        BasicDBObject obj = new BasicDBObject();

        obj.put(date, score);

        this.shopingpry_file_dao.update(query, new BasicDBObject().append("$set", obj));
    }
}
