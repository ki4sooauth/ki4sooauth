package com.gooagoo.gmongo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class GridFSDao
{
    private final Logger log = Logger.getLogger("mongo_log");

    private GridFS fs;

    public GridFSDao(String host, String dbName)
    {
        fs = MongoDBUtils.getGridFS(host, dbName);
    }

    public void save(List<String> list, String id, String fileName)
    {
        InputStream in = MongoDBUtils.getInputStream(list);
        try
        {
            GridFSInputFile createFile = fs.createFile(in);
            createFile.setId(id);
            createFile.setFilename(fileName);
            createFile.save();
        }
        catch (Exception e)
        {
            log.error("", e);
        }
        finally
        {
            MongoDBUtils.closeStream(in, null);
        }

    }

    public List<String> getData(DBObject dbObject)
    {
        List<GridFSDBFile> find = fs.find(dbObject);
        List<String> list = new ArrayList<String>();
        for (GridFSDBFile gridFSDBFile : find)
        {
            List<String> data = MongoDBUtils.getData(gridFSDBFile);
            list.addAll(data);
        }
        return list;
    }

    public List<String> getLimits(DBObject dbObject, long pageIndex, long pageSize)
    {
        List<GridFSDBFile> find = fs.find(dbObject);
        List<String> list = new ArrayList<String>();
        for (GridFSDBFile gridFSDBFile : find)
        {
            List<String> data = MongoDBUtils.getLimits(gridFSDBFile, pageIndex, pageSize);
            list.addAll(data);
        }
        return list;
    }

    public void append(DBObject query, List<String> list)
    {
        GridFSDBFile findOne = fs.findOne(query);
        OutputStream os = null;
        InputStream in = null;
        try
        {
            File file = File.createTempFile("temp", ".tmp");
            file.deleteOnExit();
            os = new BufferedOutputStream(new FileOutputStream(file));
            findOne.writeTo(os);
            StringBuffer buffer = null;
            for (String string : list)
            {
                String result = new String(Arrays.copyOf(string.toCharArray(), 32));
                buffer = new StringBuffer();
                buffer.append(result).append(System.getProperty("line.separator"));
                os.write(buffer.toString().getBytes());
            }
            os.flush();
            this.remove(query);
            in = new FileInputStream(file.getAbsoluteFile());
            GridFSInputFile createFile = fs.createFile(in);
            createFile.setId(findOne.getId());
            createFile.setFilename(findOne.getFilename());
            createFile.save();
        }
        catch (Exception e)
        {
            log.error("", e);
        }
        finally
        {
            MongoDBUtils.closeStream(in, os);
        }
    }

    public void remove(DBObject query)
    {
        fs.remove(query);
    }

    public void removeAll()
    {
        fs.remove(new BasicDBObject());
    }

}
