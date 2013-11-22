package com.gooagoo.mis.interfmanage.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.mis.util.MisUtils;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MShopInfo;
import com.gooagoo.view.mis.merchantInterface.MShopInterfaceInfo;

@Controller
@RequestMapping("/interfshop")
public class InterfShopAction extends BaseAction
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
        return "/interfmanage/main";
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
        request.setAttribute("parentId", "4");//菜单权限
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("mis_login_id", MMisLoginInfo.getLoginId());
        }
        return "/interfmanage/leftPanel";
    }

    /**
     * 展示商家首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        session.setAttribute("parentId2", "40201");//菜单权限

        return "/interfmanage/shop/search/index";
    }

    /**
     * 查询商家列表
     * @param request
     * @param response
     * @throws IOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=searchShopList")
    public String searchShopList(HttpServletRequest request, HttpServletResponse response)
    {
        //记录日志
        request.setAttribute("parentId2", "40201");//菜单权限
        request.setAttribute("moduleId", "40201");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("mis_login_id", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_PAGE, request, PageModel.class);
        PageModel<MShopInfo> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return "/interfmanage/shop/search/content";
    }

    /**
     * 分配商家接口页面
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=allotShopInterfForm")
    public String allotShopInterfForm(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setAttribute("shopId", request.getParameter("shopId"));

        return "/interfmanage/shop/add/allotShopInterf";
    }

    /**
     * 分配商家接口
     * @param request
     * @param response
     * @throws 
     */
    @RequestMapping(params = "method=allotShopInterf")
    public void allotShopInterf(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        request.setAttribute("moduleId", "4020101");//权限Id
        request.setAttribute("moduleType", "mis");//模块

        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_INTERFACE_ALLOT, request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=shopInterfListIndex")
    public String shopInterfListIndex(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("shopId", request.getParameter("shopId"));

        HttpSession session = request.getSession();
        session.setAttribute("parentId3", "4020102");//菜单权限

        return "/interfmanage/shop/interf/shopInterfIndex";
    }

    /**
     * 商家接口列表页
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=shopInterfList")
    public String shopInterfList(HttpServletRequest request, HttpServletResponse response)
    {
        //记录日志
        request.setAttribute("parentId3", "4020102");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("mis_login_id", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_INTERFACE_PAGE, request, PageModel.class);
        PageModel<MShopInterfaceInfo> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }

        return "/interfmanage/shop/interf/shopInterfContent";
    }

    /**
     * 商家接口信息编辑页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=formEdit")
    public String formEdit(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<MShopInterfaceInfo> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_INTERFACE_DETAIL, request, MShopInterfaceInfo.class);
        MShopInterfaceInfo vo = respObj.getData();

        request.setAttribute("vo", vo);

        return "/interfmanage/shop/update/formEdit";
    }

    /**
     * 修改
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        request.setAttribute("moduleId", "402010201");//权限Id
        request.setAttribute("moduleType", "mis");//模块

        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_INTERFACE_UPD, request, response);
    }

    /**
     * 删除商家分配的接口
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_INTERFACE_DEL, request, response);
    }

}
