package com.gooagoo.gmarketing.action;

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
import com.gooagoo.common.gms.freemarker.UserSearchFtlUtil;
import com.gooagoo.common.gms.marketing.UActivityContent;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.gms.common.GAjax;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.notice.FNotice;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/notice")
public class Notice_Action extends BaseAction
{
    /**
     * 通知管理主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "/notice/index";
    }

    /**
     * 商家已发送的通知信息列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_NOTICE_PAGE, request, PageModel.class);
        PageModel<FNotice> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "notice/noticeList";
    }

    /**
     * 创建通知首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addIndex")
    public String addIndex(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("marketingId", GMSServiceUtil.getUUIDByWeb(request));
        return "/notice/common_index";
    }

    /**
     * 修改通知首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=editIndex")
    public String editIndex(HttpServletRequest request, HttpServletResponse response)
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        request.setAttribute("id", id);
        return "/notice/common_index";
    }

    /**
     * 编辑通知信息（添加）
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=addform")
    public String addform(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.formDetail(request, response);
        return "/notice/common_edit";
    }

    /**
     * 编辑通知信息（修改）
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=editform")
    public String editform(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.formDetail(request, response);
        return "/notice/common_edit";
    }

    /**
     * 通知内容的创建
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("channelCode", "2");
        UActivityContent.add(request, response);
    }

    /**
     * 修改通知信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("channelCode", "2");
        UActivityContent.update(request, response);
    }

    /**
     * 通知的详细信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=detail")
    public void detail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("channelCode", "2");
        UActivityContent.detailMarketingContent(request, response);
    }

    /**
     * 删除通知信息
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("channelCode", "2");
        UActivityContent.delete(request, response);
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
        String noticeTitle = ServletRequestUtils.getStringParameter(request, "noticeTitle", "");
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");
        String activityName = ServletRequestUtils.getStringParameter(request, "activityName", "");
        String activeStartTime = ServletRequestUtils.getStringParameter(request, "activeStartTime", "");
        String activeEndTime = ServletRequestUtils.getStringParameter(request, "activeEndTime", "");
        request.setAttribute("id", contentId);
        request.setAttribute("channelCode", channelCode);
        this.getSysdictionary(request);
        String ruleCondition = UserSearchFtlUtil.getRuleConditionContent(request, null, null);
        if (ruleCondition == null)
        {
            GooagooLog.warn("活动内容发布条件通过模板生成文件失败");
            throw new GooagooException("系统异常");
        }
        request.setAttribute("ruleCondition", ruleCondition);
        request.setAttribute("contentId", contentId);
        request.setAttribute("status", status);
        request.setAttribute("title", noticeTitle);
        request.setAttribute("activityName", activityName);
        request.setAttribute("sTime", activeStartTime);
        request.setAttribute("eTime", activeEndTime);
        request.setAttribute("currentTime", TimeUtils.getCurrentDate());
        request.setAttribute("currentDateTime", TimeUtils.getCurrentDateTime());
        request.setAttribute("list", loginInfo.getDetailList());

        return "/common/release_group";
    }

    /**
     * 发布
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=release")
    public void release(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("channelCode", "2");
        UActivityContent.release(request, response);
    }

    /**
     * 审核发布
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=checkAndrelease")
    public void checkAndrelease(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");

        request.setAttribute("status", "Y");

        String interfaceCode = InterGmsConstants.I_GMS_NOTICE_CHECK;

        TransData<Object> respObj = GMSHttpUtils.transfer(interfaceCode, request, Object.class);
        if (respObj.getHead().isSuccess())
        {
            String title = ServletRequestUtils.getStringParameter(request, "title", "");
            request.setAttribute("contentId", id);
            request.setAttribute("title", title);
            request.setAttribute("objectCode", id);
            interfaceCode = InterGmsConstants.I_GMS_NOTICE_RELEASE;
            respObj = GMSHttpUtils.transfer(interfaceCode, request, Object.class);
        }

        String resultCode = respObj.getHead().getResultCode();
        String resultName = ExceptionCache.get(resultCode);
        if (!StringUtils.hasText(resultName))
        {
            GooagooLog.info("获取提示信息名称为空，resultName=" + resultName + ",resultCode=" + resultCode);
            resultName = resultCode;
        }
        GAjax rv = new GAjax(respObj.getHead().isSuccess(), resultName);

        Object data = respObj.getData();
        if (data instanceof String)
        {
            rv.setExtend((String) data);
        }
        String result = new Gson().toJson(rv);

        ServletUtils.writeHtml(result, response);
    }

    public static void formDetail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String noticeInfoId = ServletRequestUtils.getStringParameter(request, "id", "");
        String activityId = ServletRequestUtils.getStringParameter(request, "activityId", "");

        FNotice notice = null;
        if (StringUtils.hasText(noticeInfoId))
        {
            TransData<FNotice> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_NOTICE_DETAIL, request, FNotice.class);
            notice = respObj.getData();
        }
        request.setAttribute("activityId", activityId);
        request.setAttribute("notice", notice);

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