package com.gooagoo.cms.utils;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.casclient.mis.MisLoginInfo;
import com.gooagoo.entity.casclient.mis.MisZTreeNode;
import com.gooagoo.entity.casclient.personal.PersonalLoginInfo;
import com.gooagoo.entity.casclient.shop.ShopAuth;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.google.gson.Gson;

public class AuthUtil
{

    /**
     * 营销管理根节点权限编码
     */
    public final static String AUTH_CODE_MARKETING_ROOT = "1";
    /**
     * 商家用户退出调用地址在缓存中的key
     */
    public final static String PASSPORT_SHOP_LOGOUT_KEY = "server_shop_logout_url";
    /**
     * mis用户退出调用地址在缓存中的key
     */
    public final static String PASSPORT_MIS_LOGOUT_KEY = "server_mis_logout_url";
    /**
     * mis系统访问调用地址在缓存中的key
     */
    public final static String MIS_LOGIN_KEY = "server_mis_url";

    /**
     * 核查用户是否有访问指定url的权限，并往Attribute中传递登录类型
     * @param request
     * @return
     */
    public static boolean checkAuthUrl(HttpServletRequest request)
    {
        String url = AuthUtil.getRequestUrl(request);//访问路径
        Object loginInfo = request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);
        String loginType = "";
        String loginName = "";
        boolean isOk = false;

        if (loginInfo instanceof ShopLoginInfo)
        {
            loginType = "S";
            loginName = ((ShopLoginInfo) loginInfo).getShopAndUserInfo().getShopNickName();
            isOk = AuthUtil.checkAuthUrlByShop(url, (ShopLoginInfo) loginInfo);
            String marketingUrl = AuthUtil.getFirstUserAuthUrlOnMarketing((ShopLoginInfo) loginInfo);
            String shopLogout = GmsConfigCache.get(PASSPORT_SHOP_LOGOUT_KEY);
            request.setAttribute("marketing_url", marketingUrl);
            request.setAttribute("shop_logout", shopLogout);
        }
        else if (loginInfo instanceof PersonalLoginInfo)
        {
            loginType = "P";
            loginName = ((PersonalLoginInfo) loginInfo).getPersonalInfo().getAccount();
            isOk = AuthUtil.checkAuthUrlByPerson(url, (PersonalLoginInfo) loginInfo);
        }
        else if (loginInfo instanceof MisLoginInfo)
        {
            loginType = "M";
            loginName = ((MisLoginInfo) loginInfo).getLoginId();
            isOk = AuthUtil.checkAuthUrlByMis(url, (MisLoginInfo) loginInfo);
            String misLogout = GmsConfigCache.get(PASSPORT_MIS_LOGOUT_KEY);
            String misUrl = GmsConfigCache.get(MIS_LOGIN_KEY);
            request.setAttribute("mis_logout", misLogout);
            request.setAttribute("mis_url", misUrl);
        }

        request.setAttribute("loginType", loginType);
        request.setAttribute("loginName", loginName);

        return isOk;
    }

    /**
     * 核查商家用户是否有访问指定url的权限
     * @param url 访问路径
     * @param loginInfo 登录信息
     * @return
     */
    public static boolean checkAuthUrlByShop(String url, ShopLoginInfo loginInfo)
    {
        List<ShopAuth> authList = loginInfo.getShopAuthList();
        for (Iterator<ShopAuth> iterator = authList.iterator(); iterator.hasNext();)
        {
            ShopAuth shopAuth = iterator.next();
            String note = shopAuth.getNote();
            String link = shopAuth.getLink();

            if (!StringUtils.hasText(url))
            {
                GooagooLog.warn("url=" + url);
                return false;
            }
            if (StringUtils.hasText(link) && link.endsWith(url))
            {
                GooagooLog.debug("link:url=" + url + ",auth=" + new Gson().toJson(shopAuth));
                return shopAuth.isUserOwn();
            }
            if (StringUtils.hasText(note) && ("," + note + ",").indexOf("," + url + ",") > -1)
            {
                GooagooLog.debug("note:url=" + url + ",auth=" + new Gson().toJson(shopAuth));
                return shopAuth.isUserOwn();
            }
        }
        return true;
    }

    /**
     * 核查个人用户是否有访问指定url的权限
     * @param url 访问路径
     * @param loginInfo 登录信息
     * @return
     */
    public static boolean checkAuthUrlByPerson(String url, PersonalLoginInfo loginInfo)
    {
        return false;
    }

    /**
     * 核查mis后台用户是否有访问指定url的权限
     * @param url 访问路径
     * @param loginInfo 登录信息
     * @return
     */
    public static boolean checkAuthUrlByMis(String url, MisLoginInfo loginInfo)
    {
        String authCode = "";
        List<MisZTreeNode> authList = loginInfo.getAllShopAuthorities();
        for (Iterator<MisZTreeNode> iterator = authList.iterator(); iterator.hasNext();)
        {
            MisZTreeNode auth = iterator.next();
            String note = auth.getNote();
            String link = auth.getUrl();
            if (!StringUtils.hasText(url))
            {
                GooagooLog.warn("url=" + url);
                return false;
            }
            if (StringUtils.hasText(link) && link.indexOf(url) > -1)
            {
                authCode = auth.getId();
                break;
            }
            if (StringUtils.hasText(note) && ("," + note + ",").indexOf("," + url + ",") > -1)
            {
                authCode = auth.getId();
                break;
            }
        }
        if (StringUtils.hasText(authCode))
        {
            return checkUserAuthByMis(authCode, loginInfo.getAuthorities());
        }
        return true;
    }

    /**
     * 核查用户是否有访问权限
     * @param request
     * @return
     */
    public static boolean checkAuthID(HttpServletRequest request, String authorityID)
    {
        Object loginInfo = request.getAttribute(com.gooagoo.casclient.constants.Constants.CAS_FILTER_USER_OBJ);

        boolean isOk = false;
        if (loginInfo instanceof ShopLoginInfo)
        {
            isOk = AuthUtil.checkAuthIDByShop(authorityID, (ShopLoginInfo) loginInfo);
        }
        else if (loginInfo instanceof PersonalLoginInfo)
        {
            isOk = AuthUtil.checkAuthIDByPerson(authorityID, (PersonalLoginInfo) loginInfo);
        }
        else if (loginInfo instanceof MisLoginInfo)
        {
            isOk = AuthUtil.checkAuthIDByMis(authorityID, (MisLoginInfo) loginInfo);
        }
        return isOk;
    }

    /**
     * 核查商家用户是否有访问权限
     * @param authorityID 权限编码
     * @param loginInfo 登录信息
     * @return
     */
    public static boolean checkAuthIDByShop(String authorityID, ShopLoginInfo loginInfo)
    {
        if (loginInfo != null && loginInfo.getShopAuthList() != null)
        {
            for (Iterator<ShopAuth> iterator = loginInfo.getShopAuthList().iterator(); iterator.hasNext();)
            {
                ShopAuth sa = iterator.next();
                if (sa.getAuthorityId().equals(authorityID))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 核查个人用户是否有访问权限
     * @param authorityID 权限编码
     * @param loginInfo 登录信息
     * @return
     */
    public static boolean checkAuthIDByPerson(String authorityID, PersonalLoginInfo loginInfo)
    {
        return true;
    }

    /**
     * 核查mis后台用户是否有访问权限
     * @param authorityID 权限编码
     * @param loginInfo 登录信息
     * @return
     */
    public static boolean checkAuthIDByMis(String authorityID, MisLoginInfo loginInfo)
    {
        return checkUserAuthByMis(authorityID, loginInfo.getAuthorities());
    }

    /**
     * 获取用户的访问路径（参数只截取method）
     * @param request
     * @return
     */
    public static String getRequestUrl(HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        String query = request.getQueryString();
        if (!StringUtils.hasText(query))
        {
            if (!StringUtils.hasText(requestURI))
            {
                return request.getRequestURL().toString();
            }
            if (requestURI.endsWith("/"))
            {
                requestURI = requestURI.substring(0, requestURI.length() - 1);
            }
            return requestURI;
        }
        String[] paras = query.split("&");
        String para = "";
        for (int i = 0; i < paras.length; i++)
        {
            if (paras[i].startsWith("method="))
            {
                para = paras[i];
                break;
            }
        }
        if (StringUtils.hasText(para))
        {
            para = "?" + para;
        }
        else
        {
            query = "";
        }
        String url = requestURI + para;
        return url;
    }

    /**
     * 检查此权限编码是否是用户拥有的
     * @param code
     * @param userAuths
     * @return
     */
    private static boolean checkUserAuthByMis(String code, List<MisZTreeNode> userAuths)
    {
        if (userAuths == null)
        {
            return false;
        }
        for (Iterator<MisZTreeNode> iterator = userAuths.iterator(); iterator.hasNext();)
        {
            MisZTreeNode misZTreeNode = iterator.next();
            if (misZTreeNode.getId().equals(code))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 通过父节点获取用户权限中第一个子节点权限的访问路径
     * @param parentCode
     * @param authList
     * @return
     */
    private static String getFirstUserAuthUrlOnMarketing(ShopLoginInfo shopLoginInfo)
    {
        String url = null;
        if (shopLoginInfo == null)
        {
            return null;
        }
        ShopAuth auth = getFirstUserAuthorityByParentCode(AUTH_CODE_MARKETING_ROOT, shopLoginInfo.getShopAuthList());
        url = getUrlByAuth(true, auth);
        return url;
    }

    /**
     * 通过父节点获取用户权限中第一个子节点权限
     * @param parentCode
     * @param authList
     * @return
     */
    private static ShopAuth getFirstUserAuthorityByParentCode(String parentCode, List<ShopAuth> authList)
    {
        ShopAuth auth = null;
        if (authList == null || !StringUtils.hasText(parentCode))
        {
            return auth;
        }
        for (ShopAuth shopAuthority : authList)
        {
            if (shopAuthority.isUserOwn() && parentCode.equals(shopAuthority.getParentAuthorityId()))
            {
                auth = shopAuthority;
                break;
            }
        }
        return auth;
    }

    /**
     * 获取权限的访问路径
     * @param isTopMenu 是否是菜单权限，是则从Link中取连接地址时取不到会去note中第一个路径
     * @param auth
     * @return
     */
    private static String getUrlByAuth(boolean isTopMenu, ShopAuth auth)
    {
        String url = null;
        if (auth == null)
        {
            return null;
        }
        url = auth.getLink();
        if (isTopMenu && !org.springframework.util.StringUtils.hasText(url))
        {
            url = auth.getNote();
            if (url == null)
            {
                return null;
            }
            int i = url.indexOf(",");
            if (i > 0)
            {
                url = url.substring(0, i);
            }
        }
        if (!org.springframework.util.StringUtils.hasText(url))
        {
            return null;
        }
        return url;
    }
}
