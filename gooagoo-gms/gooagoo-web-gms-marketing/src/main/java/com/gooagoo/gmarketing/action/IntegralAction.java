package com.gooagoo.gmarketing.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoodsMarketing;
import com.gooagoo.view.gms.marketing.FCoupon;
import com.gooagoo.view.gms.marketing.FShopIntegral;

/**
 * 积分兑换
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/integral")
public class IntegralAction extends BaseAction
{

    /**
     * 主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "integral/index";
    }

    /**
     * 列表
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=list")
    public String list(HttpServletRequest request, HttpServletResponse response)
    {
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_INTEGRAL_PAGE, request, PageModel.class);
        PageModel<FShopIntegral> pm = respObj.getData();

        request.setAttribute("pm", pm);
        if (pm != null)
        {
            request.setAttribute("page_cur", pm.getPageIndex());
            request.setAttribute("page_start", pm.getPageStart(5));
            request.setAttribute("page_end", pm.getPageEnd(5));

        }
        return "integral/integral_list";
    }

    /**
     * 添加页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=addform")
    public String addform(HttpServletRequest request, HttpServletResponse response)
    {
        getFormDetail(request, response);
        return "integral/integral_edit";
    }

    /**
     * 修改页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=updateform")
    public String updateform(HttpServletRequest request, HttpServletResponse response)
    {
        getFormDetail(request, response);
        return "integral/integral_edit";
    }

    /**
     * 创建
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=create")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_INTEGRAL_ADD, request, response);
    }

    /**
     * 修改
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    @RequestMapping(params = "method=update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_INTEGRAL_UPDATE, request, response);
    }

    /**
     * 删除
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_INTEGRAL_DELETE, request, response);
    }

    public void getFormDetail(HttpServletRequest request, HttpServletResponse response)
    {
        String integralConvertId = ServletRequestUtils.getStringParameter(request, "integralId", "");
        FShopIntegral integralConvert = null;
        if (StringUtils.hasText(integralConvertId))
        {
            TransData<FShopIntegral> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_INTEGRAL_DETAIL, request, FShopIntegral.class);
            integralConvert = respObj.getData();
            if (integralConvert.getConvertType().equals("G"))
            {
                request.setAttribute("goodsId", integralConvert.getConvertObjectId());
                TransData<FGoodsMarketing> respObj2 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_GOODMARKETINGINFO_GET, request, FGoodsMarketing.class);
                FGoodsMarketing marketing = respObj2.getData();
                if (marketing != null)
                {
                    integralConvert.setImgUrl(marketing.getMainImg());
                }

            }
            else
            {
                request.setAttribute("id", integralConvert.getConvertObjectId());
                TransData<FCoupon> respObj1 = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_COUPON_DETAIL, request, FCoupon.class);
                FCoupon coupon = respObj1.getData();
                if (coupon != null)
                {
                    integralConvert.setImgUrl(coupon.getCouponUrl());
                }

            }

        }
        request.setAttribute("currentTime", TimeUtils.getCurrentDate());
        request.setAttribute("currentDateTime", TimeUtils.getCurrentDateTime());
        request.setAttribute("integral", integralConvert);
    }
}
