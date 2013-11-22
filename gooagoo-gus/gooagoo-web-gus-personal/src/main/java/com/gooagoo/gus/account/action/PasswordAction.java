package com.gooagoo.gus.account.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.GusClientUtils;

@Controller
@RequestMapping("/password")
public class PasswordAction extends BaseAction
{

    /**
     * 进入修改密码页面
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(params = "method=password")
    public String password(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "/personal/accountSecurity/changePassword/changePassword";
    }

    /**
     * 修改密码
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(params = "method=changePassword")
    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.PERSONAL_PASSWORD_UPDATEPASSWORD);
    }
}
