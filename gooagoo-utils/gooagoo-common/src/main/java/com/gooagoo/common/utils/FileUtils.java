package com.gooagoo.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 文件处理工具类
 * @author frenn
 *
 */
public class FileUtils
{

    /**
     * 创建本地目录
     * @param path  目录
     * @return      true-成功 false-失败
     */
    public static boolean createLocalPath(String path)
    {
        java.io.File f = new java.io.File(path);
        if (f.exists())
        {
            return true;
        }
        else if (f.mkdirs())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 读取文件
     * @param in
     * @return
     * @throws IOException
     */
    public static String readInfoFromFile(InputStream in) throws IOException
    {
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String temp = null;
        while ((temp = reader.readLine()) != null)
        {
            sb.append(temp + "\n");
        }
        return sb.toString();
    }

    /**
     * 复制文件
     * @param file
     * @param path
     * @return
     * @throws Exception
     */
    public static boolean copyFile(File file, String path) throws Exception
    {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try
        {
            char temp = path.charAt(path.length() - 1);
            if (temp != '/' && temp != '\\')
            {
                path += "/";
            }
            createLocalPath(path);
            inBuff = new BufferedInputStream(new FileInputStream(file));
            outBuff = new BufferedOutputStream(new FileOutputStream(path + file.getName()));
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1)
            {
                outBuff.write(b, 0, len);
            }
            outBuff.flush();
            return true;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            if (inBuff != null)
            {
                try
                {
                    inBuff.close();
                }
                catch (IOException e)
                {
                    throw e;
                }
            }
            if (outBuff != null)
            {
                try
                {
                    outBuff.close();
                }
                catch (IOException e)
                {
                    throw e;
                }
            }
        }
    }
}
