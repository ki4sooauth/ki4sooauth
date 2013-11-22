package com.gooagoo.gmap.trigger;

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

import com.gooagoo.cache.InterfaceCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;

/**
 * 定期更新缓存中的网格数据 
 *
 */
public class MapTrigger
{

    public void refreshGridCoordinateInfos()
    {
        String code = InterGmsConstants.I_GMS_SVG_MAP_GRIDINFOS_TO_CACHE;
        String url = InterfaceCache.get(code).getIUrl();

        int i = 0;
        TransData<Object> obj = null;
        do
        {
            obj = this.transfer(code, url);
            i++;
        }
        while (!(obj != null && obj.getHead().isSuccess()) && i < 3);

    }

    @SuppressWarnings("unchecked")
    private TransData<Object> transfer(String code, String url)
    {
        Object obj = null; //返回的对象

        HttpClient httpclient = new DefaultHttpClient();
        try
        {
            List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>(); //Post传递的参数
            nvps.add(new BasicNameValuePair("com.gooagoo.interface.code", code));
            nvps.add(new BasicNameValuePair("com.gooagoo.interface.serial", UUID.getUUID()));
            nvps.add(new BasicNameValuePair(GMSConstant.INTERFACE_TYPE_REQUEST_KEY, GMSConstant.INTERFACE_TYPE_BATCH));

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
        return (TransData<Object>) obj;
    }
}
