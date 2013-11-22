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
import com.gooagoo.view.mis.enterprise.MShopInfo;
import com.gooagoo.view.mis.recommendManage.MNominateShop;
import com.gooagoo.view.mis.recommendManage.MNominateShopBusiness;

@Controller
@RequestMapping("/nominateS")
public class NominateShopAction extends BaseAction
{
    /**
     * 推荐商家查询条件页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=quertConditionPage")
    public String quertConditionPage(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/nominate/shop_index";
    }

    /**
     * 推荐商家列表页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryListPage")
    public String quertListPage(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20401");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20401");//权限Id
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_SHOPALL, request, PageModel.class);
        PageModel<MNominateShopBusiness> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/rsrcmanage/nominate/shop_content";
    }

    /**
     * 推荐页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=nominateShopPage")
    public String nominateShopPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<MShopInfo> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_SHOP, request, MShopInfo.class);
        MShopInfo shop = respObj.getData();
        request.setAttribute("shop", shop);
        return "/rsrcmanage/nominate/shop_add";
    }

    /**
     * 推荐操作
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=nominateShop")
    public void nominateShop(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040101");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_ADD_NOMINATESHOP, request, response);
    }

    /**
     * 查询推荐页面-上方查询
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=cancelNominateShopPageIndex")
    public String cancelNominateShopPageIndex(HttpServletRequest request, HttpServletResponse response)
    {
        return "/rsrcmanage/nominate/shop_query_index";
    }

    /**
     * 查询推荐页面-下方列表
     * @param request
     * @param response
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=cancelNominateShopPage")
    public String cancelNominateShopPage(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "20401");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "20401");//权限Id
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
        }
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_QUERY_NOMINATESHOPALL, request, PageModel.class);
        PageModel<MNominateShopBusiness> pm = respObj.getData();
        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        return "/rsrcmanage/nominate/shop_query_content";
    }

    /**
     * 取消推荐操作
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=cancelNominateShop")
    public void cancelNominateShop(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040103");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_UPDATE_NOMINATESHOP, request, response);
    }

    /**
     * 修改推荐页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=updateShopPage")
    public String updateShopPage(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<MNominateShop> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_NOMINATE_UPDATE_SHOPPAGE, request, MNominateShop.class);
        MNominateShop shop = respObj.getData();
        request.setAttribute("shop", shop);
        return "/rsrcmanage/nominate/shop_update";
    }

    /**
     * 修改推荐操作
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=updateNominateShop")
    public void updateNominateShop(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "2040102");
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_UPDATE_NOMINATESHOPT, request, response);
    }

    /**
     * 验证活动是否已推荐
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=checkNominateShop")
    public void checkNominateShop(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        MisUtils.ajaxSubmit(MisInterConstants.MIS_NOMINATE_CHECK_SHOP, request, response);
    }
}
