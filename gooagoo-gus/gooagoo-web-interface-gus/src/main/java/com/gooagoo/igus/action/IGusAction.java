package com.gooagoo.igus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.utils.HttpServerUtils;

@Controller
@RequestMapping("/igus")
public class IGusAction extends BaseAction
{

    @RequestMapping(params = "method=request")
    public void request(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        HttpServerUtils.doService(request, response);
    }

}
