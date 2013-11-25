package com.googoo.batch.dispatcher.historyDat.mongo;

import java.util.List;

import org.junit.Test;

import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.mongodb.DBObject;

public class ConsumerInfoCnumsTest
{

    @Test
    public void test()
    {
        ConsumerInfoCnums cnums = new ConsumerInfoCnums();
        cnums.run();
    }

    @Test
    public void watch()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.consumerDB, CollectionConstants.CS_CONSUMER_CNUMS);
        List<DBObject> list = dao.findAll();
        for (DBObject obj : list)
        {
            System.out.println(obj);
        }
    }

}