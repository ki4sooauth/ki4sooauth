package com.googoo.batch.dispatcher.historyDat.mongo;

import java.util.List;
import java.util.Set;

import com.gooagoo.common.utils.StringUtils;
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

/**
 * 商家用户信息(人次)
 * @author zsl
 *
 */
@Engine(BatchTimeCnstants.redis2mongo)
public class ShopUserInfoNums implements Tyre
{
    private final RedisSortedSetDao redisSortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_member);
    private final MongoDao mongoDao_num = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.shopUserDB, CollectionConstants.SU_SHOPUSER_NUMS);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 ShopUserInfoNums");
        //查询当天的Redis数据存入MongoDB
        Set<String> values = this.redisSortedSetDao.get("Interaction", 0, -1);
        for (String value : values)
        {
            if (!value.matches(".*_.*[Y]\\d+.*"))
            {
                continue;
            }
            if (!DayJudgeUtil.isToday(value))
            {
                String mongoId = "";
                String mongoKey = "";
                Double pnum = this.redisSortedSetDao.getScore("Interaction", value);
                List<String> keys = StringUtils.split2List(value, "_");
                if (keys.size() >= 2)
                {
                    mongoId = keys.get(0) + "_" + keys.get(keys.size() - 1);
                    for (int i = 1; i < keys.size() - 1; i++)
                    {
                        mongoKey = mongoKey + "_" + keys.get(i);
                    }
                }
                else
                {
                    GooagooLog.warn("Redis数据库的key值不合法！");
                }
                BasicDBObject dbObject = new BasicDBObject();
                BasicDBObject dbObject1 = new BasicDBObject();
                dbObject1.put("pnum", pnum);
                dbObject.put("_id", mongoId);
                dbObject.put(mongoKey, dbObject1);
                this.mongoDao_num.insert(dbObject);
                //删除当天数据
                //this.redisSortedSetDao.delElement("Interaction", value);
            }
        }
    }

}
