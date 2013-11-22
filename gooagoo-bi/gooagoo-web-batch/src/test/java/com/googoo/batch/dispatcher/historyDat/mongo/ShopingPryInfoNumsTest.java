package com.googoo.batch.dispatcher.historyDat.mongo;

import java.util.List;

import org.junit.Test;

import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.mongodb.DBObject;

public class ShopingPryInfoNumsTest
{

    @Test
    public void test()
    {
        ShopingPryInfoNums nums = new ShopingPryInfoNums();
        nums.run();
    }

    @Test
    public void watchMongo()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.shopingPryDB, CollectionConstants.SP_SHOPPING_NUMS);
        List<DBObject> list = dao.findAll();
        for (DBObject obj : list)
        {
            System.out.println(obj);
        }
    }

}
