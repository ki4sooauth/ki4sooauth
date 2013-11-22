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
import com.gooagoo.view.gms.notice.FNotice;

public class UNotice
{

    /**
     * 通知内容的创建
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    public static void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_NOTICE_ADD, request, response);
    }

    /**
     * 修改通知信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    public static void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_NOTICE_UPDATE, request, response);
    }

    /**
     * 编辑通知信息
     * @param request
     * @param response
     * @param root 页面参数
     * @throws Exception
     */
    public static void form(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root) throws Exception
    {
        putDetailParas(request, response, root);

        GMSFtlUtil.printMarketingFtlByString(request, response, root, TemplateConstant.FTL_FILE_MARKETING_CHANNEL_NOTICE, TemplateConstant.FTL_FILE_OPERATE_FORM);
    }

    /**
     * 查看通知详细
     * @param request
     * @param response
     * @param root 页面参数
     * @throws Exception
     */
    public static void detail(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root) throws Exception
    {
        putDetailParas(request, response, root);

        GMSFtlUtil.printMarketingFtlByString(request, response, root, TemplateConstant.FTL_FILE_MARKETING_CHANNEL_NOTICE, TemplateConstant.FTL_FILE_OPERATE_DETAIL);
    }

    /**
     * 删除通知信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    public static void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_NOTICE_DELETE, request, response);
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
        TransData<FNotice> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_NOTICE_DETAIL, request, FNotice.class);
        FNotice fNotice = respObj.getData();
        root.put("notice", fNotice);

        GMSFtlUtil.printMarketingFtl(request, response, root, TemplateConstant.FTL_FILE_MARKETING_CHANNEL_NOTICE, TemplateConstant.FTL_FILE_OPERATE_APPROVE);
    }

    /**
     * 审核
     * @param request
     * @param response
     * @return
     */
    public static void check(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_NOTICE_CHECK, request, response);
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

        FNotice notice = null;
        if (StringUtils.hasText(contId))
        {
            request.setAttribute("id", contId);//TODO 将igms中的参数换成contId并删除此内容
            TransData<FNotice> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_NOTICE_DETAIL, request, FNotice.class);
            notice = respObj.getData();
        }
        if (notice == null)
        {
            notice = GMSUtil.getBlankObject(FNotice.class);
        }

        root.put("notice", notice);
    }

}
