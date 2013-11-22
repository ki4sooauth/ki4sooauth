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
import com.gooagoo.view.mis.enterprise.MDeviceTransponder;
import com.gooagoo.view.mis.enterprise.MShopEntityInfo;
import com.gooagoo.view.mis.enterprise.MShopInfo;

@Controller
@RequestMapping("/shopTranspc")
public class TransponderAction extends BaseAction
{
    /**
     * 展示商家Transpc信息页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showTranspcInfo")
    public String showTranspcInfo(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/shop/transponder/search";
    }

    /**
     * 商家Transpc删除
     * @param request
     * @param response
     * @throws IOException 
     */
    @RequestMapping(params = "method=delTranspc")
    public void delTranspc(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //记录日志
        request.setAttribute("moduleId", "302010701");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_TRANSPC_DEL, request, response);
    }

    /**
     * 添加Transpc功能操作
     * @param request
     * @param response
     */
    @RequestMapping(params = "method=addTranspc")
    public void addTranspc(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "3020106");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_TRANSPC_ADD, request, response);
    }

    /**
     * 添加Transpc页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=showSetTranspc")
    public String showSetTranspc(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, List.class);
        List<MShopEntityInfo> mShopEntityInfoList = respObj.getData();
        request.setAttribute("mShopEntityInfoList", mShopEntityInfoList);
        this.queryData(request, response);
        return "/usermanage/shop/transponder/add";
    }

    /**
     * 查询Transpc信息-上方查询
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=showTranspcList")
    public String showTranspcList(HttpServletRequest request, HttpServletResponse response)
    {
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        request.setAttribute("shopId", shopId);
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, List.class);
        List<MShopEntityInfo> mShopEntityInfoList = respObj.getData();
        request.setAttribute("mShopEntityInfoList", mShopEntityInfoList);
        return "/usermanage/shop/transponder/search";
    }

    /**
     * 查询Transpc信息-下方列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=queryTranspcList")
    public String queryTranspcList(HttpServletRequest request, HttpServletResponse response)
    {
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        request.setAttribute("shopId", shopId);
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        request.setAttribute("shopEntityId", shopEntityId);
        String isDel = ServletRequestUtils.getStringParameter(request, "isDel", "");
        request.setAttribute("isDel", isDel);
        //记录日志
        request.setAttribute("moduleId", "3020107");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_TRANSPC_SEARCHALL, request, PageModel.class);
        PageModel<MDeviceTransponder> pm = respObj.getData();
        request.setAttribute("pm", pm);
        //商家详细信息
        TransData<MShopInfo> respShop = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_SERVERTOOL_SHOPDETAIL, request, MShopInfo.class);
        MShopInfo pmShop = respShop.getData();
        request.setAttribute("pmShop", pmShop);
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
            request.setAttribute("parentId3", "3020107");
        }
        this.queryData(request, response);
        return "/usermanage/shop/transponder/shopTranspcList";
    }

    /**
     * 编辑Transpc页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=updateTranspcPage")
    public String updateTranspcPage(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_NOPAGE, request, List.class);
        List<MShopInfo> shopInfoList = respObj.getData();
        request.setAttribute("shopInfoList", shopInfoList);
        TransData<MDeviceTransponder> respObjTrans = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_TRANSPC_SEARCHALLINFO, request, MDeviceTransponder.class);
        MDeviceTransponder mtrans = respObjTrans.getData();
        request.setAttribute("mtrans", mtrans);
        if (mtrans != null && !"".equals(mtrans))
        {
            request.setAttribute("shopId", mtrans.getShopId());
            TransData<List> respObjEntity = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, List.class);
            List<MShopEntityInfo> mShopEntityInfoList = respObjEntity.getData();
            request.setAttribute("mShopEntityInfoList", mShopEntityInfoList);
        }
        this.queryData(request, response);
        return "/usermanage/shop/transponder/update";
    }

    /**
     * 编辑Transpc
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=updateTranspc")
    public void updateTranspc(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "302010702");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_TRANSPC_UPDATE, request, response);
    }

    /**
     * 根据商家ID查询商家实体店集合
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=selectShopEntityInfo")
    public void selectShopEntityInfo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        MisUtils.ajaxSubmitData(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, response);
    }

    /**
     * 查询通用字典表信息
     * @param request
     * @param response
     * @return
     */
    private void queryData(HttpServletRequest request, HttpServletResponse response)
    {
        MisUtils.queryData(new String[] { "bill_parse", "st_service" }, request, response);
    }
}
