package com.gooagoo.gmember.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.UploadConfigCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HttpUploadUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PictureProperty;
import com.google.gson.Gson;

/**
 * 上传下载
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cardUpload")
public class CardUploadAction extends BaseAction
{
    private String getUploadServerUrl()
    {
        String url = UploadConfigCache.getFileUploadUrl();
        if (!StringUtils.hasText(url))
        {
            GooagooLog.warn("===========CardUploadAction从缓存中获取文件上传服务访问地址为空");
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
    @RequestMapping(params = "method=uploadFile")
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setAttribute("method", HttpUploadUtils.UPLOAD_METHOD_FILE);
        request.setAttribute("module", "marketing");
        String uploadFilePath = this.getUploadServerUrl();
        GooagooLog.debug("fileUpload==uploadFile==start: serverUrl=" + uploadFilePath + ",parameters:" + new Gson().toJson(request.getParameterMap()));

        if (!StringUtils.hasText(uploadFilePath))
        {
            GooagooLog.warn("===========获取文件上传服务访问地址为空");
            return;
        }

        String pathUrl = HttpUploadUtils.uploadByFile(uploadFilePath, request);

        GooagooLog.debug("fileUpload==uploadFile==end: result=" + pathUrl);

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
        request.setAttribute("method", HttpUploadUtils.UPLOAD_METHOD_PATH);
        request.setAttribute("module", "marketing");
        String uploadFilePath = this.getUploadServerUrl();
        GooagooLog.debug("fileUpload==uploadPath==start: serverUrl=" + uploadFilePath + ",parameters:" + new Gson().toJson(request.getParameterMap()));
        if (!StringUtils.hasText(uploadFilePath))
        {
            GooagooLog.warn("===========获取文件上传服务访问地址为空");
            return;
        }
        String pathUrl = HttpUploadUtils.uploadByPath(uploadFilePath, request);

        GooagooLog.debug("fileUpload==uploadPath==end: result=" + pathUrl);

        ServletUtils.writeHtml(pathUrl, response);
    }

}