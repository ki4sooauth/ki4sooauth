package com.gooagoo.common.gms.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.utils.GMSAuthUtil;
import com.gooagoo.common.gms.utils.GMSServiceUtil;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.gms.utils.ShopAuthority;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;

/**
 * 商家权限过滤器
 */
public class ShopAuthorityFilter implements Filter
{
    /**
     * 商家权限过滤
     */
    @Override
    public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain fc) throws ServletException, IOException
    {

        HttpServletRequest request = (HttpServletRequest) servletrequest;
        HttpServletResponse response = (HttpServletResponse) servletresponse;

        ShopLoginInfo shopInfo = GMSUtil.getShopLoginInfoByWeb(request);
        String baseUrl = GmsConfigCache.get(GMSConstant.HTML_URL_HEAD_KEY);
        //往页面传登录信息，变量采用简称
        request.setAttribute("shopVo", shopInfo);
        request.setAttribute("imgPath", baseUrl);
        request.setAttribute("basePath", request.getContextPath() + "/");

        String url = ShopAuthority.getRequestUrl(request);//访问路径
        Map<String, String> data = new HashMap<String, String>();//数据存储
        if (ShopAuthority.checkAuthUrl(shopInfo, url, data))
        {
            fc.doFilter(request, response);
        }
        else
        {
            //商家营销一级菜单没有权限，跳转到其他有权限的一级菜单
            String filterParentAuthCode = data.get(GMSConstant.MAP_KEY_AUTH_CODE);
            String toUrl = GMSAuthUtil.getFirstUserAuthUrlByParentCode(filterParentAuthCode, shopInfo);
            if (StringUtils.hasText(toUrl))
            {
                response.sendRedirect(toUrl);
                return;
            }
            //没有权限
            toUrl = GMSServiceUtil.getDefaultDirectUrlByNoAuth();
            if (StringUtils.hasText(toUrl))
            {
                response.sendRedirect(toUrl);
            }
            else
            {
                response.getWriter().println("");
            }
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