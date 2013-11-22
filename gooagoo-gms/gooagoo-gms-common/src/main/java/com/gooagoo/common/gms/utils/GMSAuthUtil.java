package com.gooagoo.common.gms.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.entity.casclient.shop.ShopAuth;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.view.gms.common.FNode;
import com.gooagoo.view.gms.shopinfo.FShopAuthority;
import com.gooagoo.view.gms.shopinfo.GmsLoginInfo;

public class GMSAuthUtil
{

    /**
     * 通过父节点获取子节点
     * @param parentCode
     * @param authList
     * @return
     */
    public static List<FNode> getMenuListByParentCode(String parentCode, List<FShopAuthority> authList)
    {
        List<FNode> nodeList = new ArrayList<FNode>();

        if (!StringUtils.hasText(parentCode) || authList == null)
        {
            return nodeList;
        }
        for (FShopAuthority shopAuthority : authList)
        {
            if (!StringUtils.hasText(shopAuthority.getLink()))
            {
                continue;
            }
            if (parentCode.equals(shopAuthority.getParentAuthorityId()))
            {
                nodeList.add(convertFShopAuthorityToFNode(shopAuthority));
            }
        }

        return nodeList;
    }

    /**
     * 获取兄弟节点列表
     * @param menuCode
     * @param authList
     * @return
     */
    public static List<FNode> getBrotherMenuList(String menuCode, List<FShopAuthority> authList)
    {
        List<FNode> nodeList = new ArrayList<FNode>();
        FShopAuthority menu = GMSAuthUtil.getCurMenuByCode(menuCode, authList);

        if (menu != null)
        {
            nodeList = getMenuListByParentCode(menu.getParentAuthorityId(), authList);
        }

        return nodeList;
    }

    /**
     * 将FShopAuthority转换成FNode对象
     * @param authList
     * @return
     */
    public static FNode convertFShopAuthorityToFNode(FShopAuthority shopAuthority)
    {
        if (shopAuthority == null)
        {
            return null;
        }
        FNode node = new FNode();
        node.setCode(shopAuthority.getAuthorityId());
        node.setIcon(shopAuthority.getLink());
        node.setName(shopAuthority.getAuthorityName());
        node.setParentCode(shopAuthority.getParentAuthorityId());
        return node;
    }

    /**
     * 通过父级编码获取下级菜单
     * @param parentCode
     * @param level(权限编码的位数)
     * @return
     */
    public static List<FNode> getMenuList(String parentCode, List<FShopAuthority> authList, int level)
    {
        List<FNode> menus = new ArrayList<FNode>();
        if (!StringUtils.hasText(parentCode) || authList == null)
        {
            return menus;
        }
        for (FShopAuthority shopAuthority : authList)
        {
            if (!StringUtils.hasText(shopAuthority.getLink()))
            {
                continue;
            }
            if (shopAuthority.getAuthorityId().length() != level)
            {
                continue;
            }
            if (parentCode.equals(shopAuthority.getParentAuthorityId()))
            {
                menus.add(convertFShopAuthorityToFNode(shopAuthority));
            }
        }

        return menus;
    }

    /**
     * 获取指定权限菜单
     * @param code
     * @param authList
     * @return
     */
    public static FShopAuthority getCurMenuByCode(String code, List<FShopAuthority> authList)
    {
        FShopAuthority auth = null;
        if (authList == null || !StringUtils.hasText(code))
        {
            return auth;
        }
        for (FShopAuthority shopAuthority : authList)
        {
            if (code.equals(shopAuthority.getAuthorityId()))
            {
                auth = shopAuthority;
                break;
            }
        }
        return auth;
    }

    /**
     * 获取商家权限列表
     * @return
     */
    public static List<FShopAuthority> getAuthList(GmsLoginInfo shopInfo)
    {
        List<FShopAuthority> authList = new ArrayList<FShopAuthority>();

        if (shopInfo == null)
        {
            return authList;
        }

        authList = shopInfo.getAuthList();

        return authList;
    }

    /**
     * 通过父节点获取用户权限中第一个子节点权限
     * @param parentCode
     * @param authList
     * @return
     */
    public static ShopAuth getFirstUserAuthorityByParentCode(String parentCode, List<ShopAuth> authList)
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
     * 通过父节点获取用户权限中第一个子节点权限的访问路径
     * @param parentCode
     * @param authList
     * @return
     */
    public static String getFirstUserAuthUrlByParentCode(String parentAuthCode, ShopLoginInfo shopLoginInfo)
    {
        String url = null;
        boolean isTopMenu = false;
        if (GMSConstant.AUTH_CODE_MARKETING_ROOT.equals(parentAuthCode))
        {
            isTopMenu = true;
        }
        if (shopLoginInfo == null)
        {
            return null;
        }
        ShopAuth auth = getFirstUserAuthorityByParentCode(parentAuthCode, shopLoginInfo.getShopAuthList());
        url = getUrlByAuth(isTopMenu, auth);
        return url;
    }

    /**
     * 获取权限的访问路径
     * @param isTopMenu 是否是菜单权限，是则从Link中取连接地址时取不到会去note中第一个路径
     * @param auth
     * @return
     */
    public static String getUrlByAuth(boolean isTopMenu, ShopAuth auth)
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

    /**
     * 获取权限map
     * @param parentCode
     * @param authList
     * @return
     */
    public static Map<String, String> getAuthUrlMap(boolean isTopMenu, List<ShopAuth> authList)
    {
        Map<String, String> map = new HashMap<String, String>();

        if (authList == null)
        {
            return map;
        }
        for (ShopAuth shopAuthority : authList)
        {
            String url = getUrlByAuth(isTopMenu, shopAuthority);
            if (!StringUtils.hasText(url))
            {
                url = "javascript:void(0);";
            }
            map.put(shopAuthority.getAuthorityId(), url);
        }
        return map;
    }
}
