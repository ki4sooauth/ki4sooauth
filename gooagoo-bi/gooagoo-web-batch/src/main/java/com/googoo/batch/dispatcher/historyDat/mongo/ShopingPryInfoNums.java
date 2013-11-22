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
 * 购好奇信息(人次)
 * @author zsl
 *
 */
@Engine(BatchTimeCnstants.redis2mongo)
public class ShopingPryInfoNums implements Tyre
{

    private final RedisSortedSetDao redisSortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_inquisitive);
    private final MongoDao mongoDao_num = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.shopingPryDB, CollectionConstants.SP_SHOPPING_NUMS);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 ShopingPryInfoNums");
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
                List<String> k = StringUtils.split2List(value, "_");
                if (k.size() == 3)
                {
                    mongoId = k.get(0) + "_" + k.get(k.size() - 1);
                    mongoKey = k.get(1);
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
                valueObj.put(mongoKey, contentObj);

                this.mongoDao_num.update(keyObj, new BasicDBObject().append("$set", valueObj));

                //this.redisSortedSetDao.delElement("Interaction", value);
            }
        }
    }

}
