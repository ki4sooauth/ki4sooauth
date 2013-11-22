package com.gooagoo.mis.usermanage.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.gooagoo.view.mis.enterprise.MShopInfo;
import com.gooagoo.view.mis.enterprise.MShopUserRole2;

@Controller
@RequestMapping("/shopUserManange")
public class ShopUserManangeAction extends BaseAction
{
    /**
     * 商家用户列表-上方查询
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showIndex")
    public String showIndex(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/shop/shopuser/shopuser_index";
    }

    /**
     * 商家用户列表-下方列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryAllShopUserManange")
    public String queryAllShopUserManange(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("parentId2", "30203");//菜单权限
        //记录日志
        request.setAttribute("moduleId", "30203");//权限Id
        MisLoginInfo info = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (info != null)
        {
            request.setAttribute("mis_login_auths", info.getAuthorities());
            request.setAttribute("misUserId", info.getLoginId());
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
        return "/usermanage/shop/shopuser/shopuser_content";
    }

    /**
     * 分配商家用户角色页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=assignShopUserManangePage")
    public String assignShopUserManangePage(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<MShopUserRole2> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_SHOPUSER_QUERY, request, MShopUserRole2.class);
        MShopUserRole2 user = resObj.getData();
        request.setAttribute("user", user);
        TransData<List> resObj2 = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_SHOPUSER_QUERYALL, request, List.class);
        List<MShopUserRole2> role = resObj2.getData();
        request.setAttribute("role", role);
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        request.setAttribute("shopId", shopId.split(",")[0]);
        return "/usermanage/shop/shopuser/shopuser_assign";
    }

    /**
     * 分配商家用户角色
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=assignShopUserManange")
    public void assignShopUserManange(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_SHOPUSER_ASSIGN, request, response);
    }
}
