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
import com.gooagoo.view.gms.cryout.FCryout;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;
import com.google.gson.Gson;

/**
 * 吆喝管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cryout")
public class Cryout_Action extends BaseAction
{
    /**
     * 吆喝管理首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "/cryout/index";
    }

    /**
     * 吆喝管理列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_CRYOUT_PAGE, request, PageModel.class);
        PageModel<FCryout> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "cryout/cryoutList";
    }

    /**
     * 创建吆喝首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addIndex")
    public String addIndex(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("marketingId", GMSServiceUtil.getUUIDByWeb(request));
        return "/cryout/common_index";
    }

    /**
     * 修改吆喝首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=editIndex")
    public String editIndex(HttpServletRequest request, HttpServletResponse response)
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        request.setAttribute("id", id);
        return "/cryout/common_index";
    }

    /**
     * 添加编辑页
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=addform")
    public String addform(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.formDetail(request, response);
        return "cryout/common_edit";

    }

    /**
     * 修改编辑页
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=editform")
    public String editform(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.formDetail(request, response);
        return "cryout/common_edit";

    }

    /**
     * 发送吆喝管理信息
     * @param request
     * @param response
     * @param releaseLog
     * @param cryoutInfo
     */
    @RequestMapping(params = "method=add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("channelCode", "1");
        UActivityContent.add(request, response);
    }

    /**
     * 修改吆喝信息
     * @param request
     * @param response
     * @throws Exception
     */

    @RequestMapping(params = "method=update")
    public static void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("channelCode", "1");
        UActivityContent.update(request, response);
    }

    /**
     * 删除吆喝信息
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("channelCode", "1");
        UActivityContent.delete(request, response);
    }

    /**
     * 查询吆喝详细
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=detail")
    public void detail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("channelCode", "1");
        UActivityContent.detailMarketingContent(request, response);
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
        String cryoutTitle = ServletRequestUtils.getStringParameter(request, "cryoutTitle", "");
        String contentId = ServletRequestUtils.getStringParameter(request, "contentId", "");
        String status = ServletRequestUtils.getStringParameter(request, "status", "");
        String channelCode = ServletRequestUtils.getStringParameter(request, "channelCode", "");
        String activityName = ServletRequestUtils.getStringParameter(request, "activityName", "");
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
        request.setAttribute("channelCode", channelCode);
        request.setAttribute("contentId", contentId);
        request.setAttribute("status", status);
        request.setAttribute("title", cryoutTitle);
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
        request.setAttribute("channelCode", "1");
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
        String title = ServletRequestUtils.getStringParameter(request, "title", "");
        request.setAttribute("status", "Y");
        request.setAttribute("objectCode", id);
        request.setAttribute("contentId", id);
        request.setAttribute("title", title);
        String interfaceCode = InterGmsConstants.I_GMS_CRYOUT_CHECK;

        TransData<Object> respObj = GMSHttpUtils.transfer(interfaceCode, request, Object.class);
        if (respObj.getHead().isSuccess())
        {

            interfaceCode = InterGmsConstants.I_GMS_CRYOUT_RELEASE;
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

    private void formDetail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String cryoutInfoId = ServletRequestUtils.getStringParameter(request, "id", "");
        String activityId = ServletRequestUtils.getStringParameter(request, "activityId", "");
        FCryout cryout = null;
        if (StringUtils.hasText(cryoutInfoId))
        {
            TransData<FCryout> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_CRYOUT_DETAIL, request, FCryout.class);
            cryout = respObj.getData();
        }
        request.setAttribute("activityId", activityId);
        request.setAttribute("cryout", cryout);

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
