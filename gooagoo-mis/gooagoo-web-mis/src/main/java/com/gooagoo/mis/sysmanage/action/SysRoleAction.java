package com.gooagoo.mis.sysmanage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.mis.util.MisUtils;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.common.MZTreeNode;
import com.gooagoo.view.mis.roleManage.MSysRole;
import com.google.gson.Gson;

@Controller
@RequestMapping("/sysRole")
public class SysRoleAction extends BaseAction
{

    /**
     * 添加角色页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showAddRole")
    public String showAddRole(HttpServletRequest request, HttpServletResponse response)
    {
        return "/sysmanage/roleAuthority/create/add";
    }

    /**
     * 添加角色
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=addRole")
    public void addRole(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "1020101");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_ROLE_ADD, request, response);
    }

    /**
     * 修改角色页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showUpdateRole")
    public String showUpdateRole(HttpServletRequest request, HttpServletResponse response)
    {
        MSysRole sysRole = null;
        TransData<MSysRole> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_ROLE_DETAIL, request, MSysRole.class);
        sysRole = respObj.getData();
        request.setAttribute("sysRole", sysRole);
        return "/sysmanage/roleAuthority/update/update";
    }

    /**
     * 修改角色
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateRole")
    public void updateRole(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "1020102");//权限Id
        request.setAttribute("moduleType", "mis");//模块

        MisUtils.ajaxSubmit(MisInterConstants.MIS_ROLE_UPDATE, request, response);
    }

    /**
     * 删除角色
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=delRole")
    public void delRole(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "1020103");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_ROLE_DEL, request, response);
    }

    /**
     * 设置权限页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showSetAuthority")
    public String showSetAuthority(HttpServletRequest request, HttpServletResponse response)
    {
        String roleId = ServletRequestUtils.getStringParameter(request, "id", "");//角色Id
        if (!"".equals(roleId) && roleId != null)
        {
            String[] arr = roleId.split(",");
            request.setAttribute("roleId", arr[0]);//角色Id
        }
        return "/sysmanage/roleAuthority/setauthority/setAuthority";
    }

    /**
     * 角色设置权限页面展示
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=searchAllAuthority")
    public void searchAllAuthority(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //查询角色权限
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_AUTHORITY_SEARCHALL, request, List.class);
        List<MZTreeNode> result = respObj.getData();
        Gson gson = new Gson();
        String json = gson.toJson(result);
        ServletUtils.writeHtml(json, response);
    }

    /**
     * 保存角色所属权限
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=saveAuthority")
    public void saveAuthority(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "1020104");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_ROLE_AUTHORITY, request, response);
    }

    /**
     * 查询角色首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showRoleList")
    public String showRoleList(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        session.setAttribute("parentId2", "10201");//菜单权限

        return "/sysmanage/roleAuthority/search/index";
    }

    /**
     * 角色列表内容页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=showRoleListContent")
    public String showRoleListContent(HttpServletRequest request, HttpServletResponse response)
    {
        //记录日志
        request.setAttribute("parentId2", "10201");//菜单权限
        request.setAttribute("moduleId", "10201");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("moduleId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_ROLE_SEARCHALL, request, PageModel.class);
        PageModel<MSysRole> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/sysmanage/roleAuthority/search/content";
    }

}
