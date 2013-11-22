package com.gooagoo.api.protecteds.core.shop;

import com.gooagoo.entity.generator.shop.ShopInfo;

public interface ShopProtectedCoreService
{

    /**
     * 校验商家状态是否正常
     * 包括商家ID是否为空，商家是否存在，商家是否已正常营业
     * 只有商家正常营业才返回true
     * @param shopId
     * @return
     */
    public boolean checkShopStatus(String shopId);

    /**
     * 获取状态正常的商家信息
     * 状态正常的条件：商家存在、未删除、正常营业
     * 只有满足上述条件才返回UserInfo对象，否则返回NULL
     * @param shopId
     * @return
     */
    public ShopInfo getNormalShopInfo(String shopId);

    /**
     * 获取lidBase
     * 根据商家ID、lid获取lidBase
     * 若lid不在商家名下或lid未传入，则返回商家名下最小的lidbase（lidbase最小表示总店）
     * @param shopId
     * @param lid
     */
    public String getLidBase(String shopId, String lid);

    /**
     * 获得实体店最小lid
     * @param shopEntityId
     * @return
     */
    public String getShopEntityLidBase(String shopEntityId);

    /**
     * 定位实体店
     * 根据商家ID、实体店lid定位实体店
     * 若lid不在商家名下或lid未传入，则返回商家名下lidbase最小（lidbase最小表示总店）的实体店编号
     * @param shopId
     * @param lid
     * @return
     */
    public String getShopEntity(String shopId, String lid);

    /**
     * 通过实体店编号和桌号获取转发器Mac地址
     * @param shopEntityId
     * @param tableName
     * @return
     */
    public String getTransponderMac(String shopEntityId, String tableName);

}
