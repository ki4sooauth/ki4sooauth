package com.gooagoo.gmarketing.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.marketing.UActivityContent;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.view.gms.account.UserView;
import com.gooagoo.view.gms.common.FNode;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FActivityContent;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;

/**
 * 活动内容管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/activityCont")
public class ActivityContAction extends BaseAction
{
    //<!--公用部分开始-->

    /**
     * 创建活动内容
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UActivityContent.add(request, response);
    }

    /**
     * 添加活动内容页（选择渠道后的页面）
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=addContform")
    public void addContform(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UActivityContent.contform(request, response, GMSConstant.FORM_OPERATE_TYPE_ADD);
    }

    /**
     * 修改活动内容页（选择渠道后的页面）
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updateContform")
    public void updateContform(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UActivityContent.contform(request, response, GMSConstant.FORM_OPERATE_TYPE_UPDATE);
    }

    /**
     * 修改活动内容
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UActivityContent.update(request, response);
    }

    /**
     * 活动内容审页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formCheck")
    public void formCheck(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UActivityContent.formCheck(request, response);
    }

    /**
     * 审核活动内容
     * @param request
     * @param response 
     * @return
     */
    @RequestMapping(params = "method=check")
    public void check(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UActivityContent.check(request, response);
    }

    /**
     * 删除活动内容
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UActivityContent.delete(request, response);
    }

    /**
     * 发布活动
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=release")
    public void release(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UActivityContent.release(request, response);
    }

    /**
    * 活动内容详细页
    * @param request
    * @param response
    * @return
    * @throws Exception  
    */
    @RequestMapping(params = "method=detail")
    public void detailCont(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UActivityContent.detailMarketingContent(request, response);
    }

    //<!--公用部分结束-->

    /**
     * 分页活动内容主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=indexPage")
    public String indexPage(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<List> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_ACTIVITYCONTENT_FORM, request, List.class);
        List<FNode> channels = respObj.getData();
        request.setAttribute("channels", channels);
        return "activityCont/index_contpage";
    }

    /**
     * 活动内容列表（分页）(内容管理——活动内容管理)
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=pageList")
    public String pageList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_ACTIVITYCONTENT_PAGE, request, PageModel.class);
        PageModel<FActivityContent> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));

        }

        return "activityCont/content_page";
    }

    /**
     * 根据历史条件查用户账户列表信息首页
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=userIndex")
    public String userIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "/rule/user_index";
    }

    /**
     * 根据历史条件查用户账户列表信息首页 
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=forTable")
    public String userRecordsSearchForTable(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<PageModel> userRecorddTransData = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRM_USERRECORD_SIFT, request, PageModel.class);
        PageModel<UserView> pm = userRecorddTransData.getData();
        GooagooLog.debug("CPM查询用户档案信息列返回信息pm：" + pm);
        if (pm != null)
        {
            Map<String, String> map = SysdictionaryCache.get("user_type");
            request.setAttribute("userTypes", map);
            request.setAttribute("pageModel", pm);
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/rule/table";
    }

    /**
     * 发布条件页
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=pulishCondition")
    public String pulishCondition(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GmsLoginInfo loginInfo = GMSUtil.getGmsLoginInfoByWeb(request);

        String contentId = ServletRequestUtils.getStringParameter(request, "contentId", "");
        String status = ServletRequestUtils.getStringParameter(request, "status", "");
        String contentType = ServletRequestUtils.getStringParameter(request, "contentType", "");
        String activeStartTime = ServletRequestUtils.getStringParameter(request, "activeStartTime", "");
        String activeEndTime = ServletRequestUtils.getStringParameter(request, "activeEndTime", "");
        request.setAttribute("id", contentId);
        request.setAttribute("channelCode", contentType);

        String[] arr = { "publish_status", "user_type", "sex", "idtype", "behave_type", "rule_type", "rule_result_type", "rule_active_type", "info_source", "week_type", "relation_type" };
        for (int i = 0; i < arr.length; i++)
        {
            Map<String, String> map = new TreeMap<String, String>();
            map.putAll(SysdictionaryCache.get(arr[i]));
            request.setAttribute(arr[i], map);
        }
        request.setAttribute("contentId", contentId);
        request.setAttribute("status", status);
        request.setAttribute("contentType", contentType);
        request.setAttribute("sTime", activeStartTime);
        request.setAttribute("eTime", activeEndTime);
        request.setAttribute("currentTime", TimeUtils.getCurrentDate());
        request.setAttribute("currentDateTime", TimeUtils.getCurrentDateTime());
        request.setAttribute("list", loginInfo.getDetailList());

        return "/rule/release_group";
    }

}
