package com.gooagoo.common.gms.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.gooagoo.cache.InterfaceCache;
import com.gooagoo.cache.UploadConfigCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HttpClientUtils;
import com.gooagoo.common.utils.HttpUploadUtils;
import com.google.gson.Gson;

public class GMSHttpUtils
{

    /**
     * web层通过此方法调用interface层
     * 会同时传递Parametert和Attribute中的参数
     * 如果Parametert和Attribute参数重名则接收端会以数组的形式全都取到
     * @param code
     * @param request
     * @param clazz GResponse对象内集合的类型
     * @return GResponse对象
     */
    public static <T> TransData<T> transfer(String code, HttpServletRequest request, Class<T> clazz)
    {
        String url = InterfaceCache.get(code).getIUrl();
        return HttpClientUtils.transfer(code, url, request, clazz);
    }

    /**
     * 获取页面上传的文件对象列表
     * @param request
     */
    public static List<CommonsMultipartFile> getCommonsMultipartFileList(HttpServletRequest request)
    {
        List<CommonsMultipartFile> fileResult = new ArrayList<CommonsMultipartFile>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iter = multipartRequest.getFileNames();
        while (iter.hasNext())
        {
            String fileName = iter.next();
            CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile(fileName);
            fileResult.add(file);
        }
        return fileResult;
    }

    /**
     * 上传文件到服务器
     * @param module 文件上传到服务器所指定的文件夹
     * @param filePath 文件访问路径（有则覆盖源文件，无则新建）
     * @param content 文件内容
     * @param fileName 文件名
     * @return 文件的访问地址
     */
    public static String uploadFileByString(String module, String filePath, String content, String fileName)
    {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("module", module);
        hashMap.put("filePath", filePath);
        hashMap.put("method", HttpUploadUtils.UPLOAD_METHOD_FILE);

        String uploadUrl = UploadConfigCache.getFileUploadUrl();
        if (!StringUtils.hasText(uploadUrl))
        {
            GooagooLog.warn("===========从缓存中获取文件上传服务访问地址为空");
        }
        String url = uploadFileByString(uploadUrl, hashMap, content, fileName);
        return url;
    }

    /**
     * 上传文件到服务器
     * @param url 文件上传服务器的访问地址
     * @param hashMap 请求参数
     * @param content 文件内容
     * @param fileName 文件名
     * @return 文件的访问地址
     */
    public static String uploadFileByString(String url, Map<String, String> hashMap, String content, String fileName)
    {
        GooagooLog.debug("Upload Client Send:" + new Gson().toJson(hashMap));

        HttpClient httpclient = null;
        String resultxml = "";
        try
        {
            httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            MultipartEntity reqEntity = new MultipartEntity();
            //文件数据
            byte[] fileByte = content.getBytes();
            reqEntity.addPart(HttpUploadUtils.UPLOAD_FILE_NAME, new ByteArrayBody(fileByte, fileName));
            //字符串参数
            Iterator<Map.Entry<String, String>> iter = hashMap.entrySet().iterator();
            while (iter.hasNext())
            {
                Map.Entry<String, String> entry = iter.next();
                String key = entry.getKey();
                String value = entry.getValue();
                reqEntity.addPart(key, new StringBody(value));
            }
            httppost.setEntity(reqEntity);
            HttpResponse response = httpclient.execute(httppost);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode())
            {
                HttpEntity httpEntity = response.getEntity();
                if (httpEntity != null)
                {
                    resultxml = EntityUtils.toString(httpEntity, "utf-8");
                }
            }
            else
            {
                GooagooLog.warn("GMSHttpUtils上传文件，result:错误编码:" + response.getStatusLine().getStatusCode() + ",paras:" + new Gson().toJson(hashMap));
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("GMSHttpUtils上传文件异常,paras:" + new Gson().toJson(hashMap), e);
        }
        finally
        {
            httpclient = null;
        }

        GooagooLog.debug("Upload Client Recieve:" + new Gson().toJson(resultxml));

        return resultxml;
    }
}
