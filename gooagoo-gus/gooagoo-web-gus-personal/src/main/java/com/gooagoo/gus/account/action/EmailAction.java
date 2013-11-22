package com.gooagoo.gus.account.action;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.casclient.constants.Constants;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.common.gus.utils.SecurityLevelUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;

@Controller
@RequestMapping("/email")
public class EmailAction extends BaseAction
{
    /**
     * 进入账号安全首页
     * 
     */
    @RequestMapping(params = "method=index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String serialNum1 = null;
        String account = null;
        String info = null;
        String email = null;
        String mobile = null;
        String question = null;
        //查询手机号码是否存在，存在就显示立即绑定，不存在则不允许绑定
        PersonalLoginInfo obj = (PersonalLoginInfo) request.getAttribute(Constants.CAS_FILTER_USER_OBJ);
        if (StringUtils.isNotBlank(obj.getPersonalInfo().getAccount()))
        {
            account = "10";
        }
        if (StringUtils.isNotBlank(obj.getPersonalInfo().getEmail()))
        {
            email = "20";
            request.setAttribute("email", FormatDataUtils.formatEmail(obj.getPersonalInfo().getEmail()));
        }
        if (StringUtils.isNotBlank(obj.getPersonalInfo().getMobile()))
        {
            mobile = "30";
            request.setAttribute("mobile", FormatDataUtils.formatMobile(obj.getPersonalInfo().getMobile()));
        }
        TransData<Object> objs = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_SECURITYQUESTION_GETUSERSECURITYQUESTION);
        if (objs.getData() != null)
        {
            request.setAttribute("data", objs.getData());
            question = "50";
        }
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_SECURITYCARD_GETUSERSECURITYCARD);
        if (transData.getData() != null)
        {
            serialNum1 = "80";
            String serialNum = (String) transData.getData();
            request.setAttribute("serialNum", FormatDataUtils.formatMobile(serialNum));
        }
        boolean flag = SecurityLevelUtils.isCompletePersonalProfile(obj.getPersonalProfile());
        if (!flag)
        {
            request.setAttribute("isfalse", flag);
        }
        else
        {
            info = "10";
            request.setAttribute("istrue", flag);
        }
        Integer num = SecurityLevelUtils.accountSecurityLevels(account, serialNum1, info, email, mobile, question);
        request.setAttribute("num", num);
        return "/personal/accountSecurity/index";
    }

    /**
     * 进入邮箱绑定页面
     * 
     */
    @RequestMapping(params = "method=bindingEmail")
    public String bindingEmail(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //需要参数有：手机号码(放到页面显示)  
        PersonalLoginInfo obj = (PersonalLoginInfo) request.getAttribute(Constants.CAS_FILTER_USER_OBJ);
        request.setAttribute("mobile", FormatDataUtils.formatMobile(obj.getPersonalInfo().getMobile()));
        return "/personal/accountSecurity/emailBound/email_index";
    }

    /**
     * 邮箱是否存在
     * 
     */
    @RequestMapping(params = "method=checkEmail")
    public void checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.PERSONAL_BOUNDEMAIL_EMAILEXIST);
    }

    /**
     * 获取短信验证码
     * @throws Exception 
     * 
     */
    @RequestMapping(params = "method=getMessageCode")
    public void getMessageCode(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.PERSONAL_BOUNDEMAIL_GETMESSAGECODE);
    }

    /**
     * 下一步，添加邮箱地址并发送邮件
     * @throws IOException 
     * 
     */
    @RequestMapping(params = "method=subMessage")
    public String subMessage(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> respObj = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_BOUNDEMAIL_SENDEMAIL);
        if (respObj.getHead().isSuccess())
        {
            return "/personal/accountSecurity/emailBound/email_send";
        }
        else
        {
            request.setAttribute("message", ExceptionCache.get(respObj.getHead().getResultCode()));//提示信息
            return "/personal/accountSecurity/emailBound/email_send_error";
        }
    }

    /**
     * 点击链接激活
     * 
     */
    @RequestMapping(params = "method=activeEmail")
    public String activeEmail(HttpServletRequest request, HttpServletResponse response)
    {
        PersonalLoginInfo obj = (PersonalLoginInfo) request.getAttribute(Constants.CAS_FILTER_USER_OBJ);
        String headPic = UrlUtils.getAttachUrlByImg("b", obj.getPersonalProfile().getHeadPic());
        request.setAttribute("headPic", headPic + "?r=" + new Random().nextInt(1000));
        //需要参数有：邮箱地址  
        TransData<Object> respObj = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_BOUNDEMAIL_BOUNDEMAIL);
        if (respObj.getHead().isSuccess())
        {
            return "/personal/accountSecurity/emailBound/email_success"; //激活成功页面
        }
        return "/personal/accountSecurity/emailBound/email_false";//激活失败页面
    }
}
