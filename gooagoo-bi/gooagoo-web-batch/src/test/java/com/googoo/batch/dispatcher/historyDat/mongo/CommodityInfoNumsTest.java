package com.googoo.batch.dispatcher.historyDat.mongo;

import java.util.List;

import org.junit.Test;

import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.mongodb.DBObject;

public class CommodityInfoNumsTest
{

    @Test
    public void test()
    {
        CommodityInfoNums nums = new CommodityInfoNums();
        nums.run();
    }

    @Test
    public void watchMongo()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.commodityDB, CollectionConstants.GOODSSERIAL_NUMS);
        List<DBObject> list = dao.findAll();
        for (DBObject obj : list)
        {
            System.out.println(obj);
        }
    }

}
