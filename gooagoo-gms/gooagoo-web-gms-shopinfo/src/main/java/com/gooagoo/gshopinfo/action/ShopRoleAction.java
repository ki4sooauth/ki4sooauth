package com.gooagoo.gshopinfo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.shopinfo.FShopRole;
import com.google.gson.Gson;

@Controller
@RequestMapping("/shopRole")
public class ShopRoleAction extends BaseAction
{
    /**
     * 跳转权限列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "role/index";
    }

    /**
     * 跳转角色绑定权限页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=toBindAuth")
    public String toBindAuth(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String roleId = ServletRequestUtils.getStringParameter(request, "roleId", "");
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_OWN_AUTH, request, List.class);
        @SuppressWarnings("unchecked")
        List<String> autList = transData.getData();
        String auth = new Gson().toJson(autList);
        request.setAttribute("roleId", roleId);
        request.setAttribute("auth", auth);
        return "role/bind_auth";
    }

    /**
     * 跳转编辑角色页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=addform")
    public String addForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return "role/edit";
    }

    /**
     * 跳转编辑角色页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=updateform")
    public String updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String roleId = ServletRequestUtils.getStringParameter(request, "roleId", "");
        if (StringUtils.isNotBlank(roleId))
        {
            TransData<FShopRole> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_SHOP_ROLE_INFO, request, FShopRole.class);
            FShopRole fshopRole = transData.getData();
            request.setAttribute("fshopRole", fshopRole);
        }
        return "role/edit";
    }

    /**
     * 添加权限信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_ADD_ROLE_INFO, request, response);
    }

    /**
     * 更新权限信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_ROLE_INFO, request, response);
    }

    /**
     * 删除权限信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_DEL_ROLE__INFO, request, response);
    }

    /**
     * 分页查询权限信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_ROLE_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopRole> pageModel = transData.getData();
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }

        return "role/list";
    }

    /**
     * 查询权限列表
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=authorityList")
    public void authorityList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_AUTH_ALL, request, List.class);
        @SuppressWarnings("unchecked")
        List<ZTreeNode> treeNodes = transData.getData();
        String json = new Gson().toJson(treeNodes);
        ServletUtils.writeHtml(json, response);
    }

    /**
     * 修改角色权限信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=updateAuthority")
    public void updateAuthority(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_ROLE_AUTHORITY, request, response);
    }

    /**
     * 获取所有角色信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=getAllRole")
    public String getAllRole(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String userId = ServletRequestUtils.getRequiredStringParameter(request, "userId");
        @SuppressWarnings("rawtypes")
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_ALL_ROLE_INFO, request, List.class);
        @SuppressWarnings("unchecked")
        List<FShopRole> fshopRoleList = transData.getData();
        @SuppressWarnings("rawtypes")
        TransData<List> transDataRole = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_OWN_ROLE, request, List.class);
        @SuppressWarnings("unchecked")
        List<String> roleList = transDataRole.getData();
        request.setAttribute("roleList", roleList);
        request.setAttribute("userId", userId);
        request.setAttribute("fshopRoleList", fshopRoleList);
        return "shopUser/bind_role";
    }

}
