package com.gooagoo.common.gus.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.utils.DomainUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;

/**
 * GUS过滤器
 * @author GUS
 *
 */
public class GusFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        PersonalLoginInfo o = (PersonalLoginInfo) request.getAttribute(Constants.CAS_FILTER_USER_OBJ);
        request.setAttribute(Constants.USER_LOGIN_KEY, request.getAttribute(Constants.CAS_FILTER_USER_OBJ));
        request.setAttribute(Constants.USER_LOGIN_TOKEN, request.getAttribute(Constants.CAS_FILTER_USER_TOKEN));
        request.setAttribute(Constants.USER_LOGIN_USERID, request.getAttribute(Constants.CAS_FILTER_USER_OBJID));
        request.setAttribute(Constants.USER_LOGIN_HEADPIC, UrlUtils.getAttachUrlByImg("b", o.getPersonalProfile().getHeadPic()) + "?r=" + new Random().nextInt(1000));
        request.setAttribute(Constants.GUS_DOMAIN_USERCENTER, DomainUtils.getUserCenterDomain());
        request.setAttribute(Constants.GUS_DOMAIN_PASSPORT, DomainUtils.getPassportDomain());
        request.setAttribute(Constants.GUS_DOMAIN_USERTEMP, DomainUtils.getUserTempDomain());
        request.setAttribute(Constants.GUS_DOMAIN_USERHTML, DomainUtils.getHtmlDomain());
        request.setAttribute(Constants.GUS_BASEPATH, ((HttpServletRequest) request).getContextPath());
        request.setAttribute(Constants.GUS_IMGPATH, DomainUtils.getHtmlDomain());
        request.setAttribute(Constants.GUS_CURRENTTIME, convertDateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
        chain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {

    }

    /**
     * 日期格式装换
     * @param date
     * @param format
     * @return
     */
    private static String convertDateToString(Date date, String format)
    {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

}
