package com.googoo.batch.dispatcher.historyDat.mongo;

import java.util.ArrayList;
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
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.mongodb.BasicDBObject;

/**
 * 活动信息(人数)
 * @author zsl
 *
 */
@Engine(BatchTimeCnstants.redis2mongo)
public class ActivityInfoNum implements Tyre
{
    private final RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.statistics_activity);
    private final RedisSortedSetDao redisSortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_activity);
    private final GridFSDao gridFSDao = new GridFSDao(MongoConstants.MONGO_URL, MongoConstants.gridFSDB);
    private final MongoDao mongoDao_num = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.activityDB, CollectionConstants.ACT_ACTIVITY_NUM);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 ActivityInfoNum");
        //查询当天的Redis数据存入MongoDB
        Set<String> areaInfoNumKeySet = this.redisDatabase.keys("*_*Y*");
        for (String key : areaInfoNumKeySet)
        {
            if (!DayJudgeUtil.isToday(key))
            {
                String mongoId = "";
                String mongoKey = "";
                String pid = UUID.getUUID();
                long pnum = this.redisSortedSetDao.zcard(key);

                List<String> keys = StringUtils.split2List(key, "_");
                if (keys.size() == 6)
                {
                    mongoId = keys.get(0) + "_" + keys.get(keys.size() - 1);
                    mongoKey = keys.get(2) + "_" + keys.get(1) + "_" + keys.get(3) + "_" + keys.get(4);
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

                this.mongoDao_num.update(keyObj, new BasicDBObject().append("$set", valueObj));

                Set<String> areaInfoNum = this.redisSortedSetDao.get(key, 0, -1);
                this.gridFSDao.save(new ArrayList<String>(areaInfoNum), pid, pid);

                //this.redisDatabase.del(key);
            }
        }
    }
}
