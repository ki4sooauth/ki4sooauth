package com.gooagoo.trans.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodFilter implements Filter
{
    private String encoding;

    @Override
    public void init(FilterConfig config) throws ServletException
    {
        this.encoding = config.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletrequest;
        HttpServletResponse response = (HttpServletResponse) servletresponse;
        if (this.encoding != null && !"".equals(this.encoding))
        {
            request.setCharacterEncoding(this.encoding);
            response.setCharacterEncoding(this.encoding);
        }
        filterchain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {
    }

}
