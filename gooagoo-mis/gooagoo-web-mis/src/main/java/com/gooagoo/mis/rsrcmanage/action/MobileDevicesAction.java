package com.gooagoo.mis.rsrcmanage.action;

import java.util.List;

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
import com.gooagoo.view.mis.mobileDevices.MMobileVersion;
import com.gooagoo.view.mis.systemHierarchy.MTradeArea;

@Controller
@RequestMapping("/mobileDevices")
public class MobileDevicesAction extends BaseAction
{
    /**
     * 设备类型-上方查询
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=index")
    public String queryIndex(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        MisUtils.queryData(new String[] { "mobile_type" }, request, response);
        this.queryTradeArea(request, response);
        return "/rsrcmanage/mobileversion/mobile_index";
    }

    /**
     * 设备类型-下方列表
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=content")
    public String queryContent(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("parentId2", "20701");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20701");//权限Id
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_MV_QUERYALL, request, PageModel.class);
        PageModel<MMobileVersion> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        MisUtils.queryData(new String[] { "mobile_type" }, request, response);
        this.queryTradeArea(request, response);
        return "/rsrcmanage/mobileversion/mobile_content";
    }

    /**
     * 新增设备类型页面
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=addPage")
    public String addMobileDevicesPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        MisUtils.queryData(new String[] { "mobile_type" }, request, response);
        this.queryTradeArea(request, response);
        return "/rsrcmanage/mobileversion/mobile_add";
    }
    
    /**
     * 新增设备类型操作
     * @param request
     * @param response
     * @throws Exception
     * @return
     */
    @RequestMapping(params = "method=add")
    public void addMobileDevices(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2070101");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_MV_INSERT, request, response);
    }
    
    /**
     * 查询商圈信息
     * @param request
     * @param response
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void queryTradeArea(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("tradeAreaNoPage", "Y");//不进行分页查询
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHT_QUERYALL, request, PageModel.class);
        PageModel<MTradeArea> pm = respObj.getData();
        if(pm != null){
            List<MTradeArea> tradeList = pm.getResult();
            request.setAttribute("tradeList", tradeList);
        }
    }

}
