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
 * 商品信息(人次)
 * @author zsl
 *
 */
@Engine(BatchTimeCnstants.redis2mongo)
public class CommodityInfoNums implements Tyre
{
    private final RedisSortedSetDao goodsSerialDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
    private final RedisSortedSetDao goodsCategoryDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);
    private final RedisSortedSetDao goodsBrandDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);

    private final MongoDao goodsSerialDao_nums = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.GOODSSERIAL_NUMS);
    private final MongoDao goodsCategoryDao_nums = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.GOODSCATEGORY_NUMS);
    private final MongoDao goodsBrandDao_nums = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.GOODSBRAND_NUMS);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 CommodityInfoNums");
        //查询当天的Redis数据存入MongoDB
        RedisSortedSetDao[] redisDaos = { this.goodsSerialDao, this.goodsCategoryDao, this.goodsBrandDao };
        MongoDao[] mongoDaos = { this.goodsSerialDao_nums, this.goodsCategoryDao_nums, this.goodsBrandDao_nums };

        for (int i = 0; i < 3; i++)
        {
            Set<String> values = redisDaos[i].get("Interaction", 0, -1);
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
                    Double pnum = redisDaos[i].getScore("Interaction", value);
                    List<String> k = StringUtils.split2List(value, "_");
                    if (k.size() == 7)
                    {
                        mongoId = k.get(0) + "_" + k.get(1) + "_" + k.get(k.size() - 1);
                        mongoKey = k.get(3) + "_" + k.get(2) + "_" + k.get(4) + "_" + k.get(5);
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

                    mongoDaos[i].update(keyObj, new BasicDBObject().append("$set", valueObj));

                    //this.redisSortedSetDao.delElement("Interaction", value);
                }
            }
        }
    }

}
