package com.gooagoo.active.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.cache.MisConfigCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.common.PageModel;
import com.gooagoo.view.gms.common.FNode;
import com.gooagoo.view.gms.common.GAjax;
import com.gooagoo.view.gms.marketing.FEvent;
import com.google.gson.Gson;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/template")
public class TemplateAction
{
    /**
     * 模板首页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String contId = ServletRequestUtils.getStringParameter(request, "contId", "");
        String contentType = ServletRequestUtils.getStringParameter(request, "contentType", "");
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");//内容渠道编码
        String templateChannel = ServletRequestUtils.getStringParameter(request, "templateChannel", "");//模板渠道

        request.setAttribute("contId", contId);
        request.setAttribute("contentType", contentType);
        request.setAttribute("channelCode", channelCode);
        request.setAttribute("templateChannel", templateChannel);

        return "template/template_index";
    }

    /**
     * 模板列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        PageModel<FNode> pm = null;

        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_TEMPLATE_LIST, request, PageModel.class);
        if (respObj.getHead().isSuccess())
        {
            pm = respObj.getData();
        }
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return "template/template_list";
    }

    /**
     * 模板编辑页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=edit")
    public String edit(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String contId = ServletRequestUtils.getStringParameter(request, "contId", "");
        String templateId = ServletRequestUtils.getStringParameter(request, "templateId", "");
        String contentType = ServletRequestUtils.getStringParameter(request, "contentType", "");
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");//内容渠道编码

        String templateData = this.getTemplateEditContent(request, contentType, null);
        String templateType = "";
        if ("4".equals(channelCode))
        {
            templateType = "W";
        }
        if ("5".equals(channelCode) || "6".equals(channelCode))
        {
            templateType = "M";
        }

        this.setCommonUrl(request);

        request.setAttribute("channelCode", channelCode);
        request.setAttribute("contId", contId);
        request.setAttribute("marketingId", contId);
        request.setAttribute("contentType", contentType);
        request.setAttribute("templateId", templateId);
        request.setAttribute("templateData", templateData);
        request.setAttribute("templateType", templateType);

        return "template/template_edit";
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
        String contId = ServletRequestUtils.getStringParameter(request, "contId", "");
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");
        String contentType = ServletRequestUtils.getStringParameter(request, "contentType", "");

        String templateData = this.getTemplateEditContent(request, contentType, null);

        this.setCommonUrl(request);
        request.setAttribute("contId", contId);
        request.setAttribute("channelCode", channelCode);
        request.setAttribute("contentType", contentType);
        request.setAttribute("templateData", templateData);

        return "template/template_preview";
    }

    /**
     * 模板内容保存
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=saveContent")
    public void saveContent(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String contentType = ServletRequestUtils.getStringParameter(request, "contentType", "");
        String contId = ServletRequestUtils.getStringParameter(request, "contId", "");

        request.setAttribute(GMSConstant.ESCAPE_STRING_TYPE_KEY, "N");

        if ("E".equals(contentType))
        {
            request.setAttribute("eventId", contId);
            request.setAttribute("updateType", "template");
            GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_EVENT_UPDATE, request, response);
        }
        else
        {
            String resultName = ExceptionCache.get(MessageConst.GMS_OPERATE_FAIL);
            GAjax rv = new GAjax(false, resultName);
            String result = new Gson().toJson(rv);
            ServletUtils.writeHtml(result, response);
        }
    }

    /**
     * 获取模板编辑内容
     */
    private String getTemplateEditContent(HttpServletRequest request, String contentType, String templateData)
    {
        String contId = ServletRequestUtils.getStringParameter(request, "contId", "");
        request.setAttribute("id", contId);

        if (!StringUtils.hasText(templateData) && "E".equals(contentType))
        {
            TransData<FEvent> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_EVENT_DETAIL, request, FEvent.class);
            if (respObj.getHead().isSuccess() && respObj.getData() != null)
            {
                templateData = respObj.getData().getTemplateData();
            }
        }
        if (StringUtils.hasText(templateData))
        {
            Map m = new Gson().fromJson(templateData, Map.class);
            templateData = (String) m.get("edit");
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
