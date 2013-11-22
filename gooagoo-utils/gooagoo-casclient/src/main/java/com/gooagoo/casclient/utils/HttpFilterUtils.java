package com.gooagoo.casclient.utils;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

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

import com.gooagoo.casclient.log.CasLog;

public class HttpFilterUtils
{

    public static Object transferObj(String url, String token)
    {
        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
        nvps.add(new BasicNameValuePair("token", token));
        Object obj = null; //返回的对象
        //        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        HttpClient httpclient = new DefaultHttpClient();
        try
        {
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
                InputStream stream = entity.getContent();
                ObjectInputStream ois = new ObjectInputStream(stream);
                obj = ois.readObject();
                stream.close();
            }
            else
            {
                CasLog.warn("http连接状态不正常" + response.getStatusLine().getStatusCode());
            }
            httpPost.abort();
        }
        catch (Exception e)
        {
            CasLog.error("单点登录接口异常", e);
        }
        finally
        {
            httpclient.getConnectionManager().shutdown();
        }
        return obj;
    }

}
