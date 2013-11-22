package com.gooagoo.goods.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.google.gson.Gson;

/**
 * 商品营销信息管理  
 *
 */
@Controller
@RequestMapping("/goodsMarketing")
public class GoodsMarketingAction extends BaseAction
{
    /** 
     * 添加商品营销信息操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addMarketingDo")
    public void addMarketingDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute(GMSConstant.ESCAPE_STRING_TYPE_KEY, "N");
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODMARKETINGINFO_ADD, request, response);
    }

    /**
     * 修改商品营销信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=updateMarketingDo")
    public void updateMarketingDo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute(GMSConstant.ESCAPE_STRING_TYPE_KEY, "N");
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_GOODMARKETINGINFO_UPDATE, request, response);
    }

    /**
     * 获得全部的实体店信息
     * @param request
     * @param response 
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=getShopEntityList")
    public void getShopEntityList(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_SHOP_ENTITY_INFO, request, PageModel.class);
        PageModel<FShopEntityInfo> pm = respObj.getData();
        GooagooLog.debug("获得全部实体店信息，返回值为：" + new Gson().toJson(pm));
        String result = "";
        if (pm != null)
        {
            List<FShopEntityInfo> list = pm.getResult();
            result = new Gson().toJson(list);
        }

        ServletUtils.writeHtml(result, response);
    }
}
