package com.gooagoo.api.business.query.shop.auth;

import java.util.List;

import com.gooagoo.entity.casclient.shop.ShopAuth;
import com.gooagoo.entity.generator.shop.ShopAuthority;

public interface ShopAuthorityQueryService
{

    /**
     * 获取商家权限
     * @param shopId 商家编号
     * @return
     */
    public List<ShopAuthority> getShopAuthorities(String shopId);

    /**
     * 获取商家用户（店员）权限
     * @param shopId 商家编号
     * @param shopUserId 店员编号
     * @param isShopAccount 是否为商家帐号，Y-是，N-否
     * @return
     */
    public List<ShopAuth> getShopUserAuthorities(String shopId, String shopUserId, String isShopAccount);

    /**
     * 获取商家用户（登陆）权限
     * @param shopId 商家编号
     * @param shopUserId 店员编号
     * @param isShopAccount 是否为商家帐号，Y-是，N-否
     * @return
     */
    public List<ShopAuth> getShopUserLoginAuthorities(String shopId, String shopUserId, String isShopAccount);

}
