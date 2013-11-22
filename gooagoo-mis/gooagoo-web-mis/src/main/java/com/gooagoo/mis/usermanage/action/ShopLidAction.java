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
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.mis.constants.MisInterConstants;
import com.gooagoo.mis.httputil.HttpUtilsMis;
import com.gooagoo.mis.util.MisUtils;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MShopEntityInfo;
import com.gooagoo.view.mis.enterprise.MShopInfo;

@Controller
@RequestMapping("/shopLid")
public class ShopLidAction extends BaseAction
{
    /**
     * 查看商家lid信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showLidInfo")
    public String showLidInfo(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/shop/lid/search";
    }

    /**
     * 商家lid删除
     * @param request
     * @param response
     * @throws IOException 
     */
    @RequestMapping(params = "method=delLid")
    public void delLid(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        request.setAttribute("moduleId", "302010401");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_LID_DEL, request, response);
    }

    /**
     * lid信息分配
     * @param request
     * @param response
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=allotLid")
    public String allotLid(HttpServletRequest request, HttpServletResponse response)
    {

        //商家Id
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        request.setAttribute("shopId", shopId);

        //(List<MShopEntityInfo>) 
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, List.class);
        List<MShopEntityInfo> mShopEntityInfoList = respObj.getData();

        request.setAttribute("mShopEntityInfoList", mShopEntityInfoList);
        return "/usermanage/shop/lid/allot";
    }

    /**
     * 分配LID页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showSetLid")
    public String showSetLid(HttpServletRequest request, HttpServletResponse response)
    {
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        request.setAttribute("shopId", shopId);
        //LId设置页面
        return "/usermanage/shop/lid/allot";
    }

    /**
     * 查看LID页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=showLidList")
    public String showLidList(HttpServletRequest request, HttpServletResponse response)
    {
        //商家Id
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        request.setAttribute("shopId", shopId);

        //(List<MShopEntityInfo>) 
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, List.class);
        List<MShopEntityInfo> mShopEntityInfoList = respObj.getData();

        request.setAttribute("mShopEntityInfoList", mShopEntityInfoList);

        //LId设置页面
        return "/usermanage/shop/lid/search";
    }

    /**
     * 查询Lid列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryLidList")
    public String queryLidList(HttpServletRequest request, HttpServletResponse response)
    {
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        request.setAttribute("shopId", shopId);
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        request.setAttribute("shopEntityId", shopEntityId);
        //商家详细信息
        TransData<MShopInfo> respShop = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_SERVERTOOL_SHOPDETAIL, request, MShopInfo.class);
        MShopInfo pmShop = respShop.getData();
        request.setAttribute("pmShop", pmShop);
        //记录日志
        request.setAttribute("moduleId", "3020104");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_LID_SEARCHALL, request, PageModel.class);
        PageModel<MShopInfo> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));
        }
        MisLoginInfo MMisLoginInfo = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        if (MMisLoginInfo != null)
        {
            request.setAttribute("mis_login_auths", MMisLoginInfo.getAuthorities());
            request.setAttribute("mis_login_id", MMisLoginInfo.getLoginId());
            request.setAttribute("parentId3", "3020104");
        }
        //LId设置页面
        return "/usermanage/shop/lid/shopLidList";
    }

    /**
     * 保存lid
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=saveLid")
    public void saveLid(HttpServletRequest request, HttpServletResponse response) throws Exception
    { //记录日志
        request.setAttribute("moduleId", "3020103");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_LID_ALLOT, request, response);
    }

}
