package com.gooagoo.gus.account.action;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.common.gus.utils.PasswordCardUtils;
import com.google.gson.Gson;

@Controller
@RequestMapping("/securityCard")
public class SecuritycardAction extends BaseAction
{
    /**
     *显示密保卡
     */
    @RequestMapping(params = "method=index")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException
    {
        String serialNum = PasswordCardUtils.getSerialNumber();
        request.setAttribute("serialNum", serialNum);
        String[][] coordinateData = PasswordCardUtils.getCoordinateData();
        request.setAttribute("coordDate", new Gson().toJson(coordinateData));
        request.setAttribute("isBind", "N");
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_SECURITYCARD_SETUSERSECURITYCARD);
        if (transData.getHead().isSuccess())
        {
            response.setHeader("Content-disposition", "attachment;filename=" + serialNum + ".jpg");
            response.setContentType("application/x-msdownload; charset=utf-8");
            OutputStream output = response.getOutputStream();
            PasswordCardUtils.create("序列号: " + serialNum, coordinateData, output);
            output.flush();
            output.close();
        }
    }

    /**
     *显示密保卡
     */
    @RequestMapping(params = "method=show")
    public String show(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException
    {
        return "/personal/accountSecurity/securitycard/index";
    }

    /**
     * 绑定密保卡
     * @throws ServletRequestBindingException 
     */
    @RequestMapping(params = "method=setSecurityCard")
    public String setSecurityCard(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException
    {
        String serialNum = ServletRequestUtils.getStringParameter(request, "serialNum");
        request.setAttribute("isBind", "Y");
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_SECURITYCARD_SETUSERSECURITYCARD);
        if (transData.getHead().isSuccess())
        {
            request.setAttribute("serialNum", FormatDataUtils.formatMobile(serialNum));
            return "/personal/accountSecurity/securitycard/setSecurityCard";
        }
        else
        {
            request.setAttribute("message", ExceptionCache.get(transData.getHead().getResultCode()));
            return "/personal/accountSecurity/securitycard/setSecurityCard_error";
        }
    }

    /**
     * 解除密保卡
     */
    @RequestMapping(params = "method=delSecurityCard")
    public String delSecurityCard(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_SECURITYCARD_DELETEUSERSECURITYCARD);
        if (transData.getHead().isSuccess())
        {
            return "/personal/accountSecurity/securitycard/delSecurityCard";
        }
        else
        {
            request.setAttribute("message", ExceptionCache.get(transData.getHead().getResultCode()));
            return "/personal/accountSecurity/securitycard/delSecurityCard_error";
        }
    }
}
