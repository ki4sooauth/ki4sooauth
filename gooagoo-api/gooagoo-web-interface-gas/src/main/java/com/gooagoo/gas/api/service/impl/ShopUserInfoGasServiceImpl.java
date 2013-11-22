package com.gooagoo.gas.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gooagoo.api.generator.query.shop.DeviceAssistantGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopUserInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.DeviceAssistant;
import com.gooagoo.entity.generator.shop.DeviceAssistantExample;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.gas.api.service.ShopUserInfoGasService;
import com.gooagoo.gas.common.MessageConst;

public class ShopUserInfoGasServiceImpl implements ShopUserInfoGasService
{
    @Autowired
    private ShopUserInfoGeneratorQueryService shopUserInfoGeneratorQueryService;
    @Autowired
    private DeviceAssistantGeneratorQueryService deviceAssistantGeneratorQueryService;

    @Override
    public ShopUserInfo getShopUserInfo(String shopUserId) throws Exception
    {
        GooagooLog.info("ShopUserInfoGeneratorQueryService-->getShopUserInfo-->入参shopuserId=" + shopUserId);

        ShopUserInfo shopUserInfo = this.shopUserInfoGeneratorQueryService.selectUnDelByPrimaryKey(shopUserId);
        if (shopUserInfo == null)
        {
            GooagooLog.warn("ShopUserInfoGeneratorQueryService-->getShopUserInfo-->userid=" + shopUserId + "信息不存在或已删除");
            throw new Exception(MessageConst.GAS_SHOP_SHOPUSERID_NOT_EXIST_OR_DEL);
        }

        return shopUserInfo;
    }

    @Override
    public DeviceAssistant getDeviceAssistant(String mac) throws Exception
    {
        GooagooLog.info("ShopUserInfoGeneratorQueryService-->getDeviceAssistant-->入参mac=" + mac);

        DeviceAssistantExample deviceAssistantExample = new DeviceAssistantExample();
        deviceAssistantExample.createCriteria().andIsDelEqualTo("N");
        deviceAssistantExample.createCriteria().andDeviceMacEqualTo(mac);
        List<DeviceAssistant> deviceAssistantList = this.deviceAssistantGeneratorQueryService.selectByExample(deviceAssistantExample);
        if (deviceAssistantList == null || deviceAssistantList.size() == 0)
        {
            GooagooLog.warn("ShopUserInfoGeneratorQueryService-->getDeviceAssistant-->mac=" + mac + "店员助理设备信息不存在或已删除");
            throw new Exception(MessageConst.GAS_SHOP_MAC_NOT_EXIST_OR_ERROR);
        }

        return deviceAssistantList.get(0);
    }
}
