package com.gooagoo.mis.sysmanage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.mis.util.MisUtils;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.common.MBehaveLog;
import com.gooagoo.view.mis.common.MShopLog;
import com.gooagoo.view.mis.common.MSysLog;

@Controller
@RequestMapping("/sysLog")
public class SysLogAction extends BaseAction
{

    /**
     * 日志查询首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=searchLog")
    public String searchLog(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        session.setAttribute("parentId2", "10301");//菜单权限
        MisUtils.queryData(new String[] { "behave_source", "behave_type" }, request, response);
        return "/sysmanage/syslog/index";
    }

    /**
     * 日志查询列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=resultList")
    public String resultList(HttpServletRequest request, HttpServletResponse response)
    {
        //记录日志
        request.setAttribute("moduleType", "mis");//模块
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("mis_login_id", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SYSUSER_SEARCHALLLOG, request, PageModel.class);
        PageModel<MSysLog> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        MisUtils.queryData(new String[] { "behave_source", "behave_type" }, request, response);
        return "/sysmanage/syslog/content";
    }

    /**
     * 查询日志详细信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=searchLogInfo")
    public String searLogInfo(HttpServletRequest request, HttpServletResponse response)
    {
        String logType = ServletRequestUtils.getStringParameter(request, "logType", "");
        String resultPage = "/sysmanage/syslog/sys_loginfo";
        TransData<Object> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SYSTOOL_DETAIL, request, Object.class);
        if ("1".equals(logType))
        {
            MisUtils.queryData(new String[] { "behave_type" }, request, response);
            MShopLog shop = (MShopLog) respObj.getData();
            request.setAttribute("shop", shop);
            resultPage = "/sysmanage/syslog/shop_loginfo";
        }
        else if ("2".equals(logType))
        {
            MisUtils.queryData(new String[] { "behave_source","behave_type" }, request, response);
            MBehaveLog behave = (MBehaveLog) respObj.getData();
            request.setAttribute("behave", behave);
            resultPage = "/sysmanage/syslog/behave_loginfo";
        }
        else if ("3".equals(logType))
        {
            MisUtils.queryData(new String[] { "behave_source" }, request, response);
            MSysLog sys = (MSysLog) respObj.getData();
            request.setAttribute("sys", sys);
            resultPage = "/sysmanage/syslog/sys_loginfo";
        }
        return resultPage;
    }

}
