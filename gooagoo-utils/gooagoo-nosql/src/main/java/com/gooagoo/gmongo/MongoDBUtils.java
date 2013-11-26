package com.gooagoo.gmongo;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.WriteConcern;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;

public class MongoDBUtils
{
    private static Logger log = Logger.getLogger("mongo_log");
    private static final int PRIMARY = 0;
    private static final int NOT_PRIMARY = 1;
    private static final int NOT_PRIMARY_LIST = 2;
    private static final String[] PRIMARY_ARRAY = { "int", "java.lang.Integer", "long", "java.lang.Long", "java.lang.String", "double", "java.lang.Double", "java.util.Date" };

    private static final int POOL_SIZE = 20;
    private static final int BLOCK_SIZE = 10;

    private static Map<String, Mongo> pool = new HashMap<String, Mongo>();

    /**
     * 获取gmongo数据连接
     * 
     * @param key
     * @return
     * @throws UnknownHostException
     * @throws NumberFormatException
     */
    public static DBCollection getDBCollection(String host, String dbName, String collectionName)
    {
        DBCollection collection = null;
        DB db = getDB(host, dbName);
        collection = db.getCollection(collectionName);

        return collection;
    }

    public static DBCollection getDBCollection(DB db, String collectionName)
    {
        return db.getCollection(collectionName);
    }

    public synchronized static DB getDB(String host, String dbName)
    {
        DB db = null;
        Mongo mongo = null;
        try
        {
            mongo = pool.get(host + dbName);
            if (mongo == null)
            {
                String[] configs = host.split(":");
                DBAddress address = new DBAddress(configs[0], Integer.parseInt(configs[1]), dbName);
                MongoOptions opt = new MongoOptions();
                opt.connectionsPerHost = POOL_SIZE;
                opt.threadsAllowedToBlockForConnectionMultiplier = BLOCK_SIZE;
                opt.connectTimeout = 10000;
                opt.socketTimeout = 10000;
                mongo = new Mongo(address, opt);
                mongo.setWriteConcern(WriteConcern.SAFE);
                pool.put(host + dbName, mongo);
            }
            db = mongo.getDB(dbName);
        }
        catch (Exception e)
        {
            log.debug("获取mongo连接异常", e);
        }
        return db;
    }

    /**
     * 获取gmongo数据连接
     * 
     * @param key
     * @return
     * @throws UnknownHostException
     * @throws NumberFormatException
     */
    public static GridFS getGridFS(String host, String dbName)
    {
        GridFS fs = null;
        try
        {
            String[] configs = host.split(":");
            DBAddress address = new DBAddress(configs[0], Integer.parseInt(configs[1]), dbName);
            DB db = Mongo.connect(address);
            fs = new GridFS(db);
        }
        catch (Exception e)
        {
            log.debug("获取mongo连接异常", e);
        }
        return fs;
    }

    public static DBObject toDBObject(Map<String, Object> map)
    {
        DBObject dbObject = new BasicDBObject();
        for (Map.Entry<String, Object> entry : map.entrySet())
        {
            dbObject.put(entry.getKey(), entry.getValue());
        }
        return dbObject;
    }

    public static DBObject toDBObject(Object object)
    {
        DBObject dbObject = null;
        try
        {
            dbObject = new BasicDBObject();
            Field[] declaredFields = object.getClass().getDeclaredFields();
            for (Field field : declaredFields)
            {
                if (!Modifier.isFinal(field.getModifiers()))
                {
                    field.setAccessible(true);
                    Object obj = field.get(object);
                    if (obj != null)
                    {
                        if (PRIMARY == isPrimary(field))
                        {
                            if (obj != null)
                            {
                                dbObject.put(field.getName(), obj);
                            }
                        }
                        else if (NOT_PRIMARY == isPrimary(field))
                        {
                            DBObject dbObj = new BasicDBObject();
                            Field[] declaredField = obj.getClass().getDeclaredFields();
                            for (Field field2 : declaredField)
                            {
                                if (!Modifier.isFinal(field2.getModifiers()))
                                {
                                    field2.setAccessible(true);
                                    Object object2 = field2.get(obj);
                                    if (obj != null && object2 != null)
                                    {
                                        dbObj.put(field2.getName(), object2);
                                    }
                                }
                            }
                            dbObject.put(field.getName(), dbObj);
                        }
                        else if (NOT_PRIMARY_LIST == isPrimary(field))
                        {
                            DBObject dbObjList = new BasicDBList();
                            List<?> list = (List<?>) field.get(object);
                            DBObject tempDbObject = null;
                            for (int i = 0; i < list.size(); i++)
                            {
                                Object obj2 = list.get(i);
                                tempDbObject = new BasicDBObject();
                                Field[] declaredFields2 = obj2.getClass().getDeclaredFields();
                                for (Field field2 : declaredFields2)
                                {
                                    if (!Modifier.isFinal(field2.getModifiers()))
                                    {
                                        field2.setAccessible(true);
                                        Object tempObj = field2.get(obj2);
                                        if (tempObj != null)
                                        {
                                            tempDbObject.put(field2.getName(), tempObj);
                                        }
                                    }
                                }
                                dbObjList.put(i + "", tempDbObject);
                            }
                            dbObject.put(field.getName(), dbObjList);
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            log.debug("mongo 转成DBObject对象异常", e);
        }
        return dbObject;
    }

    public static <T> List<T> toList(List<DBObject> dbList, Class<T> clazz)
    {
        List<T> list = new ArrayList<T>(0);
        T t = null;
        if (dbList != null && !dbList.isEmpty())
        {
            for (DBObject db : dbList)
            {
                if (db != null)
                {
                    String dataStr = new Gson().toJson(db);
                    t = new Gson().fromJson(dataStr, clazz);
                    list.add(t);
                }
            }
        }
        return list;
    }

    public static int isPrimary(Field field)
    {
        String typeName = field.getType().getName();
        for (String string : PRIMARY_ARRAY)
        {
            if (string.equals(typeName))
            {
                return PRIMARY;
            }
        }
        if ("java.util.List".equals(typeName))
        {
            Type genericType = field.getGenericType();
            String genericsType = getGenericsType(genericType);
            for (String string : PRIMARY_ARRAY)
            {
                if (string.equals(genericsType))
                {
                    return PRIMARY;
                }
            }
            return NOT_PRIMARY_LIST;
        }
        return NOT_PRIMARY;
    }

    /**
     * 取得泛型的实际类型
     * 
     * @param type
     * @return
     */
    private static String getGenericsType(Type type)
    {
        String fieldType = type.toString();
        return new String(fieldType.getBytes(), 15, fieldType.getBytes().length - 16);
    }

    public static InputStream getInputStream(List<String> strings)
    {
        InputStream in = null;
        OutputStream os = null;
        try
        {
            File file = File.createTempFile("temp", ".tmp");
            file.deleteOnExit();
            os = new BufferedOutputStream(new FileOutputStream(file));
            StringBuffer buffer = null;
            for (String string : strings)
            {
                String result = new String(Arrays.copyOf(string.toCharArray(), 32));
                buffer = new StringBuffer();
                buffer.append(result).append(System.getProperty("line.separator"));
                os.write(buffer.toString().getBytes());
            }
            os.flush();
            in = new FileInputStream(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeStream(null, os);
        }
        return in;
    }

    public static List<String> getData(GridFSDBFile fsdbFile)
    {
        List<String> list = new ArrayList<String>();
        OutputStream os = null;
        BufferedReader reader = null;
        try
        {
            File file = File.createTempFile("temp", ".tmp");
            file.deleteOnExit();
            os = new FileOutputStream(file);
            fsdbFile.writeTo(os);
            os.flush();
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (reader.read() != -1)
            {
                list.add(reader.readLine().trim());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                closeStream(null, os);
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static List<String> getLimits(GridFSDBFile fsdbFile, long pageIndex, long pageSize)
    {
        List<String> list = new ArrayList<String>();
        OutputStream os = null;
        RandomAccessFile accessFile = null;
        try
        {
            File file = File.createTempFile("temp", ".tmp");
            file.deleteOnExit();
            os = new FileOutputStream(file);
            fsdbFile.writeTo(os);
            os.flush();
            accessFile = new RandomAccessFile(file, "r");
            if (pageIndex <= 0)
            {
                pageIndex = 1;
            }
            accessFile.seek((pageIndex - 1) * pageSize * 34);
            long p = accessFile.getFilePointer();
            while (pageIndex * pageSize * 34 > p && accessFile.read() != -1)
            {
                list.add(accessFile.readLine().trim());
                p = accessFile.getFilePointer();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                closeStream(null, os);
                accessFile.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void closeStream(InputStream in, OutputStream os)
    {
        try
        {
            if (os != null)
            {
                os.close();
            }
            if (in != null)
            {
                in.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}