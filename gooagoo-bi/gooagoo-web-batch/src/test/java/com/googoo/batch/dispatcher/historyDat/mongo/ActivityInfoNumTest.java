package com.googoo.batch.dispatcher.historyDat.mongo;

import java.util.List;

import org.junit.Test;

import com.gooagoo.gmongo.GridFSDao;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ActivityInfoNumTest
{

    @Test
    public void test()
    {
        ActivityInfoNum num = new ActivityInfoNum();
        num.run();
    }

    @Test
    public void watchMongo()
    {
        //GridFSDao gridFSDao = new GridFSDao(MongoConstants.MONGO_URL, MongoConstants.gridFSDB);
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.activityDB, CollectionConstants.ACT_ACTIVITY_NUM);
        List<DBObject> list = dao.findAll();
        for (DBObject obj : list)
        {
            System.out.println(obj);
        }
    }

    @Test
    public void delMaongo()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.activityDB, CollectionConstants.ACT_ACTIVITY_NUM);
        List<DBObject> list = dao.findAll();
        for (DBObject obj : list)
        {
            dao.delete(obj);
        }
    }

    @Test
    public void watchFS()
    {
        GridFSDao dao = new GridFSDao(MongoConstants.MONGO_URL, MongoConstants.gridFSDB);
        List<String> data = dao.getData(new BasicDBObject().append("filename", "1840SC5TID24GR30KH62O3P86R6OSLKC"));
        for (String s : data)
        {
            System.out.println(s);
        }

    }

}
