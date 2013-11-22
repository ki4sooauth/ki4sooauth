package com.gooagoo.cms.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestBindingException;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.exception.GooagooException;
import com.gooaoo.view.common.GAjax;
import com.google.gson.Gson;

public class CMSUtil
{

    /**
     * 替换html内容中指定标签的内容
     * @param content
     * @param tag 标签
     * @param tagCont 标签所要替换的内容
     */
    public static String replaceTag(String content, String tag, String tagCont)
    {
        if (!StringUtils.hasText(content) || !StringUtils.hasText(tag))
        {
            return content;
        }
        if (tagCont == null)
        {
            tagCont = "";
        }
        return content.replaceAll(tag, tagCont);
    }

    /**
     * 将时间设置凌晨0时
     * @param date
     * @return
     * @throws Exception 
     */
    public static Date getEarlyMorning(Date date) throws Exception
    {
        if (date == null)
        {
            return null;
        }
        String dateStr = TimeUtils.convertDateToString(date, "yyyy-MM-dd");
        dateStr = dateStr + " 00:00:00";

        Date nd = TimeUtils.convertStringToDate(dateStr);

        return nd;
    }

    /**
     * 将时间设置成晚上24时
     * @param date
     * @return
     * @throws Exception 
     */
    public static Date getMidNight(Date date) throws Exception
    {
        if (date == null)
        {
            return null;
        }
        String dateStr = TimeUtils.convertDateToString(date, "yyyy-MM-dd");
        dateStr = dateStr + " 23:59:59";

        Date nd = TimeUtils.convertStringToDate(dateStr);

        return nd;
    }

    /**
     * web层获取登录者信息
     * @param request
     * @return
     */
    public static com.gooagoo.entity.casclient.shop.ShopLoginInfo getShopLoginInfoByWeb(HttpServletRequest request)
    {
        com.gooagoo.entity.casclient.shop.ShopLoginInfo shopLoginInfo = (com.gooagoo.entity.casclient.shop.ShopLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);

        return shopLoginInfo;
    }

    //    /**
    //     * web层获取登录者信息
    //     * @param request
    //     * @return
    //     */
    //    public static CmsLoginInfo getGmsLoginInfoByWeb(HttpServletRequest request)
    //    {
    //        com.gooagoo.entity.casclient.shop.ShopLoginInfo shopLoginInfo = getShopLoginInfoByWeb(request);
    //        CmsLoginInfo shopInfo = CMSServiceUtil.convertCasObjToGmsLoginInfo(shopLoginInfo);
    //
    //        return shopInfo;
    //    }

    /**
     * web层获取登录者的商家编号
     * @param request
     * @return
     */
    public static String getShopIdByWeb(HttpServletRequest request)
    {
        String shopId = (String) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJID);

        return shopId;
    }

    /**
     * 将新对象中不为null的字段值更新到原对象-只支持一层属性的更新
     * @param oldObj原对象
     * @param newObj新对象
     * @return 
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object freshObject(Object oldObj, Object newObj) throws IllegalArgumentException, IllegalAccessException
    {
        if (oldObj != null && newObj != null)
        {
            Field[] fields = newObj.getClass().getDeclaredFields();
            for (Field field : fields)
            {
                field.setAccessible(true);
                Object value = field.get(newObj);
                if (value != null && !Modifier.isFinal(field.getModifiers()))
                {
                    field.set(oldObj, value);
                }
            }
        }
        return newObj;
    }

    /**
     * 创建TransData对象
     * @param success 是否成功
     * @param resultCode  默认错误编码（例如删除操作没有抛异常，但返回结果为false时所需要制定的错误编码）
     * @param data
     * @return
     * @throws Exception
     */
    public static <T> TransData<T> toTransData(Boolean success, String resultCode, T data) throws Exception
    {
        return new TransData<T>(success, resultCode, data);
    }

    /**
     * 创建TransData对象
     * @param success 是否成功
     * @param resultCode  默认错误编码（例如删除操作没有抛异常，但返回结果为false时所需要制定的错误编码）
     * @param data
     * @param operateId 操作对象ID
     * @return
     * @throws Exception
     */
    public static <T> TransData<T> toTransData(Boolean success, String resultCode, T data, String operateId) throws Exception
    {
        return new TransData<T>(success, resultCode, data, operateId);
    }

    /**
     * 返回boolean类型接口结果
     * @param result
     * @param successRC 成功结果编码
     * @param failRC 失败结果编码
     * @return
     */
    public static TransData<Object> getBooleanResult(Boolean result, String successRC, String failRC)
    {
        String rc = null;
        if (result)
        {
            rc = successRC;
        }
        else
        {
            rc = failRC;
        }
        return new TransData<Object>(result, rc, null);
    }

    /**
     * 返回boolean类型接口结果
     * @param result
     * @param successRC 成功结果编码
     * @param failRC 失败结果编码
     * @return
     */
    public static TransData<Object> getBooleanResult(Boolean result, String successRC, String failRC, String operateId)
    {
        return getBooleanAndExtendResult(result, successRC, failRC, null, operateId);
    }

    /**
     * 返回boolean类型接口结果
     * @param result
     * @param successRC 成功结果编码
     * @param failRC 失败结果编码
     * @param data 交易内容信息
     * @param operateId 操作对象ID
     * @return
     */
    public static <T> TransData<T> getBooleanAndExtendResult(Boolean result, String successRC, String failRC, T data, String operateId)
    {
        String rc = null;
        if (result)
        {
            rc = successRC;
        }
        else
        {
            rc = failRC;
        }
        return new TransData<T>(result, rc, data, operateId);
    }

    /**
     * http客户端请求
     * @param code 接口编码
     * @param request
     * @param dataClass T->class
     * @throws IOException
     */
    public static <T> TransData<T> httpClientRequest(String code, HttpServletRequest request, Class<T> dataClass)
    {
        return CMSHttpUtils.transfer(code, request, dataClass);
    }

    /**
     * action中ajax调用方法（返回布尔类型公用调用）
     * @param interfaceCode
     * @param request
     * @param response
     * @throws Exception
     */
    public static void ajaxSubmit(String interfaceCode, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<Object> respObj = httpClientRequest(interfaceCode, request, Object.class);

        String resultCode = respObj.getHead().getResultCode();
        String resultName = ExceptionCache.get(resultCode);
        if (!StringUtils.hasText(resultName))
        {
            GooagooLog.info("获取提示信息名称为空，resultName=" + resultName + ",resultCode=" + resultCode);
            resultName = resultCode;
        }
        GAjax rv = new GAjax(respObj.getHead().isSuccess(), resultName);

        Object data = respObj.getData();
        if (data instanceof String)
        {
            rv.setExtend((String) data);
        }
        String result = new Gson().toJson(rv);

        ServletUtils.writeHtml(result, response);
    }

    /**
     * 获取二维码数据
     * @param response
     * @param content
     * @param size
     * @throws ServletRequestBindingException
     * @throws UnsupportedEncodingException
     */
    public static void forwardTwoCode(HttpServletResponse response, String content, String size)
    {
        HttpClient httpclient = new DefaultHttpClient();
        try
        {
            List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
            nvps.add(new BasicNameValuePair("c", content));
            nvps.add(new BasicNameValuePair("s", size));
            nvps.add(new BasicNameValuePair("method", "twoCode"));

            httpclient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "user_agent");
            httpclient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY); //设置cookie的兼容性
            httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);//超时
            String url = GmsConfigCache.get("server_code_url");
            if (!StringUtils.hasText(url))
            {
                GooagooLog.warn("===========从缓存中获取二维码服务访问地址为空");
                throw new GooagooException("GmsConfigCache.get('server_code_url')为空");
            }
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8")); //将参数传入post方法中
            httpPost.setHeader("Connection", "close");//.setRequestHeader("Connection", "close");  
            HttpResponse httpResponse = httpclient.execute(httpPost); //执行
            if (httpResponse.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity = httpResponse.getEntity();
                ServletOutputStream outputStream = response.getOutputStream();
                entity.writeTo(outputStream);
            }
            httpPost.abort();
        }
        catch (Exception e)
        {
            GooagooLog.error("获取二维码数据失败，content=" + content + ",size=" + size, e);
        }
        finally
        {
            httpclient.getConnectionManager().shutdown();
        }
    }

}
