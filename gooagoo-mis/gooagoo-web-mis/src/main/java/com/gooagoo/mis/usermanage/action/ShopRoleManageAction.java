package com.gooagoo.mis.usermanage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.gooagoo.view.mis.enterprise.MShopRole2;
import com.google.gson.Gson;

@Controller
@RequestMapping("/shopRoleManage")
public class ShopRoleManageAction extends BaseAction
{

    /**
     * 商家角色列表-上方查询
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showIndex")
    public String showIndex(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/shop/shoprole/shoprole_index";
    }

    /**
     * 商家角色列表-下方列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryAllShopRoleManage")
    public String queryAllShopRoleManage(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "30202");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "30202");//权限Id
        TransData<PageModel> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_SHOPROLE2_QUERYALL, request, PageModel.class);
        PageModel<MShopRole2> pm = resObj.getData();
        MisLoginInfo info = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (info != null)
        {
            request.setAttribute("mis_login_auths", info.getAuthorities());
            request.setAttribute("misUserId", info.getLoginId());
        }
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/usermanage/shop/shoprole/shoprole_content";
    }

    /**
     * 新增商家角色页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addShopRoleManagePage")
    public String addShopRoleManagePage(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/shop/shoprole/shoprole_add";
    }

    /**
     * 新增商家角色
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=addShopRoleManage")
    public void addShopRoleManage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "3020201");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_SHOPROLE2_ADD, request, response);
    }

    /**
     * 修改商家角色页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=updateShopRoleManagePage")
    public String updateShopRoleManagePage(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<MShopRole2> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_SHOPROLE2_QUERY, request, MShopRole2.class);
        MShopRole2 role = resObj.getData();
        request.setAttribute("role", role);
        return "/usermanage/shop/shoprole/shoprole_update";
    }

    /**
     * 修改商家角色
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateShopRoleManage")
    public void updateShopRoleManage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "3020202");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_SHOPROLE2_UPDATE, request, response);
    }

    /**
     * 删除商家角色
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=deleteShopRoleManage")
    public void deleteShopRoleManage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "3020203");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_SHOPROLE2_DELETE, request, response);
    }

    /**
     * 分配权限页面
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=assignShopRoleManagePage")
    public String assignShopRoleManageIndex(HttpServletRequest request, HttpServletResponse response)
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids","");
        request.setAttribute("ids", ids);
        return "/usermanage/shop/shoprole/shoprole_assign";
    }
    
    /**
     * 查询并匹配所有商家权限
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=assignShopRoleManageLoad")
    public void assignShopRoleManagePage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_SHOPROLEAUTHORITY2_QUERY, request, List.class);
        List<MZTreeNode> tree = respObj.getData();
        Gson gson = new Gson();
        String json = gson.toJson(tree);
        ServletUtils.writeHtml(json, response);
    }

    /**
     * 分配权限
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=assignShopRoleManage")
    public void assignShopRoleManage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "3020204");//权限Id
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_SHOPROLE2_ASSIGN, request, response);
    }
}
