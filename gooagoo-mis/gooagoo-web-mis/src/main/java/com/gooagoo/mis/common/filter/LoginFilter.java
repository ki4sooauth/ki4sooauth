package com.gooagoo.mis.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.gooagoo.cache.MisConfigCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.entity.casclient.mis.MisZTreeNode;

/**
 * 后台登录过滤器
 *
 * 
 *
 */
public class LoginFilter implements Filter
{
    private String[] ignores;
    private String[] onlyLogins;

    private String encoding, passport;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.ignores = filterConfig.getInitParameter("ignores").split(",");
        this.onlyLogins = filterConfig.getInitParameter("onlyLogins").split(",");
        this.encoding = filterConfig.getInitParameter("encoding");
        this.passport = filterConfig.getInitParameter("sso.passportUrl");
        GooagooLog.debug("单点登录配置encoding:" + this.encoding + ",passport:" + this.passport);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        String reqAction = StringUtils.substringAfterLast(req.getRequestURL().toString(), "/");
        String reqParam = StringUtils.isEmpty(req.getQueryString()) ? "" : req.getQueryString();
        String reqFunc = reqAction + "?" + reqParam;

        HttpServletResponse res = (HttpServletResponse) response;
        res.setContentType("text/html; charset=utf-8");

        if (this.ignore(reqFunc))
        {
            chain.doFilter(req, res);
        }
        else
        {
            //判断登陆
            MisLoginInfo obj = (MisLoginInfo) request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
            if (obj != null && StringUtils.isNotEmpty(obj.getLoginId()))
            {
                if (this.judgePermission(req, reqParam, reqFunc, obj))
                {
                    chain.doFilter(request, response);
                }
                else
                {
                    res.getWriter().println("<html><script>alert('无此权限')</script></html>");
                }
            }
            else
            {
                res.getWriter().println("<html><script>window.open ('" + MisConfigCache.get("passport_url") + "/mislogin','_top')</script></html>");
            }
        }
    }

    /**
     * 忽略权限验证
     * @param reqFunc
     * @return
     */
    private boolean ignore(String reqFunc)
    {
        for (String ignore : this.ignores)
        {
            reqFunc = reqFunc.indexOf("&") == -1 ? reqFunc : StringUtils.substringBefore(reqFunc, "&");
            if (reqFunc.equals(ignore.trim()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否有权限
     * @param req
     * @param reqFunc
     * @return
     */
    private boolean judgePermission(HttpServletRequest req, String reqParam, String reqFunc, MisLoginInfo obj)
    {
        //判断是否超级管理员
        if ("Y".equals(obj.getIsAdmin()))
        {
            return true;
        }

        reqFunc = reqFunc.indexOf("&") == -1 ? reqFunc : StringUtils.substringBefore(reqFunc, "&");
        //判断是否登录即可
        for (String onlyLogin : this.onlyLogins)
        {
            if (reqParam.startsWith(onlyLogin.trim()))
            {
                return true;
            }
        }

        //判断其他权限
        List<MisZTreeNode> auths = obj.getAuthorities();
        auths = auths == null ? new ArrayList<MisZTreeNode>() : auths;
        for (MisZTreeNode auth : auths)
        {
            String url = auth.getUrl();
            String note = StringUtils.isEmpty(auth.getNote()) ? "" : auth.getNote();
            if (reqFunc.equals(url) || note.equals(reqFunc) || note.indexOf(reqFunc + ";") != -1)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy()
    {
    }
}
