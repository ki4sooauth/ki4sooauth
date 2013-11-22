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

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.view.gms.common.FFullCalendar;
import com.gooagoo.view.gms.common.GAjax;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FActivity;
import com.google.gson.Gson;

/**
 * 营销活动管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/activity")
public class ActivityAction extends BaseAction
{
    /**
     * 活动列表主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        String activityTime = ServletRequestUtils.getStringParameter(request, "activityTime", "");
        request.setAttribute("activityTime", activityTime);

        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITY_LIST, request, List.class);

        List<FActivity> activeList = respObj.getData();

        GooagooLog.debug("查询所有有效活动信息列表………………，数据用于活动日历" + new Gson().toJson(activeList));

        List<Map<String, String>> calendarData = GMSServiceUtil.getCalendarData(activeList);
        FFullCalendar fc = GMSServiceUtil.getFFullCalendar(request);
        fc.setData(calendarData);

        request.setAttribute("fullCalendar", new Gson().toJson(fc));
        GooagooLog.debug("活动列表主页方法………………，跳转至 activity/index");

        return "activity/index";
    }

    /**
     * 活动列表
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITY_PAGE, request, PageModel.class);

        this.getSysdictionary(request);

        PageModel<FActivity> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
            request.setAttribute("myToday", TimeUtils.getCurrentDate());
            GooagooLog.debug("活动列表信息:" + new Gson().toJson(pm));
        }

        return "activity/activity_list";
    }

    /**
     * 内容添加页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formA")
    public String formA(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GooagooLog.debug("添加活动内容页，跳转至activity/activity_edit");

        request.setAttribute("currentTime", TimeUtils.getCurrentDate());
        request.setAttribute("currentDateTime", TimeUtils.getCurrentDateTime());
        return "activity/activity_edit";
    }

    /**
     * 添加活动信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=create")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<String> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_ACTIVITY_ADD, request, String.class);

        String activityId = respObj.getData();

        String resultCode = respObj.getHead().getResultCode();
        String resultName = ExceptionCache.get(resultCode);

        GAjax rv = new GAjax(respObj.getHead().isSuccess(), resultName);
        rv.setExtend(activityId);
        String result = new Gson().toJson(rv);

        ServletUtils.writeHtml(result, response);
    }

    /**
     * 内容修改页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formU")
    public String formU(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String activityId = ServletRequestUtils.getStringParameter(request, "id", "");

        FActivity activity = null;
        if (StringUtils.hasText(activityId))
        {
            TransData<FActivity> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITY_DETAIL, request, FActivity.class);
            activity = respObj.getData();
            GooagooLog.debug("修改活动信息：activityId＝" + activityId + "\n修改前信息为：" + new Gson().toJson(activity));
        }
        else
        {
            GooagooLog.debug("修改活动信息：activityId　为空！");
        }

        request.setAttribute("currentTime", TimeUtils.getCurrentDate());
        request.setAttribute("currentDateTime", TimeUtils.getCurrentDateTime());
        request.setAttribute("activity", activity);
        return "activity/activity_edit";
    }

    /**
     * 修改活动信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_ACTIVITY_UPDATE, request, response);
    }

    /**
     * 删除活动信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_ACTIVITY_DELETE, request, response);
    }

    /**
     * 活动详细信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=detail")
    public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String activityId = ServletRequestUtils.getStringParameter(request, "id", "");

        this.getSysdictionary(request);

        FActivity activity = null;
        if (StringUtils.hasText(activityId))
        {
            TransData<FActivity> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITY_DETAIL, request, FActivity.class);
            activity = respObj.getData();
        }
        GooagooLog.debug("查看活动内容详细信息　" + new Gson().toJson(activity) + "，跳转至activity/activity_detail");

        request.setAttribute("activity", activity);
        request.setAttribute("myToday", TimeUtils.getCurrentDate());

        return "activity/activity_detail";
    }

    /**
     * 审核活动基本信息页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formCheck")
    public String formCheck(HttpServletRequest request, HttpServletResponse response)
    {
        String activityId = ServletRequestUtils.getStringParameter(request, "id", "");

        this.getSysdictionary(request);

        FActivity activity = null;
        if (StringUtils.hasText(activityId))
        {
            TransData<FActivity> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITY_DETAIL, request, FActivity.class);
            activity = respObj.getData();
            request.setAttribute("activity", activity);
            GooagooLog.debug("审核活动信息页面：activityId=" + activityId + "," + new Gson().toJson(activity));
        }
        else
        {
            GooagooLog.debug("审核活动信息页面：活动ID为空");
        }
        return "activity/activity_check";
    }

    /**
     * 审核活动
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=check")
    public void check(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_ACTIVITY_CHECK, request, response);
    }

    /**
     * 发布活动
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=publish")
    public void publish(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_ACTIVITY_PUBLISH, request, response);
    }

    /**
     * 所有有效活动列信息列表
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=getAllActivityList")
    public void getAllActivityList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<List> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITY_LIST, request, List.class);
        List<FActivity> activeList = respObj.getData();

        String json = new Gson().toJson(activeList);
        GooagooLog.debug("所有有效活动列信息列表：" + json);
        ServletUtils.writeHtml(json, response);
    }

    /**
     * 活动营销状态
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=satistics")
    public String satistics(HttpServletRequest request, HttpServletResponse response)
    {
        String activityId = ServletRequestUtils.getStringParameter(request, "id", "");
        request.setAttribute("item", "ACTIVITY");
        request.setAttribute("itemId", activityId);
        return "statistics/index";
    }

    /**
     * 获取字典表数据
     * @param request
     */
    public void getSysdictionary(HttpServletRequest request)
    {
        String[] arr = { "publish_status" };
        for (int i = 0; i < arr.length; i++)
        {
            Map<String, String> map = new TreeMap<String, String>();
            map.putAll(SysdictionaryCache.get(arr[i]));
            request.setAttribute(arr[i], map);
        }
    }
}
