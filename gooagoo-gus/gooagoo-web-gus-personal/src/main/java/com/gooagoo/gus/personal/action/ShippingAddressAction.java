package com.gooagoo.gus.personal.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.view.gus.common.PageModel;
import com.gooagoo.view.gus.web.common.UProvince;
import com.gooagoo.view.gus.web.personal.UConsigeeInfo;

@Controller
@RequestMapping("/shippingAddressAction")
public class ShippingAddressAction extends BaseAction
{
    /**
     * 收货地址首页
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> province = GusClientUtils.transfer(request, InterGusConstants.COMMON_PROVINCECOMMON_GETPROVINCELIST);
        List<UProvince> provincelist = (List<UProvince>) province.getData();
        if (provincelist != null)
        {
            request.setAttribute("provincelist", provincelist);
        }
        return "/personal/shippingAddress/shippingAddress";
    }

    /**
     * 查询原来的收货地址信息
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(params = "method=show")
    public String show(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> pageModel = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_SHIPPINGADDRESS_GETSHIPPINGADDRESSLIST);
        if (pageModel.getHead().isSuccess())
        {
            PageModel<UConsigeeInfo> pm = (PageModel<UConsigeeInfo>) pageModel.getData();
            if (pm != null)
            {
                request.setAttribute("count", pm.getResult().size());
                request.setAttribute("data", pm.getResult());
            }
            request.setAttribute("pageModel", pm);
        }
        request.setAttribute("message", ExceptionCache.get(pageModel.getHead().getResultCode()));

        TransData<Object> province = GusClientUtils.transfer(request, InterGusConstants.COMMON_PROVINCECOMMON_GETPROVINCELIST);
        request.setAttribute("provincelist", province.getData());
        return "/personal/shippingAddress/managerShippingAddress";
    }

    /**
     * 新增收货地址
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=addShippingAddress")
    public void addShippingAddress(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.PERSONAL_SHIPPINGADDRESS_ADDSHIPPINGADDRE);// 新增收货地址
    }

    /**
     * 收货地址设为默认
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=setDefault")
    public void setDefault(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.PERSONAL_SHIPPINGADDRESS_SETDEFAULTSHIPPINGADDRE);
    }

    /**
     * 进入修改地址
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=toUpdateShippingAddress")
    public void toUpdateShippingAddress(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/text;charset=UTF-8");
        request.setAttribute("shippingAddressId", request.getParameter("shippingAddressId"));
        request.setAttribute("addressName", request.getParameter("addressName"));
        request.setAttribute("streetAddress", request.getParameter("streetAddress"));
    }

    /**
     * 修改收货地址
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=updateShippingAddress")
    public void updateShippingAddress(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.PERSONAL_SHIPPINGADDRESS_UPDATESHIPPINGADDRE);

    }

    /**
     * 删除收货地址
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping(params = "method=deleteShippingAddress")
    public void deleteShippingAddress(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.PERSONAL_SHIPPINGADDRESS_DELETESHIPPINGADDRE);
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
    public String city(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_CITYCOMMON_GETCITYLIST);
        return "/personal/shippingAddress/citylist";

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
    public String area(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.COMMON_AREACOMMON_GETAREALIST);
        return "/personal/shippingAddress/arealist";
    }

}
