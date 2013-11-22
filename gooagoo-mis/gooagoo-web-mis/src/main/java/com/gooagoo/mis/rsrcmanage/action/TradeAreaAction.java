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
import com.gooagoo.view.mis.systemHierarchy.MPlatformRegion;
import com.gooagoo.view.mis.systemHierarchy.MTradeArea;

@Controller
@RequestMapping("/tradeArea")
public class TradeAreaAction extends BaseAction
{
    /**
     * 新增商圈信息页面
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=addTradeAreaPage")
    public String addTradeAreaPage(HttpServletRequest request, HttpServletResponse response)
    {
        this.queryPlatformRegionList(request, response);
        return "/rsrcmanage/systemhierarchy/tradeArea_add";
    }

    /**
     * 新增商圈信息操作
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=addTradeArea")
    public void addTradeArea(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2080201");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHT_ADD, request, response);
    }

    /**
     * 商圈删除信息操作
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=deleteTradeArea")
    public void deleteTradeArea(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2080203");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHT_DELETE, request, response);
    }

    /**
     * 商圈修改信息页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=queryTradeAreaInfo")
    public String queryTradeAreaInfo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<MTradeArea> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHT_QUERYINFO, request, MTradeArea.class);
        request.setAttribute("trade", respObj.getData());
        this.queryPlatformRegionList(request, response);
        return "/rsrcmanage/systemhierarchy/tradeArea_update";
    }

    /**
     * 商圈修改信息操作
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updateTradeArea")
    public void updateTradeArea(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2080202");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHT_UPDATE, request, response);
    }

    /**
     * 商圈查询列表-上方查询
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=queryIndex")
    public String queryIndex(HttpServletRequest request, HttpServletResponse response)
    {
        this.queryPlatformRegionList(request, response);
        return "/rsrcmanage/systemhierarchy/tradeArea_index";
    }

    /**
     * 商圈查询-下方列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=queryContent")
    public String queryContent(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20802");//菜单权限
        request.setAttribute("moduleId", "20802");//权限Id
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHT_QUERYALL, request, PageModel.class);
        PageModel<MTradeArea> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        this.queryPlatformRegionList(request, response);
        return "/rsrcmanage/systemhierarchy/tradeArea_content";
    }

    /**
     * 查询小平台信息
     * @param request
     * @param response
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void queryPlatformRegionList(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("platformNoPage", "Y");//不进行分页查询
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHP_QUERYALL, request, PageModel.class);
        PageModel<MPlatformRegion> pm = respObj.getData();
        if (pm != null)
        {
            List<MPlatformRegion> platList = pm.getResult();
            request.setAttribute("platList", platList);
        }
    }
}
