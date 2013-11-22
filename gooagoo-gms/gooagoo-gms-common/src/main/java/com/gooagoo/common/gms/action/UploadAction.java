package com.gooagoo.common.gms.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.UploadConfigCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gms.constants.TemplateConstant;
import com.gooagoo.common.gms.freemarker.GMSFtlUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HttpUploadUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PictureProperty;

/**
 * 上传下载
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/upload")
public class UploadAction extends BaseAction
{
    private String getUploadServerUrl()
    {
        String url = UploadConfigCache.getFileUploadUrl();
        if (!StringUtils.hasText(url))
        {
            GooagooLog.warn("===========从缓存中获取文件上传服务访问地址为空");
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
    public void toTrimImage(HttpServletRequest request, HttpServletResponse response) throws Exception
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

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("previews", picList);
        root.put("url", src);

        GMSFtlUtil.outputHtmlContent(request, response, root, TemplateConstant.FTL_FILE_COMMON_UPLOAD);
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
        this.freshModule(request);
        String uploadFilePath = this.getUploadServerUrl();

        if (!StringUtils.hasText(uploadFilePath))
        {
            GooagooLog.warn("===========获取文件上传服务访问地址为空");
            return;
        }
        String pathUrl = HttpUploadUtils.uploadByFile(uploadFilePath, request);

        ServletUtils.writeHtml(pathUrl, response);
    }

    /**
     * 通过文件流来上传并zip格式压缩文件
     * 
     * @param request
     * fileName 上传文件属性名称（input[type=file][name=filename]，必填）
     * 
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=zipFile")
    public void zipFile(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        this.freshModule(request);
        String uploadFilePath = this.getUploadServerUrl();

        if (!StringUtils.hasText(uploadFilePath))
        {
            GooagooLog.warn("===========获取文件上传服务访问地址为空");
            return;
        }
        String pathUrl = HttpUploadUtils.zipFile(uploadFilePath, request);

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
        this.freshModule(request);
        String uploadFilePath = this.getUploadServerUrl();

        if (!StringUtils.hasText(uploadFilePath))
        {
            GooagooLog.warn("===========获取文件上传服务访问地址为空");
            return;
        }
        String pathUrl = HttpUploadUtils.uploadByPath(uploadFilePath, request);

        ServletUtils.writeHtml(pathUrl, response);
    }

    /**
     * 更新module值
     * @param request
     */
    private void freshModule(HttpServletRequest request)
    {
        String module = (String) request.getAttribute("module");
        if (module == null)
        {
            module = request.getParameter("module");
        }
        if (!StringUtils.hasText(module))
        {
            module = "marketing";
        }
        request.setAttribute("module", module);
    }

}
