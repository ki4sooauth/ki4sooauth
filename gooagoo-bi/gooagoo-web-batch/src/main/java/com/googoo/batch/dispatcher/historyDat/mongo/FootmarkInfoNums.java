package com.googoo.batch.dispatcher.historyDat.mongo;

import java.util.List;
import java.util.Set;

import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.gmongo.GridFSDao;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisListDao;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.mongodb.BasicDBObject;

/**
 * 客户足迹信息(人次)
 * @author zsl
 *
 */
@Engine(BatchTimeCnstants.redis2mongo)
public class FootmarkInfoNums implements Tyre
{
    private final RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.statistics_arriveNum);
    private final RedisListDao redisListDao = new RedisListDao(RedisServerConstants.statistics_arriveNum);
    private final GridFSDao gridFSDao = new GridFSDao(MongoConstants.MONGO_URL, MongoConstants.gridFSDB);
    private final MongoDao mongoDao_nums = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.footmarkDB, CollectionConstants.FM_FOOTMARK_NUMS);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 FootmarkInfoNums");
        //查询当天的Redis数据存入MongoDB
        Set<String> redisBaseKeySet = this.redisDatabase.keys("*_*Y*");
        for (String key : redisBaseKeySet)
        {
            if (!DayJudgeUtil.isToday(key))
            {
                String mongoId = "";
                String mongoKey = "";
                String pid = UUID.getUUID();
                List<String> redisNum = this.redisListDao.get(key);
                long pnum = redisNum.size();

                List<String> keys = StringUtils.split2List(key, "_");
                if (keys.size() == 3)
                {
                    mongoId = keys.get(0) + "_" + keys.get(keys.size() - 1);
                    mongoKey = keys.get(1);
                }
                else
                {
                    GooagooLog.warn("Redis数据库的key值不合法！");
                }
                BasicDBObject keyObj = new BasicDBObject();
                keyObj.put("_id", mongoId);

                BasicDBObject valueObj = new BasicDBObject();
                BasicDBObject contentObj = new BasicDBObject();
                contentObj.put("pnum", pnum);
                contentObj.put("pid", pid);
                valueObj.put(mongoKey, contentObj);

                this.mongoDao_nums.update(keyObj, new BasicDBObject().append("$set", valueObj));

                this.gridFSDao.save(redisNum, pid, pid);

                //this.redisDatabase.del(key);
            }
        }
    }

}