package com.gooagoo.mis.usermanage.action;

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
import com.gooagoo.view.mis.enterprise.MShopToolList;

@Controller
@RequestMapping("/shoptool")
public class ShopToolAction extends BaseAction
{
    /**
     * 服务工具列表-上方
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=searchShopToolListIndex")
    public String searchShopToolListIndex(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("shopId", request.getParameter("shopId"));

        return "/usermanage/shop/shoptool/index";
    }

    /**
    * 服务工具列表-下方列表
    * @param request
    * @param response
    * @return
    */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=searchShopToolList")
    public String searchShopToolList(HttpServletRequest request, HttpServletResponse response)
    {
        //记录日志
        request.setAttribute("moduleId", "3020105");//权限Id
        request.setAttribute("moduleType", "mis");//模块

        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_TOOL_PAGE, request, PageModel.class);
        PageModel<MShopToolList> pm = respObj.getData();

        // TODO 查询商家名称,待修改
        //商家详细信息
        TransData<MShopInfo> respShop = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_SERVERTOOL_SHOPDETAIL, request, MShopInfo.class);
        MShopInfo pmShop = respShop.getData();

        request.setAttribute("pm", pm);
        request.setAttribute("pmShop", pmShop);
        if (pm != null && pmShop != null)
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
            request.setAttribute("parentId3", "3020105");
        }
        return "/usermanage/shop/shoptool/content";
    }

    /**
     * 修改（通过，不通过）
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        request.setAttribute("moduleId", "");//权限Id
        request.setAttribute("moduleType", "mis");//模块

        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_TOOL_UPD, request, response);
    }

    /**
     * 服务工具审核页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=toolCheckForm")
    public String toolCheckForm(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("shopId", request.getParameter("shopId"));

        return "/usermanage/shop/shoptool/formToolCheck";
    }

}
