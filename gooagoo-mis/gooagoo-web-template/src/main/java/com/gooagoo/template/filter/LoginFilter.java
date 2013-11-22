package com.gooagoo.template.filter;

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

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.entity.casclient.mis.MisZTreeNode;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.casclient.shop.ShopAuth;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;

/**
 * 后台登录过滤器
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
            Object loginInfo = request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
            String loginType = "";
            String loginName = "";
            List<ShopAuth> shop_login_auths = new ArrayList<ShopAuth>();
            List<MisZTreeNode> mis_login_auths = new ArrayList<MisZTreeNode>();

            if (loginInfo instanceof ShopLoginInfo)
            {
                loginType = "S";
                loginName = ((ShopLoginInfo) loginInfo).getShopAndUserInfo().getShopId();
                shop_login_auths = ((ShopLoginInfo) loginInfo).getShopAuthList();
            }
            else if (loginInfo instanceof PersonalLoginInfo)
            {
                loginType = "P";
                loginName = ((PersonalLoginInfo) loginInfo).getPersonalInfo().getUserId();
            }
            else if (loginInfo instanceof MisLoginInfo)
            {
                loginType = "M";
                loginName = ((MisLoginInfo) loginInfo).getLoginId();
                mis_login_auths = ((MisLoginInfo) loginInfo).getAuthorities();
            }
            request.setAttribute("loginType", loginType);
            request.setAttribute("loginName", loginName);
            request.setAttribute("shop_login_auths", shop_login_auths);
            request.setAttribute("mis_login_auths", mis_login_auths);

            if (loginInfo != null && StringUtils.isNotEmpty(loginName))
            {
                if (this.judgePermission(req, reqParam, reqFunc, loginInfo))
                {
                    chain.doFilter(request, response);
                }
                else
                {
                    res.getWriter().println("<html><script>alert('无此权限！')</script></html>");
                }
            }
            else
            {
                res.getWriter().println("<html><script>alert('请重新登陆，谢谢。')</script></html>");
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
    private boolean judgePermission(HttpServletRequest req, String reqParam, String reqFunc, Object obj)
    {
        //如果是个人用户，则默认获取所有权限
        if (obj instanceof PersonalLoginInfo)
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
        //默认给访问index的权限
        if ("index?".equals(reqFunc))
        {
            return true;
        }
        //判断权限
        if (obj instanceof ShopLoginInfo)
        {
            List<ShopAuth> auths = ((ShopLoginInfo) obj).getShopAuthList();
            auths = auths == null ? new ArrayList<ShopAuth>() : auths;
            for (ShopAuth auth : auths)
            {
                String url = auth.getLink();
                String note = StringUtils.isEmpty(auth.getNote()) ? "" : auth.getNote();
                if (reqFunc.equals(url) || note.equals(reqFunc) || note.indexOf(reqFunc + ";") != -1)
                {
                    return true;
                }
            }
        }
        else if (obj instanceof MisLoginInfo)
        {
            //判断是否超级管理员
            if ("Y".equals(((MisLoginInfo) obj).getIsAdmin()))
            {
                return true;
            }
            else
            {
                List<MisZTreeNode> auths = ((MisLoginInfo) obj).getAuthorities();
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
            }
        }
        return false;
    }

    @Override
    public void destroy()
    {
    }
}
