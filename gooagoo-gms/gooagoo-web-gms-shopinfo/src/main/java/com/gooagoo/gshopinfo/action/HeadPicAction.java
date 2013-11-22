package com.gooagoo.gshopinfo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.view.gms.shopinfo.FHeadPic;


@Controller
@RequestMapping("/headAction")
public class HeadPicAction extends BaseAction
{

    @RequestMapping(params = "method=getHeadPic")
    public String getHeadPic(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        TransData<FHeadPic> respObj = GMSUtil.httpClientRequest(InterGmsConstants.I_GMS_SHOP_INFO_GET_HEAD_PIC, request, FHeadPic.class);
        FHeadPic headPic = respObj.getData();
        request.setAttribute("headPic", headPic);
        return "shopAccountInfo/icon";
    }

    @RequestMapping(params = "method=updateSPic")
    public void updateShopLogo(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_SHOP_PIC, request, response);
    }

    @RequestMapping(params = "method=updateUPic")
    public void updateUserPic(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_UPDATE_USER_PIC, request, response);
    }
}
