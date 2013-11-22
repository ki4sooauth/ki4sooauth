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
import com.gooagoo.view.mis.enterprise.MDeviceWifisensor;
import com.gooagoo.view.mis.enterprise.MShopEntityInfo;
import com.gooagoo.view.mis.enterprise.MShopInfo;

@Controller
@RequestMapping("/shopWifisensor")
public class ShopWifisensorAction extends BaseAction
{
    /**
    * 查看商家Wifisensort信息
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(params = "method=showWifisensor")
    public String showWifisensor(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/shop/wifisensor/search";
    }

    /**
     * 商家Wifisensort删除
     * @param request
     * @param response
     * @throws IOException 
     */
    @RequestMapping(params = "method=delWifisensor")
    public void delWifisensor(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "302011101");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_WIFISENSOR_DEL, request, response);
    }

    /**
     * 添加Wifisensort
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=addWifisensor")
    public void addWifisensor(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "3020110");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_WIFISENSOR_ADD, request, response);

    }

    /**
     * 添加Wifisensort页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=showSetWifisensor")
    public String showSetWifisensor(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("moduleId", "30201");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, List.class);
        List<MShopEntityInfo> mShopEntityInfoList = respObj.getData();
        request.setAttribute("mShopEntityInfoList", mShopEntityInfoList);
        //shopTranspc设置页面
        return "/usermanage/shop/wifisensor/add";
    }

    /**
     * 查看
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=showWifisensorpcList")
    public String showWifisensorpcList(HttpServletRequest request, HttpServletResponse response)
    {
        //商家Id
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        request.setAttribute("shopId", shopId);

        request.setAttribute("moduleId", "30201");//权限Id
        request.setAttribute("moduleType", "mis");//模块

        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, List.class);
        List<MShopEntityInfo> mShopEntityInfoList = respObj.getData();
        request.setAttribute("mShopEntityInfoList", mShopEntityInfoList);

        return "/usermanage/shop/wifisensor/search";
    }

    /**
     * 查询Wifisensort列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=searchWifisensorList")
    public String searchWifisensorList(HttpServletRequest request, HttpServletResponse response)
    {
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        request.setAttribute("shopId", shopId);
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        request.setAttribute("shopEntityId", shopEntityId);
        String isDel = ServletRequestUtils.getStringParameter(request, "isDel", "");
        request.setAttribute("isDel", isDel);

        request.setAttribute("moduleId", "3020111");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_WIFISENSOR_SEARCHALL, request, PageModel.class);
        PageModel<MDeviceWifisensor> pm = respObj.getData();
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
            request.setAttribute("parentId3", "3020111");
        }
        //Transpc设置页面
        return "/usermanage/shop/wifisensor/shopWifisensorList";
    }

    /**
     * 编辑Wifisensort页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=updateWifisensorPage")
    public String updateWifisensorPage(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_NOPAGE, request, List.class);
        List<MShopInfo> shopInfoList = respObj.getData();
        request.setAttribute("shopInfoList", shopInfoList);
        TransData<MDeviceWifisensor> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_WIFISENSOR_SEARCHALLINFO, request, MDeviceWifisensor.class);
        MDeviceWifisensor deviceWifisensor = resObj.getData();
        request.setAttribute("deviceWifisensor", deviceWifisensor);
        if (deviceWifisensor != null && !"".equals(deviceWifisensor))
        {
            request.setAttribute("shopId", deviceWifisensor.getShopId());
            TransData<List> respObjEntity = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, List.class);
            List<MShopEntityInfo> mShopEntityInfoList = respObjEntity.getData();
            request.setAttribute("mShopEntityInfoList", mShopEntityInfoList);
        }
        return "/usermanage/shop/wifisensor/update";
    }

    /**
     * 编辑Wifisensort
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateWifisensor")
    public void updateWifisensor(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "302011102");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_WIFISENSOR_UPDATE, request, response);
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
}
