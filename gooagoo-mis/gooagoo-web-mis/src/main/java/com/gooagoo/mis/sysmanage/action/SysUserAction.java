package com.gooagoo.mis.sysmanage.action;

import java.util.List;

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
import com.gooagoo.view.mis.roleManage.MSysRole;
import com.gooagoo.view.mis.sysUserManage.MSysUserInfo;
import com.gooagoo.view.mis.sysUserManage.MSysUserRole;
import com.google.gson.Gson;

@Controller
@RequestMapping("/sysuser")
public class SysUserAction extends BaseAction
{
    /**
     * 主页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showmain")
    public String showmain(HttpServletRequest request, HttpServletResponse response)
    {
        return "/sysmanage/main";
    }

    /**
     * 左侧面板页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=leftPanel")
    public String leftPanel(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId", "1");//菜单权限
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("mis_login_id", MMisLoginInfo.getLoginId());
        }
        return "/sysmanage/leftPanel";
    }

    /**
     * 添加管理员页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showAddSysUser")
    public String showAddSysUser(HttpServletRequest request, HttpServletResponse response)
    {
        return "/sysmanage/sysuser/create/add";
    }

    /**
     * 保存管理员信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=saveSysUser")
    public void saveSysUser(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "1010101");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SYSUSER_SAVE, request, response);
    }

    /**
     * 修改管理员页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showModifySysUser")
    public String showModifySysUser(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("moduleId", "10102");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MSysUserInfo sysUserInfo = null;
        TransData<MSysUserInfo> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SYSUSER_DETAIL, request, MSysUserInfo.class);
        sysUserInfo = respObj.getData();
        request.setAttribute("sysUser", sysUserInfo);

        return "/sysmanage/sysuser/update/update";
    }

    /**
     * 修改管理员信息
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateSysUser")
    public void updateSysUser(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "1010202");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SYSUSER_UPDATE, request, response);
    }

    /**
     * 删除管理员
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=delSysUser")
    public void delSysUser(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "1010103");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SYSUSER_DEL, request, response);
    }

    /**
     * 管理员列表页面展示
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showSysUserList")
    public String showSysUserList(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        session.setAttribute("parentId2", "10101");//菜单权限

        return "/sysmanage/sysuser/search/index";
    }

    /**
     * 管理员列表信息
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=sysUserListContent")
    public String sysUserListContent(HttpServletRequest request, HttpServletResponse response)
    {
        //记录日志
        request.setAttribute("parentId2", "10101");//菜单权限
        request.setAttribute("moduleId", "10101");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SYSUSER_FINDALL, request, PageModel.class);
        PageModel<MSysUserInfo> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/sysmanage/sysuser/search/content";
    }

    /**
     * 用户分配角色页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=allotRole")
    public String allotRole(HttpServletRequest request, HttpServletResponse response)
    {
        //查询用户拥有的角色信息
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SYSUSER_CONTAINROLES, request, List.class);
        List<MSysUserRole> result = respObj.getData();

        //查询所有角色信息
        TransData<List> respSysRole = HttpUtilsMis.transferMis(MisInterConstants.MIS_ROLE_LIST_SEARCHALL, request, List.class);
        List<MSysRole> sysRolesResult = respSysRole.getData();

        String id = ServletRequestUtils.getStringParameter(request, "id", "");//勾选的用户ID
        if (!"".equals(id) && id != null)
        {
            String[] arr = id.split(",");
            request.setAttribute("userId", arr[0]);//当前用户Id
        }
        String[] arrIds = null;
        if (result != null)
        {
            arrIds = new String[result.size()];
            request.setAttribute("rolelen", result.size());
            MSysUserRole sysUserRole = null;
            for (int i = 0; i < result.size(); i++)
            {
                sysUserRole = result.get(i);
                arrIds[i] = sysUserRole.getRoleId();
            }
            request.setAttribute("userrole", new Gson().toJson(arrIds));//用户拥有的角色id集合
        }
        request.setAttribute("sysRolesResult", sysRolesResult);//所有角色信息

        return "/sysmanage/sysuser/setRole/setUserRole";
    }

    /**
     * 保存用户角色
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=saveUserRole")
    public void saveUserRole(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "1010104");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SYSUSER_SAVEUSERROLE, request, response);
    }

}
