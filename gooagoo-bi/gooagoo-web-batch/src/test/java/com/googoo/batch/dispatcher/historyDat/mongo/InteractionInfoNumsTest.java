package com.googoo.batch.dispatcher.historyDat.mongo;

import java.util.List;

import org.junit.Test;

import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.mongodb.DBObject;

public class InteractionInfoNumsTest
{

    @Test
    public void test()
    {
        InteractionInfoNums nums = new InteractionInfoNums();
        nums.run();
    }

    @Test
    public void watchMongo()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.interactionDB, CollectionConstants.IA_INTERACTION_NUMS);

        MongoDao dao1 = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.shopingPryDB, CollectionConstants.SP_SHOPPING_NUMS);

        List<DBObject> list = dao1.findAll();
        for (DBObject obj : list)
        {
            //dao.delete(obj);
            System.out.println(obj);
        }
    }

}
