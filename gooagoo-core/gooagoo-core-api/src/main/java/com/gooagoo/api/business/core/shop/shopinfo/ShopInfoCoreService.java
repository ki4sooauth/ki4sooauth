package com.gooagoo.api.business.core.shop.shopinfo;

import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.exception.GooagooException;

public interface ShopInfoCoreService
{

    /**
     * 修改商家基本信息
     * @param ShopInfo 商家基本信息
     * @return true/false
     * @throws Exception
     */
    public boolean updateShopBaseInfo(String token, ShopInfo shopInfo) throws Exception;

    /**
     * 修改商家信息
     * @param shopId 商家编号，唯一，通过UUID产生
     * @param nickName 昵称
     * @param token 登录token值
     * @return true/false
     * @throws GooagooException
     */
    public boolean updateShopInfo(String shopId, String nickName, String token) throws Exception;

    /**
     * 修改头像(logo)
     * @param shopId 商家编号，唯一，通过UUID产生
     * @param url 图片地址
     * @param token 登录token值
     * @return true/false
     * @throws GooagooException
     */
    public boolean updateShopLogo(String shopId, String url, String token) throws Exception;

    /**
     * 修改头像(head)
     * @param shopId 商家编号，唯一，通过UUID产生
     * @param url 图片地址
     * @param token 登录token值
     * @return true/false
     * @throws GooagooException
     */
    public boolean updateShopHead(String shopId, String url, String token) throws Exception;

    /**
     * 正常营业
     * @param shopId
     * @return
     * @throws Exception
     */
    public boolean normalBusiness(String shopId) throws Exception;

}
