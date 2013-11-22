package com.gooagoo.gstatus.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.gstatus.util.StatisUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoods;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;

@Controller
@RequestMapping("/goods")
public class GoodsAction
{
    /**
     * 跳转商品状态首页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=index")
    public String goodStatusIndex(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
         
    	StatisUtil.getEntityInfo(request);
        request.setAttribute("relateType", "G");
        request.setAttribute("dataType", "MS");
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_PAGE, request, PageModel.class);
        PageModel<FGoods> pm = respObj.getData();
        if (null != pm && null != pm.getResult() && !pm.getResult().isEmpty())
        {
            request.setAttribute("parentId", pm.getResult().get(0).getItemSerial());
            request.setAttribute("parentName", pm.getResult().get(0).getGoodsName());
        }
        GMSUtil.getWebUrlByAuthorityId(request,"12");
        request.setAttribute("pageFlag", "goods");
        return "status/goods/goodsStatus";
    }
}
