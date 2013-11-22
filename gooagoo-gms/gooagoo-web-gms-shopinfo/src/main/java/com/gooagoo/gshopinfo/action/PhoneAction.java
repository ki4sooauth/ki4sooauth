package com.gooagoo.gshopinfo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gms.constants.InterGmsConstants;
import com.gooagoo.common.gms.utils.GMSUtil;


@Controller
@RequestMapping("/phone")
public class PhoneAction extends BaseAction
{

    @RequestMapping(params = "method=bindPhone")
    public void editPhone(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GMSUtil.ajaxSubmit(InterGmsConstants.I_GMS_SHOP_INFO_BIND_PHONE, request, response);
    }

    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return "shopAccountInfo/phone";
    }

}
