package com.gooagoo.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;

import com.gooagoo.common.log.GooagooLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LogUtils
{

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.SSS").create();

    /**
     * 组装日志详细信息
     * @param request
     * @param object
     * @return
     */
    public static String getOperateContent(HttpServletRequest request, Object object)
    {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("input", request.getParameterMap());
        String str = gson.toJson(object);
        if (str != null && str.length() < 1000)
        {
            m.put("output", object);
        }
        else
        {
            m.put("output", "数据量太大，不做记录");
        }
        return gson.toJson(m);
    }

    /**
     * 发送消息到ESB
     * @param url   ESB的链接地址
     * @param code  所调用的接口编码
     * @param type  行为类型
     * @param content   消息内容
     */
    public static void sendBehave(String url, String code, String type, String content)
    {
        HttpClient httpclient = new DefaultHttpClient();
        try
        {
            List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
            nvps.add(new BasicNameValuePair("code", code));
            nvps.add(new BasicNameValuePair("type", type));
            nvps.add(new BasicNameValuePair("content", content));
            httpclient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "user_agent");
            httpclient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY); //设置cookie的兼容性
            httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);//超时

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8")); //将参数传入post方法中
            httpPost.setHeader("Connection", "close");//.setRequestHeader("Connection", "close");  
            httpclient.execute(httpPost); //执行
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
    }
}
