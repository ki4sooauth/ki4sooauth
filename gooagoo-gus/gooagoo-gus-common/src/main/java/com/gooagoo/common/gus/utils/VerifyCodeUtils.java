package com.gooagoo.common.gus.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.utils.UUID;

/**
 * 随机验证码工具类
 * @author GUS
 *
 */
public class VerifyCodeUtils
{

    /**
     * 设置随机验证码
     * <br>
     * 将随机验证码放入缓存中，并将token值放入本地cookie
     * @param verifyCode
     * @param request
     * @param response
     * @return
     */
    public static String setVerifyCode(String verifyCode, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("verifyCode", verifyCode);
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.COMMON_VERIFYCODECOMMON_GETVERIFYCODE);
        if (transData.getHead().isSuccess() && transData.getData() != null)
        {
            String token = (String) transData.getData();
            Cookie jss = new Cookie(Constants.VERIFY_CODE_TOKEN_NAME, token);
            response.addCookie(jss);

            return token;
        }

        return null;
    }

    /**
     * 校验随机验证码
     * <br>
     * 校验用户输入的随机验证码是否正确
     * @param verifyCode
     * @param request
     * @return
     */
    public static String checkVerifyCode(String verifyCode, HttpServletRequest request)
    {
        String token = UUID.getUUID();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies)
        {
            String cookieName = cookie.getName();
            if (Constants.VERIFY_CODE_TOKEN_NAME.equals(cookieName))
            {
                token = cookie.getValue();
            }
        }
        request.setAttribute("token", token);
        request.setAttribute("verifyCode", verifyCode);
        TransData<Object> transData = GusClientUtils.transfer(request, InterGusConstants.COMMON_VERIFYCODECOMMON_CHECKVERIFYCODE);
        if (transData.getHead().isSuccess() && (Boolean) transData.getData())
        {
            return null;
        }

        return transData.getHead().getResultCode();
    }

}
