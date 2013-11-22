package com.gooagoo.igms.shopinfo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.DeviceTransponderGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.DeviceWifisensorGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopLidDetailGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopRoleAuthorityGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopTableInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopUserInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopWifiinfoGeneratorQueryService;
import com.gooagoo.entity.generator.shop.DeviceTransponder;
import com.gooagoo.entity.generator.shop.DeviceWifisensor;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopLidDetail;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopRoleAuthority;
import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfo;
import com.gooagoo.entity.generator.shop.ShopWifiinfo;
import com.gooagoo.igms.shopinfo.service.IShopInfoCacheService;
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

@Service("iShopInfoCacheService")
public class IShopInfoCacheServiceImp implements IShopInfoCacheService
{
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoQueryService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityQueryService;
    @Autowired
    private ShopLidDetailGeneratorQueryService shopLidQueryService;
    @Autowired
    private ShopPositionGeneratorQueryService positionQueryService;
    @Autowired
    private ShopRoleAuthorityGeneratorQueryService authQueryService;
    @Autowired
    private ShopUserInfoGeneratorQueryService shopUserQueryService;
    @Autowired
    private ShopTableInfoGeneratorQueryService tableQueryService;
    @Autowired
    private DeviceTransponderGeneratorQueryService transponderQueryService;
    @Autowired
    private ShopWifiinfoGeneratorQueryService wifiInfoQueryService;
    @Autowired
    private DeviceWifisensorGeneratorQueryService wifisensorQueryService;

    @Override
    public FShopInfo getFShopInfo(String shopId) throws Exception
    {
        ShopInfo shopInfo = this.shopInfoQueryService.selectByPrimaryKey(shopId);
        FShopInfo fShopInfo = new FShopInfo();
        BeanUtils.copyProperties(shopInfo, fShopInfo);
        StringBuffer stringBuffer = new StringBuffer();
        if (!shopInfo.getLogo1().isEmpty())
        {
            stringBuffer.append(shopInfo.getLogo1());
        }
        else
        {
            stringBuffer.append(" ");
        }
        stringBuffer.append(",");
        if (!shopInfo.getLogo2().isEmpty())
        {
            stringBuffer.append(shopInfo.getLogo2());
        }
        else
        {
            stringBuffer.append(" ");
        }
        fShopInfo.setLogo(stringBuffer.toString());

        return fShopInfo;
    }

    @Override
    public FShopEntityInfo getShopEntityInfo(String shopEntityId) throws Exception
    {
        ShopEntityInfo shopEntityInfo = this.shopEntityQueryService.selectByPrimaryKey(shopEntityId);
        FShopEntityInfo entityInfo = new FShopEntityInfo();
        BeanUtils.copyProperties(shopEntityInfo, entityInfo);
        return entityInfo;
    }

    @Override
    public FShopLidDetail getFShopLidDetail(String shopLidDetailId) throws Exception
    {
        ShopLidDetail lid = this.shopLidQueryService.selectByPrimaryKey(shopLidDetailId);
        FShopLidDetail fShopLidDetail = new FShopLidDetail();
        BeanUtils.copyProperties(lid, fShopLidDetail);
        return fShopLidDetail;
    }

    @Override
    public FShopPosition getFShopPosition(String positionId) throws Exception
    {
        ShopPosition shopPosition = this.positionQueryService.selectByPrimaryKey(positionId);
        FShopPosition fShopPosition = new FShopPosition();
        BeanUtils.copyProperties(shopPosition, fShopPosition);
        return fShopPosition;
    }

    @Override
    public FShopRole getFShopRole(String shopRoleId) throws Exception
    {
        ShopRoleAuthority shopRoleAuthority = this.authQueryService.selectByPrimaryKey(shopRoleId);
        FShopRole fShopRole = new FShopRole();
        BeanUtils.copyProperties(shopRoleAuthority, fShopRole);
        return fShopRole;
    }

    @Override
    public FShopUserInfo getFShopUserInfo(String shopUserId) throws Exception
    {
        ShopUserInfo shopUserInfo = this.shopUserQueryService.selectByPrimaryKey(shopUserId);
        FShopUserInfo fShopUserInfo = new FShopUserInfo();
        BeanUtils.copyProperties(shopUserInfo, fShopUserInfo);
        return fShopUserInfo;
    }

    @Override
    public FTableInfo getFTableInfo(String tableId) throws Exception
    {
        ShopTableInfo shopTableInfo = this.tableQueryService.selectByPrimaryKey(tableId);
        FTableInfo fTableInfo = new FTableInfo();
        BeanUtils.copyProperties(shopTableInfo, fTableInfo);
        fTableInfo.setTableType(shopTableInfo.getTableTypeCode());
        fTableInfo.setTableNo(shopTableInfo.getTableName());
        return fTableInfo;
    }

    @Override
    public FTranspcInfo getFTranspcInfo(String transpcInfoId) throws Exception
    {
        DeviceTransponder transponder = this.transponderQueryService.selectByPrimaryKey(transpcInfoId);
        FTranspcInfo fTranspcInfo = new FTranspcInfo();
        BeanUtils.copyProperties(transponder, fTranspcInfo);

        return fTranspcInfo;
    }

    @Override
    public FWifiInfo getFWifiInfo(String wifiId) throws Exception
    {
        ShopWifiinfo wifiinfo = this.wifiInfoQueryService.selectByPrimaryKey(wifiId);
        FWifiInfo fWifiInfo = new FWifiInfo();
        BeanUtils.copyProperties(wifiinfo, fWifiInfo);
        return fWifiInfo;
    }

    @Override
    public FDeviceWifisensor getWifisensor(String wifiId) throws Exception
    {
        DeviceWifisensor wifisensor = this.wifisensorQueryService.selectByPrimaryKey(wifiId);
        FDeviceWifisensor fDeviceWifisensor = new FDeviceWifisensor();
        BeanUtils.copyProperties(wifisensor, fDeviceWifisensor);
        return fDeviceWifisensor;
    }

}
