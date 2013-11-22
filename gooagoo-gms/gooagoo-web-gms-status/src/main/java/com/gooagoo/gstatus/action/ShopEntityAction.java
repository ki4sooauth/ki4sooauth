package com.gooagoo.gstatus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 店内状态
 *
 */
@Controller
@RequestMapping("/entity")
public class ShopEntityAction
{
    /**
     * 主页
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "method=index")
    public String stateIndex(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        return "status/index";
    }
}
