package com.gooagoo.gstatus.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.gstatus.util.StatisUtil;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FCoupon;

@Controller
@RequestMapping("/coupon")
public class CouponAction
{
    /**
     * 优惠评证状态信息
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(params = "method=index")
    public String couponInex(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setAttribute("relateType", "C");
        request.setAttribute("dataType", "MS");
        TransData<PageModel> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_RELATION_PAGE, request, PageModel.class);
        PageModel<FCoupon> pm = respObj.getData();
        if (null != pm && null != pm.getResult() && !pm.getResult().isEmpty())
        {
            request.setAttribute("parentId", pm.getResult().get(0).getCouponId());
            request.setAttribute("parentName", pm.getResult().get(0).getCouponName());
        }
        StatisUtil.getEntityInfo(request);
        GMSUtil.getWebUrlByAuthorityId(request,"12");
        request.setAttribute("pageFlag", "coupon");
        return "status/coupon/couponStatus";
    }
}
