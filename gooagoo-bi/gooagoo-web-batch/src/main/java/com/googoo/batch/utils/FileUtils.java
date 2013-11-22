package com.googoo.batch.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

public class FileUtils
{

    private static final String BASE_PATH = ResourceBundle.getBundle("fileConfig").getString("filePath");

    public static File createDir(String subDir)
    {
        File file = new File(BASE_PATH, subDir);
        if (file.exists())
        {
            return file;
        }
        if (file.mkdirs())
        {
            return file;
        }
        return null;
    }

    public static File createFile(File file, String fileName)
    {
        File newFile = null;
        try
        {
            newFile = new File(file, fileName);
            newFile.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return newFile;
    }

    public static void write2File(File file, String data)
    {

        OutputStreamWriter write = null;
        try
        {
            write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(data);
            writer.flush();
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
        finally
        {
            try
            {
                if (write != null)
                {
                    write.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private static void closeStream(InputStream in, OutputStream os)
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

    public static void createAndWriteFile(String subDir, String data, String fileName)
    {
        File file = createDir(subDir);
        File txtFile = createFile(file, fileName);
        write2File(txtFile, data);
    }

    public static String getFileName(String shopId, String objId, String timeType, String sourceType, String channel)
    {
        StringBuffer buffer = new StringBuffer();
        if (StringUtils.isNotBlank(shopId))
        {
            buffer.append(shopId);
        }
        if (StringUtils.isNotBlank(objId))
        {
            buffer.append("^" + objId);
        }
        if (StringUtils.isNotBlank(timeType))
        {
            buffer.append("^" + timeType);
        }
        if (StringUtils.isNotBlank(sourceType))
        {
            buffer.append("^" + sourceType);
        }
        if (StringUtils.isNotBlank(channel))
        {
            buffer.append("^" + channel);
        }
        return buffer.toString();
    }

    public static String getfileName(String id)
    {
        StringBuffer fileName = new StringBuffer();
        String[] ids = id.split("_");
        for (int i = 0; i < ids.length - 1; i++)
        {
            if (StringUtils.isNotBlank(ids[i]))
            {
                if ("*".equals(ids[i]))
                {
                    fileName.append("()" + "_");
                }
                else
                {
                    fileName.append(ids[i] + "_");
                }
            }
        }
        /*
        if ("Y".equals(ids[ids.length - 1]))
        {
            Format df = new SimpleDateFormat("yyyy");
            fileName.append(df.format(new Date()));
        }
        */
        if ("M".equals(ids[ids.length - 1]))
        {
            Format df = new SimpleDateFormat("yyyy");
            fileName.append(df.format(new Date()));
        }
        else if ("D".equals(ids[ids.length - 1]))
        {
            Format df = new SimpleDateFormat("yyyy-MM");
            fileName.append(df.format(new Date()));
        }
        else if ("H".equals(ids[ids.length - 1]))
        {
            Format df = new SimpleDateFormat("yyyy-MM-dd");
            fileName.append(df.format(new Date()));
        }
        return fileName.toString();

    }

    public static String getfileName(String id, String dateType, String userType, String channel, String source)
    {
        StringBuffer fileName = new StringBuffer();

        if (StringUtils.isNotBlank(id))
        {
            fileName.append(id + "_");
        }
        if (StringUtils.isNotBlank(dateType))
        {
            if ("*".equals(dateType))
            {
                fileName.append("()" + "_");
            }
            else
            {
                fileName.append(dateType + "_");
            }
        }
        if (StringUtils.isNotBlank(userType))
        {
            fileName.append(userType + "_");
        }
        if (StringUtils.isNotBlank(channel))
        {
            if ("*".equals(channel))
            {
                fileName.append("()" + "_");
            }
            else
            {
                fileName.append(channel + "_");
            }
        }
        if (StringUtils.isNotBlank(source))
        {
            if ("*".equals(source))
            {
                fileName.append("()" + "_");
            }
            else
            {
                fileName.append(source + "_");
            }
        }

        return fileName.substring(0, fileName.length() - 1);
    }
}
