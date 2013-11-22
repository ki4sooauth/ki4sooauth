package com.gooagoo.web.merchant.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.gooagoo.casclient.utils.HttpFilterUtils;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.utils.DomainUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;

public class MerchantFilter implements Filter
{

    private String encoding;

    @Override
    public void init(FilterConfig config) throws ServletException
    {
        this.encoding = config.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain fc) throws ServletException, IOException
    {
        HttpServletRequest request = (HttpServletRequest) servletrequest;
        HttpServletResponse response = (HttpServletResponse) servletresponse;
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Expires", "0");// 禁止缓存
        this.setPath(request);
        // 有时候会出编码问题，即使spring设置了也不行，在这里也设置一下
        if (StringUtils.isNotBlank(this.encoding))
        {
            request.setCharacterEncoding(this.encoding);
        }
        try
        {
            Cookie[] cookies = request.getCookies();
            if (cookies == null || cookies.length == 0)
            {
                GooagooLog.debug("验证用户是否登录：没有cookie");
            }
            else
            {
                String token = null;
                for (Cookie cookie : cookies)
                {
                    String cookieName = cookie.getName();
                    if (com.gooagoo.casclient.constants.Constants.CAS_TOKENNAME_PERSONAL.equals(cookieName))
                    {
                        token = cookie.getValue();
                        break;
                    }
                }
                GooagooLog.debug("验证用户是否登录：token（" + com.gooagoo.casclient.constants.Constants.CAS_TOKENNAME_PERSONAL + "）对应token值=" + token);
                if (StringUtils.isNotBlank(token))
                {
                    Object o = HttpFilterUtils.transferObj("http://ipassport.goo.com/iLoginInfo/getPersonalLoginInfo", token);
                    if (o == null)
                    {
                        GooagooLog.debug("验证用户是否登录：根据token值（" + token + "）未获取到登录信息");
                    }
                    else
                    {
                        PersonalLoginInfo personalLoginInfo = (PersonalLoginInfo) o;
                        request.setAttribute(Constants.USER_LOGIN_KEY, personalLoginInfo);
                        request.setAttribute(Constants.USER_LOGIN_TOKEN, personalLoginInfo.getToken());
                        request.setAttribute(Constants.USER_LOGIN_USERID, personalLoginInfo.getPersonalInfo().getUserId());
                    }
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("获取用户登录信息异常", e);
        }
        fc.doFilter(request, response);
    }

    @Override
    public void destroy()
    {

    }

    private void setPath(HttpServletRequest request)
    {
        request.setAttribute("basePath", request.getContextPath());
        request.setAttribute("imgPath", DomainUtils.getHtmlDomain());
    }
}