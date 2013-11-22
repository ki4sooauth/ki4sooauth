package com.gooagoo.common.utils;

import java.util.ArrayList;
import java.util.Enumeration;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.gooagoo.common.log.GooagooLog;
import com.google.gson.Gson;

public class HttpUploadUtils
{
    public final static String UPLOAD_FILE_NAME = "fileName";
    public final static String UPLOAD_PATH_NAME = "filePath";
    public final static String UPLOAD_METHOD_FILE = "uploadFile";
    public final static String UPLOAD_METHOD_PATH = "uploadPath";
    public final static String UPLOAD_METHOD_ZIP = "zipFile";

    /**
     * 通过文件（input[type=file]）方式上传文件到服务器(支持多个文件同时上传，有裁剪条件的先进行裁剪，垂直分割或缩放操作将在裁剪后的图片上进行，垂直分割或缩放后会保存成新图片)
     * 非图片文档（PDF/ZIP/PPT/PPTX/DOC/DOCX/XLS/XLSX/SVG/HTML）直接上传（request中的参数：method=uploadFile&module=doc）
     * @param url 文件上传服务器请求地址
     * @param request
     * 上传的文件属性名称为fileName(CommonsMultipartFile[name=fileName])
     * 
     * 【1】request中的传入参数（包括Parameter和Attribute，不含上传的文件参数）示例：
     * 示例1：上传原图（module为图片保存的文件夹名称，此以marketing项目为例）
     * request中的参数：method=uploadFile&module=marketing
     * 
     * 示例2：更新指定路径的图片（指定路径图片被覆盖）
     * request中的参数：method=uploadFile&module=marketing&filePath=http://html.gooagoo.com/upload/marketing/2013/08/20/2E37E5F9894B682F70CFA2E3AD9BD1A8.jpg
     * 
     * 示例3：将上传的图片A缩放到100*100大小后进行保存
     * request中的参数：method=uploadFile&module=marketing&width=100&height=100
     * 
     * 示例4：将上传的图片A按左上角为原点向左10px向下20px的坐标为起点向左下方向裁剪成宽200px高200px的图片，然后缩放到100*100大小后进行保存
     * request中的参数：method=uploadFile&module=marketing&width=100&height=100&trim_x=10&trim_y=20&trim_w=200&trim_h=200
     * 
     * 示例5：将上传的图片A按左上角为原点向左10px向下20px的坐标为起点向左下方向裁剪成宽200px高200px的图片，保存为图片B(图片路径http://html...9BD1A8.jpg)，
     *      且将图B按100*100和60*60的大小进行缩放保存成为图片路径为http://html...9BD1A8_m.jpg和http://html...9BD1A8_s.jpg的新图片
     * request中的参数：method=uploadFile&module=marketing&trim_x=10&trim_y=20&trim_w=200&trim_h=200&scale_m=100_100&scale_s=60_60
     * 
     * 示例6：将上传的图片A按左上角为原点向左10px向下20px的坐标为起点向左下方向裁剪成宽200px高200px的图片，然后缩放到150*150大小后进行保存为图片B(图片路径http://html...9BD1A8.jpg)，
     *      且将图B按100*100和60*60的大小进行缩放保存成为图片路径为http://html...9BD1A8_m.jpg和http://html...9BD1A8_s.jpg的新图片
     * request中的参数：method=uploadFile&module=marketing&width=150&height=150&trim_x=10&trim_y=20&trim_w=200&trim_h=200&scale_m=100_100&scale_s=60_60
     * 
     * 示例7：将上传的图片A按左上角为原点向左10px向下20px的坐标为起点向左下方向裁剪成宽200px高200px的图片，然后缩放到150*150大小保存为图片B(图片路径http://html...9BD1A8.jpg)，
     *      且将图B按50px的垂直高度进行上下切割保存成高50px和高100px的两张图，其图片路径分别为http://html...9BD1A8_dh_top.jpg和http://html...9BD1A8_dh_bottom.jpg
     *      且将图B按100*100和60*60的大小进行缩放保存成为图片路径为http://html...9BD1A8_m.jpg和http://html...9BD1A8_s.jpg的新图片
     * request中的参数：method=uploadFile&module=marketing&width=150&height=150&trim_x=10&trim_y=20&trim_w=200&trim_h=200&scale_m=100_100&scale_s=60_60&divided_h=50
     * 
     * 【2】request中的具体参数（包括Parameter和Attribute）说明：
     * width 指定原图的宽度，为空或0保持原图大小
     * height 指定原图的高度，为空或0保持原图大小
     * module 上传图片用来存放的文件夹
     * filePath 原图访问地址（已经上传过的图片路径，为空或通过地址找不到图片的产生新图片）
     * trim_x 裁剪的图片左上角离原图左端的距离
     * trim_y 裁剪的图片左上角离原图顶端的距离
     * trim_w 裁剪的图片的宽度（为空不裁剪）
     * trim_h 裁剪的图片的高度（为空不裁剪）
     * divided_h 垂直分割图片的分割高度（分割生成的图片不进行缩放），为空不分割
     *                  生效条件：需要指定图片宽高或裁剪宽高 ，且divided_h的值不等于0
     *                  生成新图：上部分图片访问地址=原图路径_dh_top.[jpg]，下部分图片访问地址=原图路径_dh_bottom.[jpg]
     * scale_XX（XX为自定义字符） 新增缩放图片，不为空不新增缩放图片
     *         以scale_开头
     *         XX为缩放后图片后缀名称（缩放后的图片将添加此后缀，如原图名称为124.jpg,经过缩放[scale_big]后的图片名称为124_big.jpg）
     *         可以指定多个，重名采用后者
     *         传值的格式为：宽_高（以下划线分割宽高，无效将不进行缩放）   如scale_big = 800_600
     *         
     * @return 多个文件访问地址以逗号分隔
     */
    public static String uploadByFile(String url, HttpServletRequest request)
    {
        Map<String, String> hashMap = getUploadParameterMap(request);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        hashMap.put("method", HttpUploadUtils.UPLOAD_METHOD_FILE);

        return uploadByCommonsMultipartFiles(url, hashMap, multipartRequest);
    }

    /**
     * 通过服务器上文件访问路径来上传文件(同时只能上传一个文件，有裁剪条件的先进行裁剪，垂直分割或缩放操作将在裁剪后的图片上进行，垂直分割或缩放后会保存成新图片)
     * @param url 文件上传服务器请求地址
     * @param request
     * 
     * 【1】request中的传入参数（包括Parameter和Attribute）示例：
     * 原图A路径http://html.gooagoo.com/upload/marketing/2013/08/20/2E37E5F9894B682F70CFA2E3AD9BD1A8.jpg简写成http://html...9BD1A8.jpg
     * 
     * 示例1：将原图A缩放成100*100大小后进行保存（原图被覆盖）
     * request中的参数：method=uploadPath&module=marketing&filePath=http://html...9BD1A8.jpg&useSameFile=Y&width=100&height=100
     * 
     * 示例2：将原图A缩放成100*100大小后保存成新图B（原图不变），新图路径http://html...12665D.jpg
     * request中的参数：method=uploadPath&module=marketing&filePath=http://html...9BD1A8.jpg&useSameFile=N&width=100&height=100
     * 
     * 示例3：将原图A缩放成100*100大小后保存成关联新图C（原图不变），关联新图路径基于原图，路径为http://html...9BD1A8_n.jpg
     * request中的参数：method=uploadPath&module=marketing&filePath=http://html...9BD1A8.jpg&useSameFile=AN&width=100&height=100
     * 
     * 示例4：将原图A按左上角为原点向左10px向下20px的坐标为起点向左下方向裁剪成宽200px高200px的图片，然后缩放到100*100大小后保存成新图B
     * request中的参数：method=uploadPath&module=marketing&filePath=http://html...9BD1A8.jpg&useSameFile=N&width=100&height=100&trim_x=10&trim_y=20&trim_w=200&trim_h=200
     * 
     * 示例5：将原图A按左上角为原点向左10px向下20px的坐标为起点向左下方向裁剪成宽200px高200px的图片，保存为图片B(图片路径http://html...12665D.jpg)，
     *      且将图B按100*100和60*60的大小进行缩放保存成为图片路径为http://html...12665D_m.jpg和http://html...12665D_s.jpg的新图片
     * request中的参数：method=uploadPath&module=marketing&filePath=http://html...9BD1A8.jpg&useSameFile=N&trim_x=10&trim_y=20&trim_w=200&trim_h=200&scale_m=100_100&scale_s=60_60
     * 
     * 示例6：将原图A按左上角为原点向左10px向下20px的坐标为起点向左下方向裁剪成宽200px高200px的图片，然后缩放到150*150大小后进行保存为图片B(图片路径http://html...12665D.jpg)，
     *      且将图B按100*100和60*60的大小进行缩放保存成为图片路径为http://html...12665D_m.jpg和http://html...12665D_s.jpg的新图片
     * request中的参数：method=uploadPath&module=marketing&filePath=http://html...9BD1A8.jpg&useSameFile=N&width=150&height=150&trim_x=10&trim_y=20&trim_w=200&trim_h=200&scale_m=100_100&scale_s=60_60
     * 
     * 示例7：将原图A按左上角为原点向左10px向下20px的坐标为起点向左下方向裁剪成宽200px高200px的图片，然后缩放到150*150大小后进行保存为图片B(图片路径http://html...12665D.jpg)，
     *      且将图B按50px的垂直高度进行上下切割保存成高50px和高100px的两张图，其图片路径分别为http://html...12665D_dh_top.jpg和http://html...12665D_dh_bottom.jpg
     *      且将图B按100*100和60*60的大小进行缩放保存成为图片路径为http://html...12665D_m.jpg和http://html...12665D_s.jpg的新图片
     * request中的参数：method=uploadPath&module=marketing&filePath=http://html...9BD1A8.jpg&useSameFile=N&width=150&height=150&trim_x=10&trim_y=20&trim_w=200&trim_h=200&scale_m=100_100&scale_s=60_60&divided_h=50
     * 
     * 示例8：将原图A按左上角为原点向左10px向下20px的坐标为起点向左下方向裁剪成宽200px高200px的图片，然后缩放到150*150大小后进行保存为关联图片B(图片路径http://html...9BD1A8_n.jpg)，
     *      且将图B按50px的垂直高度进行上下切割保存成高50px和高100px的两张图，其图片路径分别为http://html...9BD1A8_n_dh_top.jpg和http://html...9BD1A8_n_dh_bottom.jpg
     *      且将图B按100*100和60*60的大小进行缩放保存成为图片路径为http://html...9BD1A8_n_m.jpg和http://html...9BD1A8_n_s.jpg的新图片
     * request中的参数：method=uploadPath&module=marketing&filePath=http://html...9BD1A8.jpg&useSameFile=AN&width=150&height=150&trim_x=10&trim_y=20&trim_w=200&trim_h=200&scale_m=100_100&scale_s=60_60&divided_h=50
     * 
     * 【2】request中的具体参数（包括Parameter和Attribute）说明：
     * filePath 原图访问地址（已经上传过的图片路径，必填）
     * useSameFile Y-覆盖原图，不生成新图(1.jpg)；AN-保留原图，生成新图，且新图路径等于原来路径加"_n"(1_n.jpg)；N-保留原图，生成新图(2.jpg)（默认为N）
     * width 指定原图的宽度，为空或0保持原图大小
     * height 指定原图的高度，为空或0保持原图大小
     * module 上传图片用来存放的文件夹
     * trim_x 裁剪的图片左上角离原图左端的距离
     * trim_y 裁剪的图片左上角离原图顶端的距离
     * trim_w 裁剪的图片的宽度（为空不裁剪）
     * trim_h 裁剪的图片的高度（为空不裁剪）
     * divided_h 垂直分割图片的分割高度（分割生成的图片不进行缩放），为空不分割
     *                  生效条件：需要指定图片宽高或裁剪宽高 ，且divided_h的值不等于0
     *                  生成新图：上部分图片访问地址=原图路径_dh_top.[jpg]，下部分图片访问地址=原图路径_dh_bottom.[jpg](此处的原图路径是指通过useSameFile类型产生的文件路径)
     * scale_XX（XX为自定义字符） 新增缩放图片，不为空不新增缩放图片
     *         以scale_开头
     *         XX为缩放后图片后缀名称（缩放后的图片将添加此后缀，如原图名称为124.jpg,经过缩放[scale_big]后的图片名称为124_big.jpg）
     *         可以指定多个，重名采用后者
     *         传值的格式为：宽_高（以下划线分割宽高，无效将不进行缩放）   如scale_big = 800_600
     *         
     * @return 文件访问地址
     */
    public static String uploadByPath(String url, HttpServletRequest request)
    {
        Map<String, String> hashMap = getUploadParameterMap(request);
        hashMap.put("method", HttpUploadUtils.UPLOAD_METHOD_PATH);

        String result = uploadToServer(url, hashMap, null);

        return result;
    }

    /**
     * 通过文件（input[type=file]）方式上传文件到服务器并压缩成ZIP格式(支持多个文件同时上传)
     * @param url 文件上传服务器请求地址
     * @param request
     * 上传的文件属性名称为fileName(CommonsMultipartFile[name=fileName])
     * 
     * 【1】request中的传入参数（不含上传的文件参数）示例：
     * 示例1：上传原上传（module为上传保存的文件夹名称，此以marketing项目为例）
     * request中的post参数：method=zipFile&module=marketing
     * 
     * 示例2：更新指定路径的ZIP文件上传（指定路径图片被覆盖）
     * request中的post参数：method=zipFile&module=marketing&filePath=http://img.gooagoo.com/upload/marketing/2013/08/20/2E37E5F9894B682F70CFA2E3AD9BD1A8.zip
     * 
     * 【2】request中的具体参数说明：
     * filePath 原文件访问地址（已经上传过的文件路径，为空或通过地址找不到文件的产生新文件）
     * module 上传文件用来存放的文件夹
     * 
     * @param response
     * @throws Exception
     *         
     * @return 压缩后文件的访问地址，多个文件访问地址以逗号分隔
     */
    public static String zipFile(String url, HttpServletRequest request)
    {
        Map<String, String> hashMap = getUploadParameterMap(request);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        hashMap.put("method", HttpUploadUtils.UPLOAD_METHOD_ZIP);

        return uploadByCommonsMultipartFiles(url, hashMap, multipartRequest);
    }

    /**
     * 多文件上传
     * @param url 文件上传服务器请求地址
     * @param request
     * @return 多个文件访问地址以逗号分隔
     */
    private static String uploadByCommonsMultipartFiles(String url, Map<String, String> map, MultipartHttpServletRequest multipartRequest)
    {
        StringBuilder builder = new StringBuilder();
        List<CommonsMultipartFile> fileList = getUploadFile(multipartRequest);
        for (CommonsMultipartFile mFile : fileList)
        {
            String result = uploadToServer(url, map, mFile);
            if (result != null)
            {
                if (builder.length() == 0)
                {
                    builder.append(result);
                }
                else
                {
                    builder.append(",");
                    builder.append(result);
                }
            }
        }
        GooagooLog.debug("uploadByCommonsMultipartFiles:result=" + builder.toString());

        return builder.toString();
    }

    /**
     * 获取上传文件对象列表
     * @param multipartRequest
     * @return
     */
    private static List<CommonsMultipartFile> getUploadFile(MultipartHttpServletRequest multipartRequest)
    {
        List<CommonsMultipartFile> fileResult = new ArrayList<CommonsMultipartFile>();
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
     * 从request中获取传入参数（包括parameter和attribute,且其值需为String类型）
     * @param request
     * @return
     */
    @SuppressWarnings("rawtypes")
    private static Map<String, String> getUploadParameterMap(HttpServletRequest request)
    {
        Map<String, String> m = new HashMap<String, String>();
        Map pmap = request.getParameterMap();
        for (Iterator iterator = pmap.keySet().iterator(); iterator.hasNext();)
        {
            String key = (String) iterator.next();
            m.put(key, request.getParameter(key));
        }
        Enumeration attributeNames = request.getAttributeNames();
        while (attributeNames != null && attributeNames.hasMoreElements())
        {
            String name = (String) attributeNames.nextElement();
            Object attribute = request.getAttribute(name);
            if (attribute != null && (attribute instanceof String || attribute instanceof String[] || attribute instanceof Integer || attribute instanceof Integer[]))
            {
                m.put(name, (String) attribute);
            }
        }
        return m;
    }

    /**
     * 上传文件到服务器
     * @param url 文件上传服务器的访问地址
     * @param hashMap
     * @param multipartFile 为空则为通过服务器上的文件访问路径来上传文件
     * @return 文件的访问地址
     */
    private static String uploadToServer(String url, Map<String, String> hashMap, CommonsMultipartFile multipartFile)
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
            if (multipartFile != null)
            {
                String tmpFileName = multipartFile.getOriginalFilename();
                byte[] fileByte = multipartFile.getBytes();
                reqEntity.addPart(HttpUploadUtils.UPLOAD_FILE_NAME, new ByteArrayBody(fileByte, tmpFileName));
            }
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
                GooagooLog.warn("上传文件，result:错误编码:" + response.getStatusLine().getStatusCode() + ",paras:" + new Gson().toJson(hashMap));
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("上传文件异常,paras:" + new Gson().toJson(hashMap), e);
        }
        finally
        {
            httpclient = null;
        }

        GooagooLog.debug("Upload Client Recieve:" + new Gson().toJson(resultxml));

        return resultxml;
    }
}
