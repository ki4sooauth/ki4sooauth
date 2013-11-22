package com.gooagoo.gmongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * mongodb操作类
 * @author 王宇
 *
 */
public class MongoDao
{
    private final Logger log = Logger.getLogger("mongo_log");
    private final DBCollection collection;

    public MongoDao(String host, String dbName, String collectionName)
    {
        this.collection = MongoDBUtils.getDBCollection(host, dbName, collectionName);
    }

    /**
     * 保存方法。如果存在则更新
     * 
     * @param object
     * @return
     */
    public void saveEntity(Object object)
    {
        DBObject dbObject = MongoDBUtils.toDBObject(object);
        this.collection.save(dbObject);
    }

    public void save(DBObject dbObject)
    {
        this.collection.save(dbObject);
    }

    /**
     * 一次插入多个文档对象
     * 
     * @param object
     * @return
     */
    public void insertList(List<?> list)
    {
        List<DBObject> dbList = new ArrayList<DBObject>();
        if (list == null || list.isEmpty())
        {
            this.log.error("insert: 插入对象为 NULL");
        }
        for (Object obj : list)
        {
            DBObject dbObject = MongoDBUtils.toDBObject(obj);
            dbList.add(dbObject);
        }
        this.collection.insert(dbList);
    }

    /**
     * 插入文档对象
     * 
     * @param object
     * @return
     */
    public void insertEntity(Object object)
    {
        DBObject dbObject = MongoDBUtils.toDBObject(object);
        this.collection.insert(dbObject);
    }

    /**
     * 原生dbObject插入
     * 
     * @param object
     * @return
     */
    public void insert(BasicDBObject... dbObject)
    {
        this.collection.insert(dbObject);
    }

    /**
     * 插入或者更新文档对象
     * 
     * @param key
     * @param obj
     * @return
     */
    public void insertUpdate(String key, BasicDBObject obj)
    {

        BasicDBObject q = new BasicDBObject();
        q.put("_id", key);
        obj.put("_id", key);
        this.collection.update(q, obj, true, false);
    }

    /**
     * 插入或者更新文档对象
     * 
     * @param key
     * @param obj
     * @return
     */
    public void insertUpdateEntity(String key, Object obj)
    {

        BasicDBObject q = new BasicDBObject();
        q.put("_id", key);
        DBObject o = MongoDBUtils.toDBObject(obj);
        o.put("_id", key);
        this.collection.update(q, o, true, false);
    }

    /**
     * 按条件查询
     * 
     * @param dbObject
     */
    public DBObject findByDbObject(BasicDBObject dbObject)
    {
        DBObject findOne = this.collection.findOne(dbObject);
        return findOne;
    }

    /**
     * 按条件查询
     * 
     * @param dbObject
     */
    public boolean isIdExist(String id)
    {
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.put("_id", id);
        DBObject findOne = this.collection.findOne(dbObject);
        if (findOne != null)
        {
            return true;
        }
        return false;
    }

    /**
     * 更新文档对象
     * 
     * @param query 查询文档条件
     * @param dbObject 要修改的文档值
     * @return
     * 注：更新部分文档 BasicDBObject basicDBObject = new BasicDBObject().append("$set", new BasicDBObject("newKey", "newValue"));
     */
    public void update(DBObject query, DBObject dbObject)
    {
        this.collection.update(query, dbObject, true, false);
    }

    /**
     * 更新文档对象
     * 
     * @param qObj
     * @param obj
     * @return
     */
    public void updateEntity(Object qObj, Object obj)
    {
        DBObject q = MongoDBUtils.toDBObject(qObj);
        DBObject o = MongoDBUtils.toDBObject(obj);
        this.collection.update(q, o, true, false);
    }

    /**
     * 删除文档对象
     * 
     * @param obj
     * @return
     */
    public void delete(DBObject dbObject)
    {
        this.collection.remove(dbObject);
    }

    /**
     * 删除文档对象
     * 
     * @param obj
     * @return
     */
    public void deleteEntity(Object obj)
    {
        DBObject o = MongoDBUtils.toDBObject(obj);
        this.collection.remove(o);
    }

    /**
     * 查询所有
     * 
     * @param clazz
     * @return
     */
    public <T> List<T> findAll(Class<T> clazz)
    {
        List<DBObject> array = this.collection.find().toArray();
        List<T> object = MongoDBUtils.toList(array, clazz);
        return object;
    }

    public List<DBObject> findAll()
    {
        return this.collection.find().toArray();
    }

    public <T> List<T> findByMap(Map<String, Object> map, Class<T> clazz)
    {
        DBObject dbObject = MongoDBUtils.toDBObject(map);
        List<DBObject> array = this.collection.find(dbObject).toArray();
        List<T> object = MongoDBUtils.toList(array, clazz);
        return object;
    }

    public List<DBObject> findByMap(Map<String, Object> map)
    {
        DBObject dbObject = MongoDBUtils.toDBObject(map);
        return this.collection.find(dbObject).toArray();
    }

    public <T> List<T> basicFindByCondition(Object obj, Class<T> clazz)
    {
        DBObject dbObject = MongoDBUtils.toDBObject(obj);
        List<DBObject> array = this.collection.find(dbObject).toArray();
        List<T> object = MongoDBUtils.toList(array, clazz);
        return object;
    }

    public <T> List<T> findByCondition(DBObject dbObject, Class<T> clazz)
    {
        List<DBObject> array = this.collection.find(dbObject).toArray();
        List<T> object = MongoDBUtils.toList(array, clazz);
        return object;
    }

    public <T> T findOne(Class<T> clazz)
    {
        DBObject findOne = this.collection.findOne();
        List<DBObject> array = new ArrayList<DBObject>();
        array.add(findOne);
        List<T> object = MongoDBUtils.toList(array, clazz);
        return object.isEmpty() ? null : object.get(0);
    }

    public <T> T findOne(Object obj)
    {
        DBObject dbObject = MongoDBUtils.toDBObject(obj);
        DBObject findOne = this.collection.findOne(dbObject);
        List<DBObject> array = new ArrayList<DBObject>();
        array.add(findOne);
        @SuppressWarnings("unchecked")
        List<T> object = (List<T>) MongoDBUtils.toList(array, obj.getClass());
        return object.isEmpty() ? null : object.get(0);
    }

    public DBObject findById(String id)
    {
        DBObject idDBObj = new BasicDBObject();
        idDBObj.put("_id", id);
        List<DBObject> list = this.collection.find(idDBObj).toArray();
        return list.isEmpty() ? null : list.get(0);
    }

    public long count(Object obj)
    {
        DBObject dbObject = MongoDBUtils.toDBObject(obj);
        long count = this.collection.count(dbObject);
        return count;
    }

    /**
     * 
     * @param key 分组关键字
     * @param cond 查询条件
     * @param initial 定义一个变量初始值用于reduce函数
     * @param reduce reduce函数
     * @return
     * 例：
     * String reduce = "function(doc, aggr){aggr.count += 1;}";
        MongoDao mongoDao = new MongoDao("mongodb_test1", "t", "A");
        BasicDBObject key = new BasicDBObject();
        key.put("userId", true);
        BasicDBObject cond = new BasicDBObject();
        cond.append("shopId", "1");
        BasicDBObject initial = new BasicDBObject();
        initial.append("count", 0);
        BasicDBList list = mongoDao.group(key, cond, initial, reduce);
        for (Object object : list)
        {
            System.out.println(object);
        }
     */
    public BasicDBList group(DBObject key, DBObject cond, DBObject initial, String reduce)
    {
        BasicDBList group = (BasicDBList) this.collection.group(key, cond, initial, reduce);
        return group;
    }

    public <T> List<T> findByConditionPage(Object obj, Class<T> clazz, Integer pageIndex, Integer pageSize)
    {
        DBObject dbObject = MongoDBUtils.toDBObject(obj);

        int skip = pageIndex * pageSize - 1;
        int limit = pageSize;

        List<DBObject> array = this.collection.find(dbObject).skip(skip).limit(limit).toArray();
        List<T> object = MongoDBUtils.toList(array, clazz);

        return object;
    }
}
