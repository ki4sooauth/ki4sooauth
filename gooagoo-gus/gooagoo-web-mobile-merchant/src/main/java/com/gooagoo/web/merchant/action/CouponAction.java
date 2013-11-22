package com.gooagoo.web.merchant.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

/**
 * 手机优惠凭证
 * @author GOOAGOO
 *
 */
@Controller
@RequestMapping("/coupon")
public class CouponAction extends BaseAction
{

    @RequestMapping(params = "method=contentRequest")
    public void contentRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_MOBILE_GETCOUPONDATA);
    }

    @RequestMapping(params = "method=favoriteCouponRequest")
    public void favoriteCouponRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_MOBILE_FAVORITECOUPON);

    }

    @RequestMapping(params = "method=integralConvertRequest")
    public void integralConvertRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson2(request, response, InterGusConstants.MERCHANT_MOBILE_INTEGRALCONVERT);
    }

}
