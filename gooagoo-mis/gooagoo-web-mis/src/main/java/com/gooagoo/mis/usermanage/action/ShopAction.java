package com.gooagoo.mis.usermanage.action;

import java.io.IOException;
import java.util.ArrayList;
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
import com.gooagoo.view.mis.enterprise.MShopInfo;

@Controller
@RequestMapping("/shop")
public class ShopAction extends BaseAction
{

    /**
     * 展示商家首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showIndex")
    public String showIndex(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        session.setAttribute("parentId2", "30201");//菜单权限

        return "/usermanage/shop/search/index";
    }

    /**
     * 商家列表内容
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=sysShopListContent")
    public String sysShopListContent(HttpServletRequest request, HttpServletResponse response)
    {
        //记录日志
        request.setAttribute("parentId2", "30201");//菜单权限
        request.setAttribute("moduleId", "30201");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("misUserId", MMisLoginInfo.getLoginId());
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
        return "/usermanage/shop/search/content";
    }

    /**
     * 查看商家基本信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showBasicInfo")
    public String showBasicInfo(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/shop/detail/basicInfo";
    }

    /**
     * 查看商家wifi信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showWifiInfo")
    public String showWifiInfo(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/shop/detail/wifi";
    }

    /**
     * 锁定商家
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=lockShop")
    public void lockShop(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "3020103");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_LOCK, request, response);
    }

    /**
     * 审核商家页面
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=examineShop")
    public String examineShop(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");//勾选的商家ID
        if (!"".equals(id) && id != null)
        {
            String[] arr = id.split(",");
            request.setAttribute("shopId", arr[0]);//商家Id
        }
        return "/usermanage/shop/audit/audit";
    }

    /**
     * 审核商家
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=auditShop")
    public void auditShop(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String type = ServletRequestUtils.getStringParameter(request, "type", "");
        request.setAttribute("moduleId", "3020102");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        if ("N".equals(type))
        {
            MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_AUDIT_NOT_APPROVED, request, response);
        }
        else
        {
            MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_AUDIT, request, response);
        }
    }

    /**
     * 商家列表信息
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=shopListContent")
    public String shopListContent(HttpServletRequest request, HttpServletResponse response)
    {
        // TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOPINFO_FINDALL, request, PageModel.class);
        PageModel<MShopInfo> pm = new PageModel();
        //respObj.getData();

        List<MShopInfo> shops = new ArrayList();
        MShopInfo shopInfo = new MShopInfo();
        shopInfo.setShopId("1");

        shops.add(shopInfo);
        pm.setResult(shops);
        pm.setCount(1);

        System.out.println(pm.getPageIndex() + "000000000000000000");

        request.setAttribute("pm", pm);
        request.setAttribute("page_cur", pm.getPageIndex());
        request.setAttribute("page_start", pm.getPageStart(1));
        request.setAttribute("page_end", pm.getPageEnd(1));
        System.out.println(333333);
        return "/usermanage/shop/search/content";
    }

}
