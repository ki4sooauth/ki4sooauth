package com.gooagoo.gas.api.service;

import com.gooagoo.entity.generator.shop.DeviceAssistant;
import com.gooagoo.entity.generator.shop.ShopUserInfo;

public interface ShopUserInfoGasService
{
    /**
     * 根据店员登录账号获取店员信息
     * 涉及到店员登录账号的存在与否的基本校验
     * @param shopUserId 店员登录账号
     * @return 店员信息
     * @throws Exception
     */
    public ShopUserInfo getShopUserInfo(String shopUserId) throws Exception;

    /**
     * 根据店员助理设备mac地址获取店员设备mac地址
     * 涉及到了店员助理设备的mac地址存在与否的基本校验
     * @param mac 店员设备mac地址
     * @return 店员助理设备信息
     * @throws Exception
     */
    public DeviceAssistant getDeviceAssistant(String mac) throws Exception;
}
