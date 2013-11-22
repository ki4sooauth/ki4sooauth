package com.gooagoo.common.gms.marketing;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.constants.TemplateConstant;
import com.gooagoo.common.gms.freemarker.GMSFtlUtil;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.marketing.FEvent;

public class UEvent
{
    /**
     * 创建
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    public static void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_EVENT_ADD, request, response);
    }

    /**
     * 修改
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    public static void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_EVENT_UPDATE, request, response);
    }

    /**
     * 内容编辑
     * @param request
     * @param response
     * @param root 页面参数
     * @throws Exception
     */
    public static void form(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root) throws Exception
    {
        putDetailParas(request, response, root);

        GMSFtlUtil.printMarketingFtlByString(request, response, root, TemplateConstant.FTL_FILE_MARKETING_CHANNEL_EVENT, TemplateConstant.FTL_FILE_OPERATE_FORM);
    }

    /**
     * 事件详细
     * @param request
     * @param response
     * @param root 页面参数
     * @throws Exception
     */
    public static void detail(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root) throws Exception
    {
        putDetailParas(request, response, root);

        GMSFtlUtil.printMarketingFtlByString(request, response, root, TemplateConstant.FTL_FILE_MARKETING_CHANNEL_EVENT, TemplateConstant.FTL_FILE_OPERATE_DETAIL);
    }

    /**
     * 删除
     * @param request
     * @param response
     * @return
     */
    public static void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_EVENT_DELETE, request, response);
    }

    /**
     * 审核内容编辑
     * @param request
     * @param response
     * @param root 页面参数
     * @return
     */
    public static void formCheck(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root) throws Exception
    {
        TransData<FEvent> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_EVENT_DETAIL, request, FEvent.class);
        FEvent event = respObj.getData();
        root.put("event", event);

        GMSFtlUtil.printMarketingFtl(request, response, root, TemplateConstant.FTL_FILE_MARKETING_CHANNEL_EVENT, TemplateConstant.FTL_FILE_OPERATE_APPROVE);
    }

    /**
     * 审核
     * @param request
     * @param response
     * @return
     */
    public static void check(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_EVENT_CHECK, request, response);
    }

    /**
     * 获取详情参数
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private static void putDetailParas(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root) throws Exception
    {
        String contId = ServletRequestUtils.getStringParameter(request, "contId", "");
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");

        FEvent event = null;
        if (StringUtils.hasText(contId))
        {
            request.setAttribute("id", contId);//TODO 将igms中的参数换成contId并删除此内容
            TransData<FEvent> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_EVENT_FORM, request, FEvent.class);
            event = respObj.getData();
        }
        if (event == null)
        {
            event = GMSUtil.getBlankObject(FEvent.class);
        }
        root.put("channelCode", channelCode);
        root.put("event", event);
    }
}
