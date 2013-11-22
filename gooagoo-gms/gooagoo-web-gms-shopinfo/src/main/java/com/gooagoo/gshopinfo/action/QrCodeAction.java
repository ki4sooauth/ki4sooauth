package com.gooagoo.gshopinfo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSHttpUtils;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoods;
import com.gooagoo.view.gms.marketing.FActivity;
import com.gooagoo.view.gms.marketing.FCoupon;
import com.gooagoo.view.gms.shopinfo.FTableInfo;

/**
 * 二维码管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/qrCode")
public class QrCodeAction extends BaseAction
{
    /**
     * 二维码管理设置-餐桌
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("detail", "str");
        request.setAttribute("flag", "140404");
        request.setAttribute("coding", "gmsb198");
        UtilsShopEntity.shopEntity(request, response);
        return "qrCode/index";
    }

    /**
     * 二维码管理设置-餐桌
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=tableInfo")
    public String tableInfo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String codeName = ServletRequestUtils.getStringParameter(request, "codeName", "");
        String picSize = ServletRequestUtils.getStringParameter(request, "picSize", "");
        String pageSize = ServletRequestUtils.getStringParameter(request, "pageSize", "5");
        String flag = ServletRequestUtils.getStringParameter(request, "flag", "");
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");

        request.setAttribute("codeName", codeName);
        request.setAttribute("picSize", picSize);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("flag", flag);
        request.setAttribute("shopEntityId", shopEntityId);
        request.setAttribute("coding", "gmsb198");
        return "qrCode/goodsList";
    }

    /**
     * 分页查询桌号二维码信息-餐桌
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=pageTwoDimCode")
    public String pageTwoDimCode(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_PAGE_TABLE_INFO, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FTableInfo> model = transData.getData();
        String codeName = ServletRequestUtils.getStringParameter(request, "codeName", "");
        request.setAttribute("pageModel", model);
        if (model != null)
        {
            request.setAttribute("page_cur", model.getPageIndex());
            request.setAttribute("page_start", model.getPageStart(5));
            request.setAttribute("page_end", model.getPageEnd(5));
        }
        request.setAttribute("codeName", codeName);

        return "qrCode/codeList";
    }

    /**
     * 二维码管理设置-商品
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=gIndex")
    public String goodsIndex(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("goods", "");
        request.setAttribute("flag", "140401");
        request.setAttribute("coding", "gmsb012");
        UtilsShopEntity.shopEntity(request, response);
        return "qrCode/index";
    }

    /**
     * 分页查询商品二维码信息-商品
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=twoDimGoods")
    public String pageAcquire(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        @SuppressWarnings("rawtypes")
        TransData<PageModel> transData = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOOD_PAGE, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FGoods> model = transData.getData();
        List<FGoods> list = new ArrayList<FGoods>();
        for (FGoods t : model.getResult())
        {
            if (StringUtils.hasText(t.getWebVisitUrl()))
            {
                list.add(t);
            }
        }

        PageModel<FGoods> pModel = new PageModel<FGoods>();
        pModel.setCount(list.size());
        pModel.setPageIndex(model.getPageIndex());
        pModel.setPageSize(model.getPageSize());
        pModel.setResult(list);

        String codeName = ServletRequestUtils.getStringParameter(request, "codeName", "");
        if (codeName.equals("X"))
        {
            request.setAttribute("pageModel", pModel);
            request.setAttribute("page_cur", pModel.getPageIndex());
            request.setAttribute("page_start", pModel.getPageStart(5));
            request.setAttribute("page_end", pModel.getPageEnd(5));
        }
        else
        {
            request.setAttribute("pageModel", model);
            request.setAttribute("page_cur", model.getPageIndex());
            request.setAttribute("page_start", model.getPageStart(5));
            request.setAttribute("page_end", model.getPageEnd(5));
        }
        request.setAttribute("codeName", codeName);
        request.setAttribute("coding", "gmsb012");
        return "qrCode/gCodeList";
    }

    /**
     * 二维码管理设置-优惠凭证
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=cIndex")
    public String cIndex(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("goods", "");
        request.setAttribute("coupon", "str");
        request.setAttribute("flag", "140402");
        request.setAttribute("coding", "gmsd082");
        return "qrCode/index";
    }

    /**
     * 分页查询商品二维码信息-商品
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=twoDimCoupon")
    public String pageCoupon(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        @SuppressWarnings("rawtypes")
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_COUPON_PGAE, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FCoupon> model = respObj.getData();
        List<FCoupon> list = new ArrayList<FCoupon>();
        for (FCoupon t : model.getResult())
        {
            if (StringUtils.hasText(t.getWebVisitUrl()))
            {
                list.add(t);
            }
        }

        PageModel<FCoupon> pModel = new PageModel<FCoupon>();
        pModel.setCount(list.size());
        pModel.setPageIndex(model.getPageIndex());
        pModel.setPageSize(model.getPageSize());
        pModel.setResult(list);
        String codeName = ServletRequestUtils.getStringParameter(request, "codeName", "");
        if (codeName.equals("X"))
        {
            request.setAttribute("pageModel", pModel);
            request.setAttribute("page_cur", pModel.getPageIndex());
            request.setAttribute("page_start", pModel.getPageStart(5));
            request.setAttribute("page_end", pModel.getPageEnd(5));
        }
        else
        {
            request.setAttribute("pageModel", model);
            request.setAttribute("page_cur", model.getPageIndex());
            request.setAttribute("page_start", model.getPageStart(5));
            request.setAttribute("page_end", model.getPageEnd(5));
        }
        request.setAttribute("codeName", codeName);
        request.setAttribute("coding", "gmsd082");
        return "qrCode/cCodeList";
    }

    /**
     * 二维码管理设置-活动
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=aIndex")
    public String aIndex(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setAttribute("goods", "");
        request.setAttribute("coupon", "str");
        request.setAttribute("flag", "140403");
        request.setAttribute("coding", "gmsb011");
        return "qrCode/index";
    }

    /**
     * 分页查询商品二维码信息-活动
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=twoDimActivty")
    public String pageActivty(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        @SuppressWarnings("rawtypes")
        TransData<PageModel> respObj = GMSHttpUtils.transfer(InterGmsConstants.I_GMS_ACTIVITY_PAGE, request, PageModel.class);
        @SuppressWarnings("unchecked")
        PageModel<FActivity> model = respObj.getData();
        List<FActivity> list = new ArrayList<FActivity>();
        for (FActivity t : model.getResult())
        {
            if (StringUtils.hasText(t.getWebVisitUrl()))
            {
                list.add(t);
            }
        }

        PageModel<FActivity> pModel = new PageModel<FActivity>();
        pModel.setCount(list.size());
        pModel.setPageIndex(model.getPageIndex());
        pModel.setPageSize(model.getPageSize());
        pModel.setResult(list);
        String codeName = ServletRequestUtils.getStringParameter(request, "codeName", "");
        if (codeName.equals("X"))
        {
            request.setAttribute("pageModel", pModel);
            request.setAttribute("page_cur", pModel.getPageIndex());
            request.setAttribute("page_start", pModel.getPageStart(5));
            request.setAttribute("page_end", pModel.getPageEnd(5));
        }
        else
        {
            request.setAttribute("pageModel", model);
            request.setAttribute("page_cur", model.getPageIndex());
            request.setAttribute("page_start", model.getPageStart(5));
            request.setAttribute("page_end", model.getPageEnd(5));
        }
        request.setAttribute("codeName", codeName);
        request.setAttribute("coding", "gmsb011");
        return "qrCode/aCodeList";
    }
}
