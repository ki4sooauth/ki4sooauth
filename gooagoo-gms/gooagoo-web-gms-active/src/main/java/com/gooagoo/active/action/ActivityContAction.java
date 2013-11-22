package com.gooagoo.active.action;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.freemarker.UserSearchFtlUtil;
import com.gooagoo.common.gms.marketing.UActivityContent;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.gms.common.FNode;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FActivity;
import com.gooagoo.view.gms.marketing.FActivityContent;
import com.google.gson.Gson;

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
     * 内容管理首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        String activityId = ServletRequestUtils.getStringParameter(request, "id", "");

        this.getSysdictionary(request);

        FActivity activity = null;
        if (StringUtils.hasText(activityId))
        {
            TransData<FActivity> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITY_DETAIL, request, FActivity.class);
            activity = respObj.getData();
        }
        else
        {
            return "redirect:/activity.do?method=form";
        }

        request.setAttribute("activity", activity);
        return "activity/release_index";
    }

    /**
     * 活动内容列表（分页）
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String flag = ServletRequestUtils.getStringParameter(request, "flag", "");

        this.getSysdictionary(request);

        TransData<List> respObj1 = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITYCONTENT_FORM, request, List.class);
        List<FNode> channels = respObj1.getData();

        request.setAttribute("channels", channels);

        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITYCONTENT_PAGE, request, PageModel.class);
        PageModel<FActivityContent> pm = respObj.getData();

        request.setAttribute("pm", pm);
        request.setAttribute("flag", flag);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
            GooagooLog.debug("活动内容列表信息:" + new Gson().toJson(pm));
        }

        return "activity/activity_cont_list";
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
        String contentId = ServletRequestUtils.getStringParameter(request, "contentId", "");
        String activityId = ServletRequestUtils.getStringParameter(request, "activityId", "");
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");
        String activeStartTime = ServletRequestUtils.getStringParameter(request, "activeStartTime", "");
        String activeEndTime = ServletRequestUtils.getStringParameter(request, "activeEndTime", "");

        this.getSysdictionary(request);

        String ruleCondition = UserSearchFtlUtil.getRuleConditionContent(request, null, null);
        if (ruleCondition == null)
        {
            GooagooLog.warn("活动内容发布条件通过模板生成文件失败");
            throw new GooagooException("系统异常");
        }

        request.setAttribute("ruleCondition", ruleCondition);
        request.setAttribute("id", contentId);
        request.setAttribute("contentId", contentId);
        request.setAttribute("activityId", activityId);
        request.setAttribute("channelCode", channelCode);
        request.setAttribute("sTime", activeStartTime);
        request.setAttribute("eTime", activeEndTime);
        request.setAttribute("currentTime", TimeUtils.getCurrentDate());
        request.setAttribute("currentDateTime", TimeUtils.getCurrentDateTime());

        return "/activity/release_group";
    }

    /**
     * 获取字典表数据
     * @param request
     */
    public void getSysdictionary(HttpServletRequest request)
    {
        String[] arr = { "publish_status", "user_type", "sex", "idtype", "behave_type", "rule_type", "rule_result_type", "rule_active_type", "info_source", "week_type", "relation_type" };
        for (int i = 0; i < arr.length; i++)
        {
            Map<String, String> map = new TreeMap<String, String>();
            map.putAll(SysdictionaryCache.get(arr[i]));
            request.setAttribute(arr[i], map);
        }
    }
}
