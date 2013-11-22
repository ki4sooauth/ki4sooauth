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
 * 商品信息(人数)
 * @author zsl
 *
 */
@Engine(BatchTimeCnstants.redis2mongo)
public class CommodityInfoNum implements Tyre
{
    private final RedisDatabase goodsSerialBase = new RedisDatabase(RedisServerConstants.statistics_goodsSerial);
    private final RedisSortedSetDao goodsSerialDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
    private final RedisDatabase goodsCategoryBase = new RedisDatabase(RedisServerConstants.statistics_goodsCategory);
    private final RedisSortedSetDao goodsCategoryDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);
    private final RedisDatabase goodsBrandBase = new RedisDatabase(RedisServerConstants.statistics_goodsBrand);
    private final RedisSortedSetDao goodsBrandDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);

    private final GridFSDao gridFSDao = new GridFSDao(MongoConstants.MONGO_URL, MongoConstants.gridFSDB);
    private final MongoDao goodsSerialDao_num = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.GOODSSERIAL_NUM);
    private final MongoDao goodsCategoryDao_num = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.GOODSCATEGORY_NUM);
    private final MongoDao goodsBrandDao_num = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.GOODSBRAND_NUM);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 CommodityInfoNum");
        //查询当天的Redis数据存入MongoDB
        RedisDatabase[] redisBases = { this.goodsSerialBase, this.goodsCategoryBase, this.goodsBrandBase };
        RedisSortedSetDao[] redisDaos = { this.goodsSerialDao, this.goodsCategoryDao, this.goodsBrandDao };
        MongoDao[] mongoDaos = { this.goodsSerialDao_num, this.goodsCategoryDao_num, this.goodsBrandDao_num };

        for (int i = 0; i < 3; i++)
        {
            Set<String> areaInfoNumKeySet = redisBases[i].keys("*_*Y*");
            for (String key : areaInfoNumKeySet)
            {
                if (!DayJudgeUtil.isToday(key))
                {
                    String mongoId = "";
                    String mongoKey = "";
                    String pid = UUID.getUUID();
                    long pnum = redisDaos[i].zcard(key);

                    List<String> keys = StringUtils.split2List(key, "_");
                    if (keys.size() == 7)
                    {
                        mongoId = keys.get(0) + "_" + keys.get(1) + "_" + keys.get(keys.size() - 1);
                        mongoKey = keys.get(3) + "_" + keys.get(2) + "_" + keys.get(4) + "_" + keys.get(5);
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
                    mongoDaos[i].update(keyObj, new BasicDBObject().append("$set", valueObj));

                    Set<String> areaInfoNum = redisDaos[i].get(key, 0, -1);
                    this.gridFSDao.save(new ArrayList<String>(areaInfoNum), pid, pid);

                    //this.redisDatabase.del(key);
                }
            }
        }
    }

}
