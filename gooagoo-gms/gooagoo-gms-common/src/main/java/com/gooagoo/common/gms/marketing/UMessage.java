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
import com.gooagoo.view.gms.message.FShortMessage;

public class UMessage
{

    /**
     * 创建短信信息
     * @param request
     * @param response
     * @param releaseLog
     * @param cryoutInfo
     */
    public static void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHORTMESSAGE_ADD, request, response);
    }

    /**
     * 修改短信信息
     * @param request
     * @param response
     * @throws Exception
     */
    public static void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHORTMESSAGE_UPDATE, request, response);
    }

    /**
     * 编辑短信信息
     * @param request
     * @param response
     * @param root 页面参数
     * @throws Exception
     */
    public static void form(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root) throws Exception
    {
        putDetailParas(request, response, root);

        GMSFtlUtil.printMarketingFtlByString(request, response, root, TemplateConstant.FTL_FILE_MARKETING_CHANNEL_MESSAGE, TemplateConstant.FTL_FILE_OPERATE_FORM);
    }

    /**
     * 查看短信详细
     * @param request
     * @param response
     * @param root 页面参数
     * @throws Exception
     */
    public static void detail(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root) throws Exception
    {
        putDetailParas(request, response, root);

        GMSFtlUtil.printMarketingFtlByString(request, response, root, TemplateConstant.FTL_FILE_MARKETING_CHANNEL_MESSAGE, TemplateConstant.FTL_FILE_OPERATE_DETAIL);
    }

    /**
     * 删除短信信息
     * @param request
     * @param response
     * @throws Exception
     */
    public static void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHORTMESSAGE_DELETE, request, response);
    }

    /**
     * 审核内容页
     * @param request
     * @param response
     * @param root 页面参数
     * @return
     */
    public static void formCheck(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root) throws Exception
    {
        TransData<FShortMessage> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHORTMESSAGE_DETAIL, request, FShortMessage.class);
        FShortMessage message = respObj.getData();
        root.put("message", message);

        GMSFtlUtil.printMarketingFtl(request, response, root, TemplateConstant.FTL_FILE_MARKETING_CHANNEL_MESSAGE, TemplateConstant.FTL_FILE_OPERATE_APPROVE);
    }

    /**
     * 审核
     * @param request
     * @param response
     * @return
     */
    public static void check(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHORTMESSAGE_CHECK, request, response);
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

        FShortMessage shortMessage = null;
        if (StringUtils.hasText(contId))
        {
            request.setAttribute("id", contId);//TODO 将igms中的参数换成contId并删除此内容
            TransData<FShortMessage> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHORTMESSAGE_DETAIL, request, FShortMessage.class);
            shortMessage = respObj.getData();
        }
        if (shortMessage == null)
        {
            shortMessage = GMSUtil.getBlankObject(FShortMessage.class);
        }

        root.put("message", shortMessage);
    }
}
