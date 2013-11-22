package com.googoo.batch.dispatcher.historyDat.mongo;

import java.util.List;

import org.junit.Test;

import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.mongodb.DBObject;

public class ActivityInfoNumsTest
{

    @Test
    public void test()
    {
        ActivityInfoNums nums = new ActivityInfoNums();
        nums.run();
    }

    @Test
    public void watchMongo()
    {
        //GridFSDao gridFSDao = new GridFSDao(MongoConstants.MONGO_URL, MongoConstants.gridFSDB);
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.activityDB, CollectionConstants.ACT_ACTIVITY_NUMS);
        List<DBObject> list = dao.findAll();
        for (DBObject obj : list)
        {
            System.out.println(obj);
        }

    }

}
