package com.gooagoo.gshopinfo.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.SysdictionaryCache;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.ShopUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoodsBrand;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.FShopUserInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/shopUser")
public class ShopUserInfoAction
{

    /**
     * 分页查询营销中心用户信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return "shopUser/index";
    }

    /**
     * 跳转编辑营销中心用户信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=addform")
    public String addForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel = transData2.getData();
        ShopUtil.transferShopInfo(request);
        if (pageModel != null)
        {
            request.setAttribute("entityList", pageModel.getResult());
        }
        Map<String, String> map = SysdictionaryCache.get("shop_user_head_img");
        request.setAttribute("headImg", map);
        return "shopUser/edit";
    }

    /**
     * 跳转编辑营销中心用户信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=updateform")
    public String updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String userId = ServletRequestUtils.getStringParameter(request, "userId", "");
        if (StringUtils.isNotBlank(userId))
        {
            TransData<FShopUserInfo> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_SHOP_USER_INFO, request, FShopUserInfo.class);
            FShopUserInfo userInfo = transData.getData();
            request.setAttribute("userInfo", userInfo);
        }

        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODBRAND_GETLIST, request, List.class);
        @SuppressWarnings("unchecked")
        List<FGoodsBrand> brandList = transData.getData();

        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopEntityInfo> pageModel = transData2.getData();
        ShopUtil.transferShopInfo(request);
        request.setAttribute("entityList", pageModel.getResult());
        request.setAttribute("brandList", brandList);
        Map<String, String> map = SysdictionaryCache.get("shop_user_head_img");
        request.setAttribute("headImg", map);
        return "shopUser/edit";
    }

    /**
     * 返回所属品牌
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=brandList")
    public void brandList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        TransData<List> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODBRAND_GETLIST, request, List.class);
        @SuppressWarnings("unchecked")
        List<FGoodsBrand> brandList = transData.getData();
        for (int i = 0; i < brandList.size(); i++)
        {
            if (!shopEntityId.equals(brandList.get(i).getEntityId()))
            {
                brandList.remove(i);
                i--;
            }

        }

        String json = new Gson().toJson(brandList);
        ServletUtils.writeHtml(json, response);
    }

    /**
     * 查询店员头像信息
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(params = "method=headImg")
    public void headImg(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Map<String, String> map = SysdictionaryCache.get("shop_user_head_img");
        String json = new Gson().toJson(map);
        ServletUtils.writeHtml(json, response);
    }

    /**
     * 添加营销中心用户
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_ADD_SHOP_USER_INFO, request, response);
    }

    /**
     *更新营销中心用户信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_SHOP_USER_INFO, request, response);
    }

    /**
     * 删除营销中心用户信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_DEL_SHOP_USER_INFO, request, response);
    }

    /**
     * 分页查询营销中心用户信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=page")
    public String page(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_USER_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FShopUserInfo> pageModel = transData.getData();
        request.setAttribute("pageModel", pageModel);
        if (pageModel != null)
        {
            request.setAttribute("page_cur", pageModel.getPageIndex());
            request.setAttribute("page_start", pageModel.getPageStart(5));
            request.setAttribute("page_end", pageModel.getPageEnd(5));
        }
        return "shopUser/list";
    }

    /**
     * 更改营销中心用户角色
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=updateRole")
    public void updateRole(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_USER_ROLE, request, response);
    }

    /**
     * 查询营销中心用户详细信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=detail")
    public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FShopUserInfo> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_SHOP_USER_INFO, request, FShopUserInfo.class);
        FShopUserInfo userInfo = transData.getData();
        String idTypeCn = SysdictionaryCache.get("idtype", userInfo.getIdType());
        userInfo.setIdTypeCn(idTypeCn);
        request.setAttribute("userInfo", userInfo);
        return "shopUser/detail";
    }
}
