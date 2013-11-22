package com.gooagoo.gus.account.action;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.cache.ExceptionCache;
import com.gooagoo.casclient.constants.Constants;
import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.cipher.DesUtils;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.gus.utils.GusClientUtils;
import com.gooagoo.common.gus.utils.VerifyCodeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;

@Controller
@RequestMapping("/mobile")
public class MobileAction extends BaseAction
{
    /**
     * 进入手机绑定页面
     * 
     */
    @RequestMapping(params = "method=bindingMobile")
    public String bindingMobile(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //需要参数有：邮箱(放到页面显示)     
        PersonalLoginInfo obj = (PersonalLoginInfo) request.getAttribute(Constants.CAS_FILTER_USER_OBJ);
        request.setAttribute("email", FormatDataUtils.formatEmail(obj.getPersonalInfo().getEmail()));
        return "/personal/accountSecurity/mobileBound/modile_index";
    }

    /**
     * 验证手机号码的唯一性
     * 
     */
    @RequestMapping(params = "method=checkModile")
    public void checkModile(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.PERSONAL_BOUNDMOBILE_MOBILEEXIST);
    }

    /**
     * 获取短信验证码
     * 
     */
    @RequestMapping(params = "method=getModileMessage")
    public void getModileMessage(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        GusClientUtils.returnJson1(request, response, InterGusConstants.PERSONAL_BOUNDMOBILE_GETMESSAGECODE);
    }

    /**
     * 第一个下一步，验证验证码的正确性并发送邮件
     * 
     */
    @RequestMapping(params = "method=subMessage")
    public String subMessage(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String code = ServletRequestUtils.getStringParameter(request, "verifyCode", UUID.getUUID());
        String resultCode = VerifyCodeUtils.checkVerifyCode(code, request);
        if (resultCode == null)
        {
            TransData<Object> respObj = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_BOUNDMOBILE_SENDEMAIL);
            if (respObj.getHead().isSuccess())
            {
                return "/personal/accountSecurity/mobileBound/modile_send";
            }
            else
            {
                request.setAttribute("message", ExceptionCache.get(respObj.getHead().getResultCode()));
                return "/personal/accountSecurity/mobileBound/modile_send_error";
            }
        }
        else
        {
            request.setAttribute("message", ExceptionCache.get(resultCode));//提示信息
            return "/personal/accountSecurity/mobileBound/modile_Message_code_error";
        }
    }

    /**
     * 第二个下一步，验证短信验证码
     * 
     */
    @RequestMapping(params = "method=subMessagecode")
    public String subMessagecode(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        TransData<Object> respObj = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_BOUNDMOBILE_BOUNDMOBILE);
        //需要参数有：验证码正确就跳到下面的页面，错误则跳出错误信息  
        if (respObj.getHead().isSuccess())
        {
            return "/personal/accountSecurity/mobileBound/modile_success";
        }
        else
        {
            request.setAttribute("message", ExceptionCache.get(respObj.getHead().getResultCode()));//提示信息
            return "/personal/accountSecurity/mobileBound/modile_Message_error";
        }
    }

    /**
     * 点击链接激活(通过邮箱验证身份，跳页面)
     * @throws Exception 
     * 
     */
    @RequestMapping(params = "method=activeMobile")
    public String activeMobile(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        PersonalLoginInfo obj = (PersonalLoginInfo) request.getAttribute(Constants.CAS_FILTER_USER_OBJ);
        String headPic = UrlUtils.getAttachUrlByImg("b", obj.getPersonalProfile().getHeadPic());
        request.setAttribute("headPic", headPic + "?r=" + new Random().nextInt(1000));
        //需要参数有：邮箱地址  
        TransData<Object> respObj = GusClientUtils.transfer(request, InterGusConstants.PERSONAL_BOUNDMOBILE_EMAILAUTHENTICATION);
        if (respObj.getHead().isSuccess())
        {
            String activeCode = ServletRequestUtils.getStringParameter(request, "code");
            String mobile = ServletRequestUtils.getStringParameter(request, "m");
            DesUtils desUtil = new DesUtils("fetchurl");
            mobile = desUtil.decrypt(mobile);
            request.setAttribute("activeCode", activeCode);
            request.setAttribute("mobile", mobile);
            return "/personal/accountSecurity/mobileBound/modile_Message_index"; //激活成功页面
        }
        return "/personal/accountSecurity/mobileBound/modile_false";//激活失败页面
    }
}
