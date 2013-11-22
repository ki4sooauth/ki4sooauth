package com.gooagoo.mis.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gooagoo.cache.UploadConfigCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HttpUploadUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.general.PictureProperty;

/**
 * 上传下载
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/upload")
public class UploadAction
{

    private String getUploadServerUrl()
    {
        String url = UploadConfigCache.getFileUploadUrl();
        if (!StringUtils.hasText(url))
        {
            GooagooLog.warn("===========从缓存中获取文件上传服务访问地址为空");
            GooagooLog.warn("===========启用默认地址：http://upload.goo.com/upload.do");
            url = "http://upload.goo.com/upload.do";
        }
        return url;
    }

    /**
     * 
     * @param request
     * 
     * src 裁剪图片地址
     * tsize 裁剪图片缩放大小（支持多个），传值格式：裁剪图片英文别名_宽_高（如，big_400_300）
     * 
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=toTrimImage")
    public String toTrimImage(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        List<PictureProperty> picList = new ArrayList<PictureProperty>();

        String src = ServletRequestUtils.getStringParameter(request, "src", "");
        String[] size = request.getParameterValues("tsize");
        if (size != null && size.length > 0)
        {
            for (int i = 0; i < size.length; i++)
            {
                String[] ss = size[i].split("_");
                PictureProperty p = new PictureProperty();
                p.setName(ss[0]);
                p.setWidth(Integer.parseInt(ss[1]));
                p.setHeight(Integer.parseInt(ss[2]));
                picList.add(p);
            }
        }

        request.setAttribute("previews", picList);
        request.setAttribute("url", src);

        return "upload/jcroup";
    }

    /**
     * 通过文件流来上传图片（始终保存一份原图，有裁剪条件的先进行裁剪，缩放操作将在裁剪后的图片上进行，缩放后会保存成新图片）
     * 
     * @param request
     * fileName 上传文件属性名称（input[type=file][name=filename]，必填）
     * 
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=uploadFile", method = RequestMethod.POST)
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        this.getUploadMap(request);
        request.setAttribute("method", HttpUploadUtils.UPLOAD_METHOD_FILE);
        String pathUrl = HttpUploadUtils.uploadByFile(this.getUploadServerUrl(), request);

        GooagooLog.debug("========url=" + pathUrl);

        ServletUtils.writeHtml(pathUrl, response);
    }

    /**
     * 通过服务器上图片访问路径来上传图片（始终保存一份原图，有裁剪条件的先进行裁剪，缩放操作将在裁剪后的图片上进行，缩放后会保存成新图片）
     * 
     * @param request
     * filePath 原图访问地址（已经上传过的将覆盖原图，必填）
     * 
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=uploadPath")
    public void uploadPath(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        this.getUploadMap(request);
        request.setAttribute("method", HttpUploadUtils.UPLOAD_METHOD_FILE);
        String pathUrl = HttpUploadUtils.uploadByPath(UploadConfigCache.getFileUploadUrl(), request);

        GooagooLog.debug("========url=" + pathUrl);

        ServletUtils.writeHtml(pathUrl, response);
    }

    /**
     * 上传文件参数初始化
     * @param request
     * 
     * fileName 上传文件属性名称（input[type=file][name=filename]）
     * filePath 原图访问地址（已经上传过的将覆盖原图，为空或通过地址找不到图片的产生新图片）
     * 
     * width 指定原图的宽度
     * height 指定原图的高度
     * module 上传图片用来存放的文件夹
     * 
     * trim_x 裁剪的图片左上角离原图左端的距离
     * trim_y 裁剪的图片左上角离原图顶端的距离
     * trim_w 裁剪的图片的宽度（为空不裁剪）
     * trim_h 裁剪的图片的高度（为空不裁剪）
     * 
     * scale_XX（XX为自定义字符） 新增缩放图片
     *         以scale_开头
     *         XX为缩放后图片后缀名称（缩放后的图片将添加此后缀，如原图名称为124.jpg,经过缩放[scale_big]后的图片名称为124_big.jpg）
     *         可以指定多个，重名采用后者
     *         传值的格式为：宽_高（以下划线分割宽高，无效将不进行缩放）   如scale_big = 800_600
     *        
     * @param request
     * @return
     */
    private void getUploadMap(HttpServletRequest request)
    {
        String type = ServletRequestUtils.getStringParameter(request, "type", "");
        if ("coupon".equals(type))
        {
            request.setAttribute("width", "640");
            request.setAttribute("height", "422");
            request.setAttribute("scale_big", "300_200");
            request.setAttribute("scale_middle", "90_60");
            request.setAttribute("scale_small", "30_20");
        }
        else if ("action".equals(type))
        {
            request.setAttribute("width", "400");
            request.setAttribute("height", "150");
            request.setAttribute("scale_big", "800_300");
            request.setAttribute("scale_middle", "80_30");
            request.setAttribute("scale_small", "40_15");
        }
        if ("mobile".equals(type))
        {
            request.setAttribute("module", "client");
        }
        else
        {
            request.setAttribute("module", "mis");
        }
    }

}
