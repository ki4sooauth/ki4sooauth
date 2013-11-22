package com.gooagoo.gus.mall.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

@Controller
@RequestMapping("/exchangeRecord")
public class ExchangeRecordAction extends BaseAction
{

    /**
     * 积分商城兑换记录首页
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response)
    {
        return "/mall/exchangerecord/index";
    }

    /**
     * 获取商家类型列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=shopTypeListRequest")
    public String shopTypeListRequest(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPTYPECOMMON_GETSHOPTYPELIST);

        return "/mall/exchangerecord/shoptypelist";
    }

    /**
     * 获取商家列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(params = "method=shopByShopTypeIdRequest")
    public String shopByShopTypeIdRequest(HttpServletRequest request, HttpServletResponse response)
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_SHOPCOMMON_GETSHOPLIST);

        return "/mall/exchangerecord/shoplist";
    }

    /**
     * 商品和优惠凭证，兑换记录查询
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception 
     * @throws IOException
     */
    @RequestMapping(params = "method=exchangeRecordRequest")
    public String exchangeRecordRequest(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("type", ServletRequestUtils.getStringParameter(request, "type", "G"));
        GusClientUtils.returnData(request, response, InterGusConstants.MALL_EXCHANGERECORD_GETCONVERTRECORDLIST);

        return "/mall/exchangerecord/exchangerecord";
    }

}
