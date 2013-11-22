package com.gooagoo.mis.rsrcmanage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.mis.util.MisUtils;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MMarketingActivity;
import com.gooagoo.view.mis.recommendManage.MNominateActivity;
import com.gooagoo.view.mis.recommendManage.MNominateActivityBusiness;

@Controller
@RequestMapping("/nominateA")
public class NominateActivityAction extends BaseAction
{
    /**
     * 推荐活动查询条件页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=quertConditionPage")
    public String quertConditionPage(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/nominate/activity_index";
    }

    /**
     * 推荐活动列表页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryListPage")
    public String quertListPage(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20403");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20403");//权限Id
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_ACTIVITYALL, request, PageModel.class);
        PageModel<MNominateActivityBusiness> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/rsrcmanage/nominate/activity_content";
    }

    /**
     * 推荐页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=nominateActivityPage")
    public String nominateActivityPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<MMarketingActivity> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_ACTITY, request, MMarketingActivity.class);
        MMarketingActivity mark = respObj.getData();
        request.setAttribute("activity", mark);
        return "/rsrcmanage/nominate/activity_add";
    }

    /**
     * 推荐操作
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=nominateActivity")
    public void nominateActivity(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040301");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_ADD_NOMINATEACTIVITY, request, response);
    }

    /**
     * 查询推荐页面-上方查询
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=cancelNominateActivityPageIndex")
    public String cancelNominateActivityPageIndex(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/nominate/activity_query_index";
    }

    /**
     * 查询推荐页面-下方列表
     * @param request
     * @param response
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=cancelNominateActivityPage")
    public String cancelNominateActivityPage(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20403");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20403");//权限Id
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_NOMINATEACTIVITYALL, request, PageModel.class);
        PageModel<MNominateActivityBusiness> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/rsrcmanage/nominate/activity_query_content";
    }

    /**
     * 取消推荐操作
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=cancelNominateActivity")
    public void cancelNominateActivity(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040303");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_UPDATE_NOMINATEACTIVITY, request, response);
    }

    /**
     * 修改推荐页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=updateActivityPage")
    public String updateActivityPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<MNominateActivity> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_UPDATE_ACTITYPAGE, request, MNominateActivity.class);
        MNominateActivity act = respObj.getData();
        request.setAttribute("activity", act);
        return "/rsrcmanage/nominate/activity_update";
    }

    /**
     * 修改推荐操作
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updateNominateActivity")
    public void updateNominateActivity(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040302");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_UPDATE_NOMINATEACTIVITYT, request, response);
    }

    /**
     * 验证活动是否已推荐
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=checkNominateActivity")
    public void checkNominateActivity(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_CHECK_ACTIVITY, request, response);
    }
}
