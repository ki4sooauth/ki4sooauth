package com.googoo.batch.dispatcher.historyDat.makefile;

import org.junit.Test;

import com.gooagoo.gmongo.MongoDBUtils;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoTest
{
    @Test
    public void add()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, "test", "test1");
        BasicDBObject query = new BasicDBObject();
        query.put("_id", "id_other");
        DBObject object = dao.findByDbObject(query);
        if (object != null)
        {
            Object value = object.get("browse");
            if (value != null)
            {
                BasicDBObject objValue = (BasicDBObject) value;
                Object num = objValue.get("Y2013M10D21");
                if (num != null)
                {
                    int pnum = Integer.parseInt(num.toString());
                    if (pnum != 15)
                    {
                        BasicDBObject obj = new BasicDBObject();
                        obj.put("Y2013M10D21", 15);
                        dao.update(objValue, new BasicDBObject().append("$set", obj));
                    }
                }
                else
                {
                    BasicDBObject obj = new BasicDBObject();
                    obj.put("Y2013M10D21", 15);
                    dao.update(objValue, new BasicDBObject().append("$set", obj));
                }
            }
            Object num = object.get("Y2013M10D17H15");
            if (num != null)
            {
                int pnum = Integer.parseInt(num.toString());
                if (pnum != 15)
                {
                    BasicDBObject obj = new BasicDBObject();
                    obj.put("Y2013M10D17H15", 15);
                    dao.update(query, new BasicDBObject().append("$set", obj));
                }
            }
            else
            {
                BasicDBObject obj = new BasicDBObject();
                obj.put("Y2013M10D17H15", 15);
                dao.update(query, new BasicDBObject().append("$set", obj));
            }
        }
        else
        {
            BasicDBObject obj = new BasicDBObject();
            obj.put("_id", "id_other");
            BasicDBObject b = new BasicDBObject();
            b.put("Y2013M10D21", 15);
            obj.put("browse", b);
            System.out.println(obj);
            dao.save(obj);
        }

    }

    @Test
    public void doc()
    {

        BasicDBObject obj = new BasicDBObject();
        obj.put("_id", "id_other");

        BasicDBObject b = new BasicDBObject();
        b.put("Y2013M10D21", 15);

        obj.put("browse", b);

        System.out.println(obj);
    }

    @Test
    public void find()
    {
        DBCollection collection = MongoDBUtils.getDBCollection(MongoConstants.MONGO_URL, "test", "test1");
        BasicDBObject query = new BasicDBObject();

        BasicDBList querys = new BasicDBList();

        BasicDBObject id = new BasicDBObject();
        id.put("_id", "id_other");

        BasicDBObject browse = new BasicDBObject();
        BasicDBObject nums = new BasicDBObject();
        nums.put("Y2013M10D21", 15);
        browse.put("browse", nums);

        querys.add(id);
        querys.add(browse);

        query.put("$and", querys);

        DBCursor find = collection.find(query);
        //DBObject object = dao.findByDbObject(browse);
        while (find.hasNext())
        {
            System.out.println(find.next());
        }

        //System.out.println(browse);

    }

    /**
     * 插入数组类型
     */
    @Test
    public void insert()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, "test", "test1");
        BasicDBObject id = new BasicDBObject();
        id.put("_id", "id_other");

        BasicDBObject browses = new BasicDBObject();
        BasicDBObject browse = new BasicDBObject();
        BasicDBObject nums = new BasicDBObject();
        nums.put("Y2013M10D18", 20);
        browse.put("browse", nums);
        browses.put("$push", browse);

        dao.update(id, browses);
    }

    /**
     * 插入内嵌集合
     */
    @Test
    public void insert2()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, "test", "test2");

        BasicDBObject id = new BasicDBObject();
        id.put("_id", "id_other");

        BasicDBObject browses = new BasicDBObject();
        BasicDBObject browse = new BasicDBObject();
        browse.put("browse.Y2013M10D17", 45);
        browses.put("$set", browse);

        dao.update(id, browses);
    }

    @Test
    public void update()
    {
        MongoDao dao = new MongoDao(MongoConstants.MONGO_URL, "test", "test1");

        BasicDBObject query = new BasicDBObject();

        BasicDBList querys = new BasicDBList();

        BasicDBObject id = new BasicDBObject();
        id.put("_id", "id_other");

        BasicDBObject browse = new BasicDBObject();
        BasicDBObject nums = new BasicDBObject();
        nums.put("Y2013M10D17", 24);
        browse.put("browse", nums);

        querys.add(id);
        querys.add(browse);

        query.put("$and", querys);

        BasicDBObject browse_n = new BasicDBObject();
        BasicDBObject nums_n = new BasicDBObject();
        nums_n.put("Y2013M10D17", 24);
        browse_n.put("browse", nums);

        dao.update(query, new BasicDBObject().append("$set", browse_n));
    }
}
