package com.gooagoo.common.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

public class EncodingDispatcherServlet extends DispatcherServlet
{
    private static final long serialVersionUID = 1L;
    private String encoding;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        this.encoding = config.getInitParameter("encoding");
        super.init(config);
    }

    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        request.setCharacterEncoding(this.encoding);
        response.setCharacterEncoding(this.encoding);
        super.doService(request, response);
    }
}
