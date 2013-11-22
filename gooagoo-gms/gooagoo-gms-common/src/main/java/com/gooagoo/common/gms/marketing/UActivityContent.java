package com.gooagoo.common.gms.marketing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.freemarker.GMSFtlUtil;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.view.gms.common.FNode;

public class UActivityContent
{

    /**
     * 创建活动内容
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    public static void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String channelCode = getChannelCode(request);
        if ("1".equals(channelCode))//吆喝
        {
            request.setAttribute(GMSConstant.ESCAPE_STRING_TYPE_KEY, "N");
            UCryout.add(request, response);
        }
        else if ("2".equals(channelCode))//通知
        {
            request.setAttribute(GMSConstant.ESCAPE_STRING_TYPE_KEY, "N");
            UNotice.add(request, response);
        }
        else if ("3".equals(channelCode))//短信
        {
            UMessage.add(request, response);
        }
        else
        {
            UEvent.add(request, response);
        }
    }

    /**
     * 修改活动内容
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    public static void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String channelCode = getChannelCode(request);
        if ("1".equals(channelCode))//吆喝
        {
            request.setAttribute(GMSConstant.ESCAPE_STRING_TYPE_KEY, "N");
            UCryout.update(request, response);
        }
        else if ("2".equals(channelCode))//通知
        {
            request.setAttribute(GMSConstant.ESCAPE_STRING_TYPE_KEY, "N");
            UNotice.update(request, response);
        }
        else if ("3".equals(channelCode))//短信
        {
            UMessage.update(request, response);
        }
        else
        {
            UEvent.update(request, response);
        }
    }

    /**
     * 编辑活动内容(1-吆喝，2-通知，3-短信，其他-事件)
     * @param request
     * @param response
     * @param operateType(A-添加，U-修改)
     * @throws Exception
     */
    public static void contform(HttpServletRequest request, HttpServletResponse response, String operateType) throws Exception
    {
        if (GMSConstant.FORM_OPERATE_TYPE_ADD.equals(operateType))
        {
            request.setAttribute("marketingId", GMSServiceUtil.getUUIDByWeb(request));
        }
        else
        {
            request.setAttribute("marketingId", null);
        }
        Map<String, Object> root = getActivityContentCommonParaMap(request);
        root.put("operateType", operateType);

        String channelCode = (String) root.get("channelCode");
        if ("1".equals(channelCode))//吆喝
        {
            UCryout.form(request, response, root);
        }
        else if ("2".equals(channelCode))//通知
        {
            UNotice.form(request, response, root);
        }
        else if ("3".equals(channelCode))//短信
        {
            UMessage.form(request, response, root);
        }
        else
        {
            UEvent.form(request, response, root);
        }
    }

    /**
     * 活动内容审页面
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    public static void formCheck(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //判断渠道
        String channelCode = getChannelCode(request);
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("channelCode", channelCode);
        if ("1".equals(channelCode))//吆喝
        {
            UCryout.formCheck(request, response, root);
        }
        else if ("2".equals(channelCode))//通知
        {
            UNotice.formCheck(request, response, root);
        }
        else if ("3".equals(channelCode))//短信
        {
            UMessage.formCheck(request, response, root);
        }
        else
        {
            UEvent.formCheck(request, response, root);
        }
    }

    /**
     * 审核活动内容
     * @param request
     * @param response 
     * @return
     */
    public static void check(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String channelCode = getChannelCode(request);
        if ("1".equals(channelCode))//吆喝
        {
            UCryout.check(request, response);
        }
        else if ("2".equals(channelCode))//通知
        {
            UNotice.check(request, response);
        }
        else if ("3".equals(channelCode))//短信
        {
            UMessage.check(request, response);
        }
        else
        {
            UEvent.check(request, response);
        }
    }

    /**
     * 删除活动内容
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    public static void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String channelCode = getChannelCode(request);
        if ("1".equals(channelCode))//吆喝
        {
            UCryout.delete(request, response);
        }
        else if ("2".equals(channelCode))//通知
        {
            UNotice.delete(request, response);
        }
        else if ("3".equals(channelCode))//短信
        {
            UMessage.delete(request, response);
        }
        else
        {
            UEvent.delete(request, response);
        }
    }

    /**
    * 营销内容详细页
    * @param request
    * @param response
    * @return
    * @throws Exception  
    */
    public static void detailMarketingContent(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //判断渠道
        String channelCode = getChannelCode(request);

        Map<String, Object> root = getActivityContentCommonParaMap(request);

        if ("1".equals(channelCode))//吆喝
        {
            UCryout.detail(request, response, root);
        }
        else if ("2".equals(channelCode))//通知
        {
            UNotice.detail(request, response, root);
        }
        else if ("3".equals(channelCode))//短信
        {
            UMessage.detail(request, response, root);
        }
        else
        {
            UEvent.detail(request, response, root);//事件
        }
    }

    /**
     * 发布活动
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public static void release(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String contentId = ServletRequestUtils.getStringParameter(request, "contentId", "");
        String activityId = ServletRequestUtils.getStringParameter(request, "activityId", "");
        String channelCode = getChannelCode(request);

        String interfaceCode = "";
        if ("1".equals(channelCode))//吆喝
        {
            interfaceCode = InterGmsConstants.I_GMS_CRYOUT_RELEASE;
        }
        else if ("2".equals(channelCode))//通知
        {
            interfaceCode = InterGmsConstants.I_GMS_NOTICE_RELEASE;
        }
        else if ("3".equals(channelCode))//短信
        {
            interfaceCode = InterGmsConstants.I_GMS_SHORTMESSAGE_RELEASE;
        }
        else if ("4".equals(channelCode))//邮件
        {
            interfaceCode = InterGmsConstants.I_GMS_EMAIL_RELEASE;
        }
        else if ("5".equals(channelCode))//购好奇
        {
            interfaceCode = InterGmsConstants.I_GMS_GHQ_RELEASE;
        }
        else if ("6".equals(channelCode))//手机服务
        {
            interfaceCode = InterGmsConstants.I_GMS_MSERVICE_RELEASE;
        }
        else if ("7".equals(channelCode))//手机虚拟商家
        {
            interfaceCode = InterGmsConstants.I_GMS_MVB_RELEASE;
        }
        else if ("8".equals(channelCode))//网站虚拟商家
        {
            interfaceCode = InterGmsConstants.I_GMS_WVB_RELEASE;
        }
        else if ("9".equals(channelCode))//自定义服务工具
        {
            interfaceCode = InterGmsConstants.I_GMS_TOOL_RELEASE;
        }

        request.setAttribute("id", contentId);
        request.setAttribute("objectCode", contentId);
        request.setAttribute("activityId", activityId);

        GMSUtil.ajaxSubmit(interfaceCode, request, response);
    }

    /**
     * 获取活动内容信息模板公用参数
     * @param request
     * @return
     */
    public static Map<String, Object> getActivityContentCommonParaMap(HttpServletRequest request)
    {
        String channelCode = getChannelCode(request);

        Map<String, Object> root = new HashMap<String, Object>();
        List<String> paraNameList = new ArrayList<String>();
        paraNameList.add("activityId");
        paraNameList.add("marketingId");
        paraNameList.add("contId");
        GMSFtlUtil.putRequestParasToMap(request, paraNameList, root);

        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITYCONTENT_FORM, request, List.class);
        List<FNode> channels = respObj.getData();
        root.put("channels", channels);

        if (!StringUtils.hasText(channelCode))
        {
            channelCode = channels.get(0).getCode();
        }
        String channelName = getChanneName(channelCode, channels);
        if (channelName == null)
        {
            channelName = "";
        }
        root.put("channelCode", channelCode);
        root.put("channelName", channelName);
        return root;
    }

    /**
     * 获取渠道名称
     * @param channelCode
     * @param channels
     * @return
     */
    public static String getChanneName(String channelCode, List<FNode> channels)
    {
        String name = "";
        if (channels == null || channelCode == null)
        {
            GooagooLog.warn("获取渠道名称失败，channels为空，channelCode=" + channelCode + ",channels=" + channels);
            return name;
        }
        for (Iterator<FNode> iterator = channels.iterator(); iterator.hasNext();)
        {
            FNode fNode = iterator.next();
            if (channelCode.equals(fNode.getCode()))
            {
                name = fNode.getName();
                break;
            }
        }
        return name;
    }

    private static String getChannelCode(HttpServletRequest request)
    {
        String channelCode = (String) request.getAttribute("channelCode");
        if (!StringUtils.hasText(channelCode))
        {
            channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");
        }
        return channelCode;
    }
}
