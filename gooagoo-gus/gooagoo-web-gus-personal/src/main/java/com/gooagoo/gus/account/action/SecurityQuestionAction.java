package com.gooagoo.gus.account.action;

import java.io.IOException;

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
import com.gooagoo.common.gus.utils.GusClientUtils;

@Controller
@RequestMapping("/securityQuestion")
public class SecurityQuestionAction extends BaseAction
{
    /**
     * 进入设置用户名页面
     * @throws ServletRequestBindingException 
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException
    {
        String type = ServletRequestUtils.getStringParameter(request, "num");
        request.setAttribute("type", type);
        request.setAttribute("id", ServletRequestUtils.getStringParameter(request, "id"));
        request.setAttribute("sysId", ServletRequestUtils.getStringParameter(request, "sysId"));
        request.setAttribute("content", ServletRequestUtils.getStringParameter(request, "content"));
        request.setAttribute("answer", ServletRequestUtils.getStringParameter(request, "answer"));
        return "/personal/accountSecurity/securityquestion/checkPassword";
    }

    /**
     * 设置密保
     */
    @RequestMapping(params = "method=setSecurityQuestion")
    public String setSecurityQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_SECURITYQUESTION_SETUSERSECURITYQUESTION);
        if (transData.getHead().isSuccess())
        {
            return "/personal/accountSecurity/securityquestion/success";
        }
        else
        {
            request.setAttribute("message", ExceptionCache.get(transData.getHead().getResultCode()));
            return "/personal/accountSecurity/securityquestion/setQuestionError";
        }
    }

    /**
     * 修改密保（接受页面传来的值跳到修改页面）
     * @throws ServletRequestBindingException 
     */
    @RequestMapping(params = "method=updSecurityQuestion")
    public String updSecurityQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException
    {
        GusClientUtils.returnData(request, response, InterGusConstants.PERSONAL_SECURITYQUESTION_GETSYSSECURITYQUESTION);
        request.setAttribute("id", ServletRequestUtils.getStringParameter(request, "id"));
        request.setAttribute("sysId", ServletRequestUtils.getStringParameter(request, "sysId"));
        request.setAttribute("content", ServletRequestUtils.getStringParameter(request, "content"));
        request.setAttribute("answer", ServletRequestUtils.getStringParameter(request, "answer"));
        return "/personal/accountSecurity/securityquestion/update";
    }

    /**
     * 验证用户名密码
     * @throws ServletRequestBindingException 
     */
    @RequestMapping(params = "method=checkPassword")
    public String checkPassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException
    {
        String type = ServletRequestUtils.getStringParameter(request, "type");
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_SECURITYQUESTION_CHECKUSERPASSWORD);
        if (transData.getHead().isSuccess())
        {
            GusClientUtils.returnData(request, response, InterGusConstants.PERSONAL_SECURITYQUESTION_GETSYSSECURITYQUESTION);
            if ("1".equals(type))
            {
                return "/personal/accountSecurity/securityquestion/index";
            }
            else if ("2".equals(type))
            {
                request.setAttribute("id", ServletRequestUtils.getStringParameter(request, "id"));
                return "/personal/accountSecurity/securityquestion/update";
            }
            else if ("3".equals(type))
            {
                TransData<Object> obj = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_SECURITYQUESTION_DELETEUSERSECURITYQUESTION);
                if (obj.getHead().isSuccess())
                {
                    request.setAttribute("istrue", "true");
                    request.setAttribute("messa", "aa");
                    request.setAttribute("message", ExceptionCache.get(obj.getHead().getResultCode()));
                    return "/personal/accountSecurity/securityquestion/del";
                }
                else
                {
                    request.setAttribute("istrue", "false");
                    request.setAttribute("messa", "bb");
                    request.setAttribute("message", ExceptionCache.get(obj.getHead().getResultCode()));
                    return "/personal/accountSecurity/securityquestion/del";
                }
            }
        }
        else
        {
            return "/personal/accountSecurity/securityquestion/error";
        }
        return null;
    }
}
