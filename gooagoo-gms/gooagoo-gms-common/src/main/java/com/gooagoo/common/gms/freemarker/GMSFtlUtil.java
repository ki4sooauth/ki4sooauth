package com.gooagoo.common.gms.freemarker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.common.gms.constants.TemplateConstant;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;

public class GMSFtlUtil
{
    /**
     * 直接把模板内容写入到输出流（整个html页面输出）
     * @param request
     * @param response
     * @param root
     * @param ftlName
     * @throws Exception
     */
    public static void outputHtmlContent(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root, String ftlName) throws Exception
    {
        response.setCharacterEncoding("UTF-8");

        GMSFtlUtil.putDefaultRequestParasToMap(request, root);

        FreemarkerUtil.print(ftlName, root, response.getWriter());
    }

    /**
     * 将模板内容转成字符串后再写入到输出流（局部html获取json字符串等输出）
     * @param request
     * @param response
     * @param root
     * @param ftlName
     * @throws Exception
     */
    public static void writeStringContent(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root, String ftlName) throws Exception
    {
        GMSFtlUtil.putDefaultRequestParasToMap(request, root);
        String content = FreemarkerUtil.getContent(ftlName, root);

        ServletUtils.writeHtml(content, response);
    }

    /**
     * 将营销模板内容写入输出流
     * @param request
     * @param response
     * @param root 参数
     * @param channel 渠道（见TemplateConstant.FTL_FILE_MARKETING_CHANNEL_）
     * @param operate 操作类型（见TemplateConstant.FTL_FILE_OPERATE_）
     * @throws Exception
     */
    public static void printMarketingFtl(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root, String channel, String operate) throws Exception
    {
        response.setCharacterEncoding("UTF-8");

        GMSFtlUtil.putDefaultRequestParasToMap(request, root);
        String ftlName = TemplateConstant.FTL_FILE_MARKETING_PREFIX + channel + "_" + operate + TemplateConstant.FTL_FILE_SUFFIX;

        FreemarkerUtil.print(ftlName, root, response.getWriter());
    }

    /**
     * 将营销模板内容通过字符串格式写入输出流
     * @param request
     * @param response
     * @param root 参数
     * @param channel 渠道（见TemplateConstant.FTL_FILE_MARKETING_CHANNEL_）
     * @param operate 操作类型（见TemplateConstant.FTL_FILE_OPERATE_）
     * @throws Exception
     */
    public static void printMarketingFtlByString(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root, String channel, String operate) throws Exception
    {
        response.setCharacterEncoding("UTF-8");

        GMSFtlUtil.putDefaultRequestParasToMap(request, root);
        String ftlName = TemplateConstant.FTL_FILE_MARKETING_PREFIX + channel + "_" + operate + TemplateConstant.FTL_FILE_SUFFIX;

        String content = FreemarkerUtil.getContent(ftlName, root);

        ServletUtils.writeHtml(content, response);
    }

    /**
     * 将request中的默认参数值放入map中
     * @param request
     * @param root map
     */
    public static void putDefaultRequestParasToMap(HttpServletRequest request, Map<String, Object> root)
    {
        List<String> paraNameList = new ArrayList<String>();
        paraNameList.add("imgPath");
        paraNameList.add("shopVo");
        paraNameList.add("basePath");
        putRequestParasToMap(request, paraNameList, root);
    }

    /**
     * 将request中的分页参数值放入map中
     * @param request
     * @param PageModel
     * @param root map
     */
    public static void putPageRequestParasToMap(HttpServletRequest request, PageModel pm, Map<String, Object> root)
    {
        root.put("pm", pm);
        if (pm == null)
        {
            pm = new PageModel();
            pm.setCount(0);
            pm.setPageIndex(1);
            pm.setPageSize(10);
        }
        root.put("pm", pm);
        root.put("page_cur", pm.getPageIndex());
        root.put("page_start", pm.getPageStart(5));
        root.put("page_end", pm.getPageEnd(5));
    }

    /**
     * 将request中的指定参数值放入map中
     * @param request
     * @param paraNameList 指定参数名称集合
     * @param root map
     */
    public static void putRequestParasToMap(HttpServletRequest request, List<String> paraNameList, Map<String, Object> root)
    {
        if (paraNameList == null)
        {
            return;
        }
        for (Iterator<String> iterator = paraNameList.iterator(); iterator.hasNext();)
        {
            String defaultValue = "";
            String para = iterator.next();
            Object value = request.getAttribute(para);
            if (value == null)
            {
                value = ServletRequestUtils.getStringParameter(request, para, defaultValue);
            }
            root.put(para, value);
        }
    }
}
