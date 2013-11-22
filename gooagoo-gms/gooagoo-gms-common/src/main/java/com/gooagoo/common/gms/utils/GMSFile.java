package com.gooagoo.common.gms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import com.gooagoo.common.log.GooagooLog;

public class GMSFile
{
    /**
     * 通过url获取输入流
     * @param url
     * @return
     */
    public static InputStream getInputStreamByUrl(String url)
    {
        InputStream in = null;
        URLConnection urlConnection = null;
        try
        {
            URL urlObj = new URL(url);
            urlConnection = urlObj.openConnection();
            urlConnection.setUseCaches(true);
            in = urlConnection.getInputStream();
        }
        catch (Exception e)
        {
            GooagooLog.error("通过url获取输入流失败，url=" + url, e);
        }
        return in;
    }

    /**
     * 通过url获取Document
     * @param url
     * @return
     */
    public static Document getDocumentByUrl(String url)
    {
        Document document = null;
        InputStream is = null;
        try
        {
            SAXReader reader = new SAXReader();
            is = GMSFile.getInputStreamByUrl(url);
            document = reader.read(is);
        }
        catch (Exception e)
        {
            document = null;
            GooagooLog.error("通过url获取Document异常,url=" + url, e);
        }
        finally
        {
            if (is != null)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    GooagooLog.error("通过url获取Document时关闭输入流异常,url=" + url, e);
                }
            }
        }
        return document;
    }

}
