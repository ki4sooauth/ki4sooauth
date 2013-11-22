package com.gooagoo.junittest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;

public class HttpClientUtils
{
    public static String httpGet() throws ClientProtocolException, IOException
    {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext httpContext = new BasicHttpContext();
        HttpGet get = new HttpGet("http://itrans.gooagoo.com/trans.do?itype=gasa01");

        HttpResponse httpResponse = httpClient.execute(get, httpContext);

        HttpEntity entity = httpResponse.getEntity();
        String charset = null;
        if (entity != null)
        {
            charset = EntityUtils.getContentCharSet(entity);
            System.out.println("返回信息编码格式--charset：" + charset);
        }
        httpClient.getConnectionManager().shutdown();
        return charset;
    }

    public static Object HttpPost(List<NameValuePair> list, Object object, String interfaceCode)
    {
        try
        {
            HttpClient httpClient = new DefaultHttpClient();
            String url = "http://itrans.gooagoo.com/trans.do?itype=" + interfaceCode;
            //如测试本地接口，url则改为url = "http://localhost:8069/igas/gas.do?itype=gasa01";
            HttpPost httpPost = new HttpPost(url);

            //            String charset = httpGet();
            httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
            String requestUrl = url + list;

            HttpResponse httpResponse = httpClient.execute(httpPost);

            HttpEntity entity = httpResponse.getEntity();
            String line = "";
            if (entity != null)
            {
                InputStream in = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                line = reader.readLine();
                in.close();
            }
            httpClient.getConnectionManager().shutdown();//关闭httpclient连接
            if (!getMethodName().trim().equals("<init>"))
            {
                System.out.println("\n" + getMethodName() + "用例:\n");
                System.out.println("访问接口的url为:" + requestUrl.replace("[", "&").replace("]", "").replace(",", "&").replace(" ", ""));
                System.out.println("返回报文为:\n" + JsonTool.formatJson(line, " "));
            }
            if (StringUtils.hasText(line))
            {
                Gson json = new Gson();
                object = json.fromJson(line, object.getClass());
            }
            else
            {
                object = null;
            }

        }
        catch (UnsupportedEncodingException e)
        {
            System.out.print("入参编码格式有误");
            e.printStackTrace();
        }
        catch (ClientProtocolException e)
        {
            System.out.print("客服端协议异常");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.print("IO异常");
            e.printStackTrace();
        }

        return object;
    }

    /**
     * 获取调用当前运行的方法的方法名
     * @return
     */
    public static String getMethodName()
    {
        return new Throwable().getStackTrace()[2].getMethodName();
    }

    /**
     * 获取当前运行的方法名
     * @return
     */
    public static String getCurrentMethodName()
    {
        return new Throwable().getStackTrace()[0].getMethodName();
    }
}
