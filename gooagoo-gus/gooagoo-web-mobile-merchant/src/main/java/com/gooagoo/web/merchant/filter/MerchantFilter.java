package com.gooagoo.web.merchant.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.utils.DomainUtils;

public class MerchantFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        this.setBaseInfo((HttpServletRequest) request);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {

    }

    private void setBaseInfo(HttpServletRequest request)
    {
        request.setAttribute("basePath", request.getContextPath());
        request.setAttribute("imgPath", DomainUtils.getHtmlDomain());
        request.setAttribute(Constants.USER_LOGIN_USERID, ServletRequestUtils.getStringParameter(request, "userId", null));
    }

}
