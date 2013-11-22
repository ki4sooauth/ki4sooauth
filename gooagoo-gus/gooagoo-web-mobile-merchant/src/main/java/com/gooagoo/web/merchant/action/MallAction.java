package com.gooagoo.web.merchant.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.common.gus.utils.UrlDecode;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gus.common.UrlInfo;
import com.google.gson.Gson;

/**
 * 手机端积分商城
 * @author GOOAGOO
 *
 */
@Controller
@RequestMapping("/integralMall")
public class MallAction extends BaseAction
{

    @RequestMapping(params = "method=mobile")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UrlInfo info = UrlDecode.decodeInfo(ServletRequestUtils.getRequiredStringParameter(request, "para"));
        request.setAttribute("shopId", info.getTypeId());

        return "/merchant/mall/index";
    }

    @RequestMapping(params = "method=convertPageRequest")
    public String convertPageRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<Object> province = GusClientUtils.transfer(request, InterGusConstants.COMMON_PROVINCECOMMON_GETPROVINCELIST);
        TransData<Object> consigneeInfo = GusClientUtils.transfer(request, InterGusConstants.MERCHANT_MOBILE_GETCONSIGNEEINFO);
        request.setAttribute("consigneelist", consigneeInfo.getData());
        request.setAttribute("provincelist", province.getData());
        request.setAttribute("shopIntegralId", ServletRequestUtils.getRequiredStringParameter(request, "shopIntegralId"));
        request.setAttribute("shopId", ServletRequestUtils.getRequiredStringParameter(request, "shopId"));

        return "/merchant/mall/convertpage";
    }

    @RequestMapping(params = "method=integralConvertRequest")
    public void integralConvertRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.MERCHANT_MOBILE_INTEGRALCONVERT);
    }

    @RequestMapping(params = "method=moreIntegralMallDataRequest")
    public String moreIntegralMallDataRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnData(request, response, InterGusConstants.MERCHANT_MOBILE_GETINTEGRALMALLLIST);

        return "/merchant/mall/single";
    }

    /**
     * 根据省获取市
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=city")
    public void city(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.COMMON_CITYCOMMON_GETCITYLIST);
        if (transData.getData() != null)
        {
            ServletUtils.writeHtml(new Gson().toJson(transData.getData()), response);
        }

    }

    /**
     * 根据市获取区县
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=area")
    public void area(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.COMMON_AREACOMMON_GETAREALIST);
        if (transData.getData() != null)
        {
            ServletUtils.writeHtml(new Gson().toJson(transData.getData()), response);
        }
    }

}
