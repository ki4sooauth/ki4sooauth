package com.gooagoo.common.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.entity.TransHeadData;
import com.gooagoo.common.log.GooagooLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpClientUtils
{
    private final static String INTERFACE_SERIAL = "com.gooagoo.interface.serial";
    private final static String INTERFACE_CODE = "com.gooagoo.interface.code";
    private final static String SYS_CONNECT_ERROR = "S001";

    /**
     * web层通过此方法调用interface层
     * 会同时传递Parametert和Attribute中的参数
     * 如果Parametert和Attribute参数重名则接收端会以数组的形式全都取到
     * @param code
     * @param request
     * @param clazz GResponse对象内集合的类型
     * @return GResponse对象
     */
    @SuppressWarnings("unchecked")
    public static <T> TransData<T> transfer(String code, String url, HttpServletRequest request, Class<T> clazz)
    {
        TransHeadData defHead = new TransHeadData(false, SYS_CONNECT_ERROR);
        TransData<T> obj = new TransData<T>(defHead);
        try
        {
            List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>(); //Post传递的参数
            Map<String, String[]> requestMap = request.getParameterMap();

            for (String key : requestMap.keySet())
            {
                String[] arrayValues = requestMap.get(key);
                for (String value : arrayValues)
                {
                    nvps.add(new BasicNameValuePair(key, value));
                }
            }
            Enumeration<String> enu = request.getAttributeNames();
            while (enu.hasMoreElements())
            {
                String key = enu.nextElement();
                Object att = request.getAttribute(key);
                if (att instanceof String)
                {
                    nvps.add(new BasicNameValuePair(key, att.toString()));
                }
            }
            obj = (TransData<T>) transferObj(code, url, nvps);
        }
        catch (Exception e)
        {
            GooagooLog.error("web层通过此方法调用interface层异常", e);
        }
        if (obj == null)
        {
            obj = new TransData<T>(defHead);
        }
        return obj;
    }

    private static Object transferObj(String code, String url, List<BasicNameValuePair> nvps)
    {
        Object obj = null; //返回的对象
        HttpClient httpclient = new DefaultHttpClient();
        try
        {
            nvps.add(new BasicNameValuePair(INTERFACE_CODE, code));
            nvps.add(new BasicNameValuePair(INTERFACE_SERIAL, UUID.getUUID()));
            logSend(nvps); //记日志

            httpclient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "user_agent");
            httpclient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY); //设置cookie的兼容性
            httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);//超时

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8")); //将参数传入post方法中
            httpPost.setHeader("Connection", "close");//.setRequestHeader("Connection", "close");  
            HttpResponse response = httpclient.execute(httpPost); //执行
            if (response.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity = response.getEntity();
                if (entity.getContentLength() != 0)
                {
                    InputStream stream = entity.getContent();
                    ObjectInputStream ois = new ObjectInputStream(stream);
                    obj = ois.readObject();
                    stream.close();
                }
            }
            httpPost.abort();
        }
        catch (Exception e)
        {
            GooagooLog.error("http error", e);
        }
        finally
        {
            httpclient.getConnectionManager().shutdown();
        }
        logReceive(obj);
        return obj;
    }

    private static void logSend(Object object)
    {
        log(object, "Client Send: ");
    }

    private static void logReceive(Object object)
    {
        log(object, "Client Receive: ");
    }

    private static void log(Object object, String head)
    {
        if (object instanceof String)
        {
            GooagooLog.debug(head + object);
        }
        else
        {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            String json = gson.toJson(object);
            GooagooLog.debug(head + json);
        }
    }

    /**
     * 获取资源的html代码
     * @param url
     * @return
     */
    public static String loadFileStringByUrl(String url)
    {
        String fileStr = null;
        InputStream in = null;
        URLConnection urlConnection = null;
        try
        {
            URL urlObj = new URL(url);
            urlConnection = urlObj.openConnection();
            urlConnection.setUseCaches(true);
            in = urlConnection.getInputStream();

            InputStreamReader is = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(is);

            StringBuffer sb = new StringBuffer();
            String temp = null;
            while ((temp = reader.readLine()) != null)
            {
                sb.append(temp + "\n");
            }
            fileStr = sb.toString();
        }
        catch (Exception e)
        {
            GooagooLog.error("从URL指定位置加载资源失败，url=" + url, e);
        }
        finally
        {
            if (null != in)
            {
                try
                {
                    in.close();
                }
                catch (Exception e)
                {
                    GooagooLog.error("从URL指定位置加载资源异常时关闭文件流失败，url=" + url, e);
                }
            }
        }
        return fileStr;
    }
}
