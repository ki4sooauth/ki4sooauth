package com.gooagoo.igms.shopinfo.service;

import com.gooagoo.view.gms.shopinfo.FDeviceWifisensor;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.FShopInfo;
import com.gooagoo.view.gms.shopinfo.FShopLidDetail;
import com.gooagoo.view.gms.shopinfo.FShopPosition;
import com.gooagoo.view.gms.shopinfo.FShopRole;
import com.gooagoo.view.gms.shopinfo.FShopUserInfo;
import com.gooagoo.view.gms.shopinfo.FTableInfo;
import com.gooagoo.view.gms.shopinfo.FTranspcInfo;
import com.gooagoo.view.gms.shopinfo.FWifiInfo;

public interface IShopInfoCacheService
{
    /**
     * 查询商家信息 
     * @return
     * @throws Exception
     */
    public FShopInfo getFShopInfo(String shopId) throws Exception;

    /**
     * 查询商家实体店信息
     * @return
     * @throws Exception
     */
    public FShopEntityInfo getShopEntityInfo(String shopEntityId) throws Exception;

    /**
     * 查询lid分配表详细信息
     * @param shopLidDetailId
     * @return
     * @throws Exception
     */
    public FShopLidDetail getFShopLidDetail(String shopLidDetailId) throws Exception;

    /**
     * 查询位置详细信息
     * @param  positionId
     * @return
     * @throws Exception
     */
    public FShopPosition getFShopPosition(String positionId) throws Exception;

    /**
     * 查询角色详细信息
     * @param shopRoleId
     * @return
     * @throws Exception
     */
    public FShopRole getFShopRole(String shopRoleId) throws Exception;

    /**
     *  查询商家用户详细
     * @param  shopUserId
     * @return
     * @throws Exception
     */
    public FShopUserInfo getFShopUserInfo(String shopUserId) throws Exception;

    /**
     * 查询桌号详细信息
     * @param tableId
     * @return
     * @throws Exception
     */
    public FTableInfo getFTableInfo(String tableId) throws Exception;

    /**
     * 查询转发器详细信息
     * @param transpcInfoId
     * @return
     * @throws Exception
     */
    public FTranspcInfo getFTranspcInfo(String transpcInfoId) throws Exception;

    /**
     * 查询wifi详细信息
     * @param wifiId
     * @return
     * @throws Exception
     */
    public FWifiInfo getFWifiInfo(String wifiId) throws Exception;

    /**
     * 查询wifi详细信息
     * @param wifiId
     * @return
     * @throws Exception
     */
    public FDeviceWifisensor getWifisensor(String wifiId) throws Exception;
}
