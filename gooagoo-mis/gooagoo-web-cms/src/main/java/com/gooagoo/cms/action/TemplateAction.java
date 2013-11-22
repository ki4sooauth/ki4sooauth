package com.gooagoo.cms.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.MisConfigCache;
import com.gooagoo.cms.constants.CMSConstant;
import com.gooagoo.cms.utils.CMSHttpUtils;
import com.gooagoo.cms.utils.CMSUtil;
import com.gooagoo.cms.utils.InterCmsConstants;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.ServletUtils;
import com.gooaoo.view.cms.MCmsContent;
import com.gooaoo.view.cms.MTemplateInfo;
import com.gooaoo.view.common.PageModel;
import com.google.gson.Gson;

@Controller
@RequestMapping("/template")
public class TemplateAction extends BaseAction
{
    /**
     * 编辑模板页面
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String cmsContentId = ServletRequestUtils.getStringParameter(request, "cmsContentId", "");
        String parentCmsContentId = ServletRequestUtils.getStringParameter(request, "parentCmsContentId", "");
        String cmsContentType = ServletRequestUtils.getStringParameter(request, "cmsContentType", "");
        String channelType = ServletRequestUtils.getStringParameter(request, "channelType", "");

        request.setAttribute("cmsContentId", cmsContentId);
        request.setAttribute("parentCmsContentId", parentCmsContentId);
        request.setAttribute("cmsContentType", cmsContentType);
        request.setAttribute("channelType", channelType);

        return "/template/index";
    }

    /**
     * 保存编辑好的模板内容
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String edit = ServletRequestUtils.getStringParameter(request, "edit", "");
        String fluid = ServletRequestUtils.getStringParameter(request, "fluid", "");

        request.setAttribute(CMSConstant.ESCAPE_STRING_TYPE_KEY, "N");

        Map<String, String> map = new HashMap<String, String>();
        map.put("publish", fluid);
        map.put("edit", edit);

        String templateData = new Gson().toJson(map);
        request.setAttribute("templateData", templateData);

        request.setAttribute(CMSConstant.ESCAPE_STRING_TYPE_KEY, "N");

        CMSUtil.ajaxSubmit(InterCmsConstants.I_CMS_CONTENT_UPDATE, request, response);
    }

    /**
     * 模板编辑页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=editForm")
    public String editForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String cmsContentId = ServletRequestUtils.getStringParameter(request, "cmsContentId", "");
        String templateType = ServletRequestUtils.getStringParameter(request, "templateType", "");
        String templateId = ServletRequestUtils.getStringParameter(request, "templateId", "");

        String templateData = "";
        if (StringUtils.hasText(cmsContentId))
        {
            templateData = this.getTemplateEditContent(request);
        }

        this.setCommonUrl(request);

        request.setAttribute("cmsContentId", cmsContentId);
        request.setAttribute("templateId", templateId);
        request.setAttribute("templateType", templateType);
        request.setAttribute("templateData", templateData);

        return "/template/template_edit";
    }

    /**
     * 模板预览页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=preview")
    public String preview(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String cmsContentId = ServletRequestUtils.getStringParameter(request, "cmsContentId", "");

        String templateData = this.getTemplateEditContent(request);

        this.setCommonUrl(request);

        request.setAttribute("cmsContentId", cmsContentId);
        request.setAttribute("templateData", templateData);

        return "/template/template_preview";
    }

    /**
     * 清空已有模板
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=clearTemplateForm")
    public void clearTemplateForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CMSUtil.ajaxSubmit(InterCmsConstants.I_CMS_CONTENT_UPDATE, request, response);
    }

    /**
     * cms内容信息列表（分页）
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = CMSHttpUtils.transfer(InterCmsConstants.I_CMS_TEMPLATE_LIST, request, PageModel.class);
        PageModel<MTemplateInfo> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return "/template/template_list";
    }

    /**
     * 模板列表
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=list")
    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<List> respObj = CMSHttpUtils.transfer(InterCmsConstants.I_CMS_TEMPLATE_LIST, request, List.class);
        List<MTemplateInfo> cmsContentList = respObj.getData();

        String json = new Gson().toJson(cmsContentList);
        ServletUtils.writeHtml(json, response);
    }

    /**
     * 获取模板编辑内容
     */
    private String getTemplateEditContent(HttpServletRequest request)
    {
        String templateId = ServletRequestUtils.getStringParameter(request, "templateId", "");

        String templateData = null;

        TransData<MCmsContent> respObj2 = CMSHttpUtils.transfer(InterCmsConstants.I_CMS_CONTENT_DETAIL, request, MCmsContent.class);
        if (respObj2.getHead().isSuccess() && respObj2.getData() != null)
        {
            String data = respObj2.getData().getTemplateData();
            if (StringUtils.hasText(data))
            {
                Map m = new Gson().fromJson(data, Map.class);
                templateData = (String) m.get("edit");
            }
        }

        return templateData;
    }

    private void setCommonUrl(HttpServletRequest request)
    {
        request.setAttribute("imgPath", MisConfigCache.get("html_url"));
        request.setAttribute("passport", MisConfigCache.get("passport_url"));
        request.setAttribute("ajax", MisConfigCache.get("ajax_url"));
    }

}
