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
import com.gooagoo.view.mis.systemHierarchy.MPlatformRegion;

@Controller
@RequestMapping("/platformRegion")
public class PlatformRegionAction extends BaseAction
{
    /**
     * 新增小平台信息页面
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=addPlatformRegionPage")
    public String addPlatformRegionPage(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/systemhierarchy/platformregion_add";
    }

    /**
     * 新增小平台信息操作
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=addPlatformRegion")
    public void addPlatformRegion(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2080101");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHP_ADD, request, response);
    }

    /**
     * 小平台删除信息操作
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=deletePlatformRegion")
    public void deletePlatformRegion(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2080103");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHP_DELETE, request, response);
    }

    /**
     * 小平台修改信息页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=queryPlatformRegionInfo")
    public String queryPlatformRegionInfo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<MPlatformRegion> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHP_QUERYINFO, request, MPlatformRegion.class);
        request.setAttribute("platform", respObj.getData());
        return "/rsrcmanage/systemhierarchy/platformregion_update";
    }

    /**
     * 小平台修改信息操作
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updatePlatformRegion")
    public void updatePlatformRegion(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2080102");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHP_UPDATE, request, response);
    }

    /**
     * 小平台查询列表-上方查询
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=queryIndex")
    public String queryIndex(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/systemhierarchy/platformregion_index";
    }

    /**
     * 小平台查询-下方列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=queryContent")
    public String queryContent(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20801");//菜单权限
        request.setAttribute("moduleId", "20801");//权限Id
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHP_QUERYALL, request, PageModel.class);
        PageModel<MPlatformRegion> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/rsrcmanage/systemhierarchy/platformregion_content";
    }

}
