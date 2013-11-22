package com.gooagoo.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.cms.utils.AuthUtil;

public class CMSAuthorityFilter implements Filter
{
    /**
     * 商家权限过滤
     */
    @Override
    public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain fc) throws ServletException, IOException
    {

        HttpServletRequest request = (HttpServletRequest) servletrequest;
        HttpServletResponse response = (HttpServletResponse) servletresponse;

        String baseUrl = GmsConfigCache.get("html_url_head");
        request.setAttribute("imgPath", baseUrl);

        if (AuthUtil.checkAuthUrl(request))
        {
            fc.doFilter(request, response);
        }
        else
        {
            response.getWriter().println("");
        }
    }

    @Override
    public void destroy()
    {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

}
