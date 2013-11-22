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
import com.gooagoo.view.mis.enterprise.MDeviceAssistant;
import com.gooagoo.view.mis.enterprise.MShopEntityInfo;
import com.gooagoo.view.mis.enterprise.MShopInfo;

@Controller
@RequestMapping("/shopAssistant")
public class ShopAssistantAction extends BaseAction
{

    /**
     * 查看商家Assistant信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=showAssistant")
    public String showAssistant(HttpServletRequest request, HttpServletResponse response)
    {
        return "/usermanage/shop/assistant/search";
    }

    /**
     * 商家Assistant删除
     * @param request
     * @param response
     * @throws IOException 
     */
    @RequestMapping(params = "method=delAssistant")
    public void delAssistant(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "302010901");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_ASSISTANT_DEL, request, response);
    }

    /**
     * 添加Assistant
     * @param request
     * @param response
     * @throws Exception 
     */
    @RequestMapping(params = "method=addAssistant")
    public void addAssistant(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "3020108");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_ASSISTANT_ADD, request, response);

    }

    /**
     * 添加Assistant页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(params = "method=showSetAssistant")
    public String showSetAssistant(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("moduleId", "30201");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, List.class);
        List<MShopEntityInfo> mShopEntityInfoList = respObj.getData();
        request.setAttribute("mShopEntityInfoList", mShopEntityInfoList);
        //shopTranspc设置页面
        return "/usermanage/shop/assistant/add";
    }

    /**
     * 查看
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=showAssistantpcList")
    public String showAssistantpcList(HttpServletRequest request, HttpServletResponse response)
    {
        //商家Id
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        request.setAttribute("shopId", shopId);

        request.setAttribute("moduleId", "30201");//权限Id
        request.setAttribute("moduleType", "mis");//模块

        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, List.class);
        List<MShopEntityInfo> mShopEntityInfoList = respObj.getData();
        request.setAttribute("mShopEntityInfoList", mShopEntityInfoList);

        return "/usermanage/shop/assistant/search";
    }

    /**
     * 查询Assistant列表
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=searchAssistantList")
    public String searchAssistantList(HttpServletRequest request, HttpServletResponse response)
    {
        String shopId = ServletRequestUtils.getStringParameter(request, "shopId", "");
        request.setAttribute("shopId", shopId);
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        request.setAttribute("shopEntityId", shopEntityId);
        String isDel = ServletRequestUtils.getStringParameter(request, "isDel", "");
        request.setAttribute("isDel", isDel);

        request.setAttribute("moduleId", "3020109");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        TransData<PageModel> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ASSISTANT_SEARCHALL, request, PageModel.class);
        PageModel<MDeviceAssistant> pm = respObj.getData();
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
            request.setAttribute("parentId3", "3020109");
        }
        //Transpc设置页面
        return "/usermanage/shop/assistant/shopAssistantList";
    }

    /**
     * 编辑页面
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=updateAssistantpcPage")
    public String updateAssistantpcPage(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<List> respObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_NOPAGE, request, List.class);
        List<MShopInfo> shopInfoList = respObj.getData();
        request.setAttribute("shopInfoList", shopInfoList);
        TransData<MDeviceAssistant> resObj = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ASSISTANT_SEARCHALLINFO, request, MDeviceAssistant.class);
        MDeviceAssistant deviceAssistant = resObj.getData();
        request.setAttribute("deviceAssistant", deviceAssistant);
        if (deviceAssistant != null && !"".equals(deviceAssistant))
        {
            request.setAttribute("shopId", deviceAssistant.getShopId());
            TransData<List> respObjEntity = HttpUtilsMis.transferMis(MisInterConstants.MIS_SHOP_ENTITY_SEARCHALL, request, List.class);
            List<MShopEntityInfo> mShopEntityInfoList = respObjEntity.getData();
            request.setAttribute("mShopEntityInfoList", mShopEntityInfoList);
        }
        return "/usermanage/shop/assistant/update";
    }

    /**
     * 编辑页面
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=updateAssistantpc")
    public void updateAssistantpc(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("moduleId", "302010902");//权限Id
        request.setAttribute("moduleType", "mis");//模块
        MisUtils.ajaxSubmit(MisInterConstants.MIS_SHOP_ASSISTANT_UPDATE, request, response);
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
