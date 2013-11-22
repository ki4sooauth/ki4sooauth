package com.gooagoo.casclient.filter;

import java.io.IOException;
import java.net.URLEncoder;

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

import com.gooagoo.casclient.constants.Constants;
import com.gooagoo.casclient.log.CasLog;
import com.gooagoo.casclient.utils.CasclientUtils;
import com.gooagoo.casclient.utils.HttpFilterUtils;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;

/**
 * 单点登录过滤器
 * @author GOOAGOO
 *
 */
public class UserSSOFilter implements Filter
{

    private String encoding;

    private String passportType;

    private String passportUrl;

    private String passportTokenName;

    private String loginInfoUrl;

    @Override
    public void init(FilterConfig config) throws ServletException
    {
        this.encoding = config.getInitParameter("encoding");
        this.passportType = config.getInitParameter("sso.passportType");
        if ("personalUser".equals(this.passportType))
        {
            this.passportTokenName = Constants.CAS_TOKENNAME_PERSONAL;//个人用户TOKEN名
            this.loginInfoUrl = "http://ipassport.goo.com/iLoginInfo/getPersonalLoginInfo";//获取个人用户登录信息URL
            this.passportUrl = CasclientUtils.getPersonalLoginUrl();//个人用户登录URL
        }
        else if ("shopUser".equals(this.passportType))
        {
            this.passportTokenName = Constants.CAS_TOKENNAME_SHOP;//商家用户TOKEN名
            this.loginInfoUrl = "http://ipassport.goo.com/iLoginInfo/getShopLoginInfo";//获取商家用户登录信息URL
            this.passportUrl = CasclientUtils.getShopLoginUrl();//商家用户登录URL
        }
        else if ("misUser".equals(this.passportType))
        {
            this.passportTokenName = Constants.CAS_TOKENNAME_MIS;//MIS用户TOKEN名
            this.loginInfoUrl = "http://ipassport.goo.com/iLoginInfo/getMisLoginInfo";//获取MIS用户登录信息URL
            this.passportUrl = CasclientUtils.getMisLoginUrl();//mis用户登录URL
        }
    }

    @Override
    public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain fc) throws ServletException, IOException
    {
        HttpServletRequest request = (HttpServletRequest) servletrequest;
        HttpServletResponse response = (HttpServletResponse) servletresponse;
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Expires", "0");// 禁止缓存
        // 有时候会出编码问题，即使spring设置了也不行，在这里也设置一下
        if (StringUtils.isNotBlank(this.encoding))
        {
            request.setCharacterEncoding(this.encoding);
        }
        if (!this.checkTicket(request))
        {
            this.sendRedirect(request, response);
        }
        else
        {
            fc.doFilter(request, response);
        }
    }

    /**
     * 验证用户是否登录
     * @param request
     * @return
     */
    private boolean checkTicket(HttpServletRequest request)
    {
        try
        {
            Cookie[] cookies = request.getCookies();
            if (cookies == null || cookies.length == 0)
            {
                CasLog.debug("验证用户是否登录：没有cookie");
                return false;
            }
            String token = null;
            for (Cookie cookie : cookies)
            {
                String cookieName = cookie.getName();
                if (this.passportTokenName.equals(cookieName))
                {
                    token = cookie.getValue();
                    break;
                }
            }
            CasLog.debug("验证用户是否登录：token（" + this.passportTokenName + "）对应token值=" + token);
            if (StringUtils.isBlank(token))
            {
                return false;
            }
            Object obj = HttpFilterUtils.transferObj(this.loginInfoUrl, token);
            if (obj == null)
            {
                CasLog.debug("验证用户是否登录：根据token值（" + token + "）未获取到登录信息");
                return false;
            }
            String id = this.getLoginObjectId(obj);
            request.setAttribute(Constants.CAS_FILTER_USER_TOKEN, token);
            request.setAttribute(Constants.CAS_FILTER_USER_OBJ, obj);
            request.setAttribute(Constants.CAS_FILTER_USER_OBJID, id);
            return true;
        }
        catch (Exception e)
        {
            CasLog.error("验证用户是否登录：验证用户是否登录异常", e);
        }
        return false;
    }

    @Override
    public void destroy()
    {

    }

    /**
     * 重定向至登录页
     * 
     * @param request
     * @param response
     */
    private void sendRedirect(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            String url = request.getRequestURL().toString();
            if (request.getQueryString() != null)
            {
                url += "?" + request.getQueryString();
            }
            url = URLEncoder.encode(url, "utf-8");
            if (this.passportUrl.indexOf("?") == -1)
            {
                response.sendRedirect(this.passportUrl + "?service=" + url);
            }
            else
            {
                response.sendRedirect(this.passportUrl + "&service=" + url);
            }
        }
        catch (Exception e)
        {
            CasLog.error("重定向至登录页：重定向至登录页异常", e);
        }
    }

    /**
     * 获取登录对象主键
     * @param o
     * @return
     */
    private String getLoginObjectId(Object o)
    {
        String id = null;
        if (o instanceof PersonalLoginInfo)
        {
            id = ((PersonalLoginInfo) o).getPersonalInfo().getUserId();
        }
        else if (o instanceof ShopLoginInfo)
        {
            id = ((ShopLoginInfo) o).getShopAndUserInfo().getShopId();
        }
        else if (o instanceof MisLoginInfo)
        {
            id = ((MisLoginInfo) o).getLoginId();
        }
        return id;
    }

}