package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.entity.casclient.shop.ShopLoginInfo;

public interface ShopLoginService
{

    /**
     * 获取用户登录信息
     * @param token    
     * @return ShopDetailInfo
     * @throws Exception
     */
    public ShopLoginInfo getShopLoginInfo(String token) throws Exception;

    /**
     * 获取用户登录信息
     * @param request    
     * @return ShopDetailInfo
     * @throws Exception
     */
    public ShopLoginInfo getShopLoginInfo(HttpServletRequest request) throws Exception;

}
