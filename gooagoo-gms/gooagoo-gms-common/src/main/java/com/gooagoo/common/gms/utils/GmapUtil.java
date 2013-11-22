package com.gooagoo.common.gms.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.cache.UploadConfigCache;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HttpClientUtils;
import com.gooagoo.common.utils.HttpUploadUtils;
import com.google.gson.Gson;

public class GmapUtil
{
    private static String mapHtml;

    public static String svg_file_content = "####SVG_FILE_CONTENT####";
    public static String div_content = "####DIV_CONTENT####";

    static
    {
        String baseUrl = GmsConfigCache.get(GMSConstant.HTML_URL_HEAD_KEY);
        mapHtml = HttpClientUtils.loadFileStringByUrl(baseUrl + "/gms/gmap/html/map.html");
    }

    /**
     * 获取网格坐标中一个单元格对应页面的像素值
     * @return
     */
    public static int getGridId(int x, int y, int xGridNum)
    {
        int num = y * xGridNum + x;
        return num;
    }

    /**
     * 获取网格坐标中一个单元格对应页面的像素值
     * @return
     */
    public static int getGridValue(int value, double ratio, int gridUnit)
    {
        int iv = getGridNum(value, ratio);
        return iv * gridUnit;
    }

    /**
     * 获取网格坐标中横向或纵向的格子数
     * @return
     */
    public static int getGridNum(int value, double ratio)
    {
        double dv = (value + 0.0) / ratio;
        int iv = (int) dv;
        if (dv - iv > 0)
        {
            iv = iv + 1;
        }
        return iv;
    }

    /**
     * 获取网格坐标中一个单元格对应页面的像素值
     * @return
     */
    public static int getGridUnitPix()
    {
        return 20;
    }

    /**
     * 获取动线在SVG图中标识属性值
     * @return
     */
    public static String getGeneratrixIdentityProperty()
    {
        return GmsConfigCache.get(GMSConstant.GENERATRIX_SVG_PROPERTY_KEY);
    }

    /**
     * 生成静态化地图页面
     * @param svg
     * @param str
     */
    public static String getSvgHtml(String svg, String str)
    {
        String map = mapHtml;
        map = map.replaceAll(svg_file_content, svg);
        map = map.replaceAll(div_content, str);

        return map;
    }

    /**
     * 字符串保存到 文件
     * @param svgStr
     * @param mapId
     */
    public static void saveContent(String content, String fileName)
    {
        FileWriter fwriter = null;
        try
        {
            fwriter = new FileWriter(new File(fileName));
            fwriter.write(content);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                fwriter.flush();
                fwriter.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    //    /**
    //     * 获得地图上商家提示层信息
    //     * @param layers
    //     * @return
    //     * @throws DocumentException
    //     */
    //    public static String getDivContent(List<SvgAreaTip> layers) throws DocumentException
    //    {
    //        String str1 = "<div style='display:none;' id='";
    //        String str2 = "' class='tip'><span>";
    //        String str3 = "</span><span>";
    //        String str4 = "</span><img width='60' height='60' src='";
    //        String str5 = "'/><input type='button' style=';margin-top:-30px;float:right;margin-right:11px' value='导航'  onclick=" + '"';
    //        String str6 = '"' + "/><p>";
    //        String str7 = "</p></div>";
    //
    //        String str = "";
    //        for (int i = 0; i < layers.size(); i++)
    //        {
    //            SvgAreaTip layer = layers.get(i);
    //
    //            String pxPy = "shopNavi('" + layer.getPositionName() + "'," + layer.getAreaPx() + "," + layer.getAreaPy() + ")";
    //
    //            str += str1 + "tip_" + layer.getSvgTagId() + str2 + layer.getPositionName() + str3 + layer.getShopEntityPhone() + str4 + layer.getShopLogo() + str5 + pxPy + str6 + layer.getPositionDes() + str7;
    //            str += str1 + "tip_" + layer.getSvgTagId() + "_text" + str2 + layer.getPositionName() + str3 + layer.getShopEntityPhone() + str4 + layer.getShopLogo() + str5 + pxPy + str6 + layer.getPositionDes() + str7;
    //        }
    //        return str;
    //    }

    /**
     * 上传文件
     * @param fileName
     * @return
     */
    public static String uploadFile(String fileName)
    {
        Map<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("method", "uploadFile");
        String uploadUrl = UploadConfigCache.getFileUploadUrl();
        String url = fileUpload(uploadUrl, hashmap, new File(fileName));
        return url;
    }

    /**
     * 通过文件（input[type=file]）方式上传文件到服务器
     * @param url 文件上传地址
     * @param hashMap
     * @param multipartFile
     * @return
     */
    private static String fileUpload(String url, Map<String, String> hashMap, File file)
    {
        GooagooLog.info("Upload Client Send:" + new Gson().toJson(hashMap));

        HttpClient httpclient = null;
        String resultxml = "";
        try
        {
            httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            String tmpFileName = file.getName();//multipartFile.getOriginalFilename();
            MultipartEntity reqEntity = new MultipartEntity();
            byte[] fileByte = getBytesFromFile(file);//multipartFile.getBytes();
            reqEntity.addPart(HttpUploadUtils.UPLOAD_FILE_NAME, new ByteArrayBody(fileByte, tmpFileName));
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
                GooagooLog.info("result:错误编码:" + response.getStatusLine().getStatusCode());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            httpclient = null;
        }
        GooagooLog.info("Upload Client Recieve:" + new Gson().toJson(resultxml));
        return resultxml;
    }

    //文件转为字节数组
    private static byte[] getBytesFromFile(File f)
    {
        if (f == null)
        {
            return null;
        }
        try
        {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
            {
                out.write(b, 0, n);
            }
            stream.close();
            out.close();
            return out.toByteArray();
        }
        catch (IOException e)
        {
        }
        return null;
    }
}
