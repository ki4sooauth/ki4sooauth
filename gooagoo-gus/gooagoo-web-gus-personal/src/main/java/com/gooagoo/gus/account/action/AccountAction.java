package com.gooagoo.gus.account.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

@Controller
@RequestMapping("/account")
public class AccountAction extends BaseAction
{
    /**
     * 进入设置用户名页面
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "/personal/accountSecurity/account/index";
    }

    /**
     * 进入设置用户名页面
     */
    @RequestMapping(params = "method=show")
    public String show(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "/personal/accountSecurity/account/show";
    }

    /**
     * 设置用户名
     */
    @RequestMapping(params = "method=setAccount")
    public String setAccount(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_ACCOUNT_SETACCOUNT);
        if (transData.getHead().isSuccess())
        {
            request.setAttribute("account", transData.getData());
            return "/personal/accountSecurity/account/success";
        }
        else
        {
            return "/personal/accountSecurity/account/error";
        }
    }
}
