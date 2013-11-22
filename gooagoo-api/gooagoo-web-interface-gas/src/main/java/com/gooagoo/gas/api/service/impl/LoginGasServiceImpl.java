package com.gooagoo.gas.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.shop.position.ShopPositionQueryService;
import com.gooagoo.api.business.query.shop.user.ShopUserLoginQueryService;
import com.gooagoo.api.generator.query.shop.DeviceAssistantGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.shop.position.ShopUserPositionBusiness;
import com.gooagoo.entity.casclient.shop.ShopAndUserInfo;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.shop.DeviceAssistant;
import com.gooagoo.entity.generator.shop.DeviceAssistantExample;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.LoginGasService;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.entity.gasa01.transform.LoginRoot;
import com.gooagoo.gas.entity.gasa01.transform.Shopuserposition;
import com.google.gson.Gson;

@Service
public class LoginGasServiceImpl implements LoginGasService
{
    @Autowired
    private ShopUserLoginQueryService shopUserLoginQueryService;
    @Autowired
    private DeviceAssistantGeneratorQueryService deviceAssistantGeneratorQueryService;
    @Autowired
    private ShopPositionQueryService shopPositionQueryService;

    @Override
    public LoginRoot Login(String mac, String shopUserId, String password) throws Exception
    {
        GooagooLog.info("Login-->入参:mac=" + mac + ",shopUserId=" + shopUserId + ",password=" + password);

        //1.校验店员助理mac地址是否存在
        DeviceAssistantExample deviceAssistantExample = new DeviceAssistantExample();
        deviceAssistantExample.createCriteria().andDeviceMacEqualTo(mac).andIsDelEqualTo("N");
        List<DeviceAssistant> deviceAssistantList = this.deviceAssistantGeneratorQueryService.selectByExample(deviceAssistantExample);
        if (deviceAssistantList == null || deviceAssistantList.size() == 0)
        {
            GooagooLog.warn("店员助理mac地址：" + mac + "不存在或已删除");
            throw new MessageException(MessageConst.GAS_SHOP_MAC_NOT_EXIST_OR_ERROR);
        }

        GooagooLog.debug("根据mac：" + mac + "获取到的店员助理设备信息为:" + deviceAssistantList.get(0).toString());

        String shopEntityId = deviceAssistantList.get(0).getShopEntityId();
        //2.校验店员助理登录账号和密码是否正确
        ShopLoginInfo shopLoginInfo = this.shopUserLoginQueryService.login(shopUserId, password, null);
        ShopAndUserInfo shopAndUserInfo = shopLoginInfo.getShopAndUserInfo();
        GooagooLog.debug("根据店员登录账号：" + shopUserId + "获取到的店员助理相关信息为:" + new Gson().toJson(shopAndUserInfo));

        //3.校验店员助理mac地址与店员助理登录账号是不是归属于同一家实体店(实体店级别的店员登录需进行此校验)
        if (StringUtils.hasText(shopAndUserInfo.getUserShopEntityId()) && !shopEntityId.equals(shopAndUserInfo.getUserShopEntityId()))
        {
            GooagooLog.warn("店员助理mac地址：" + mac + "和店员助理账号：" + shopUserId + "所属实体店不一致");
            throw new MessageException(MessageConst.GAS_SHOP_NOT_BELONG_THE_SAME_SHOPENTITY);
        }
        //4.登录通过后，查询店员所属区域信息,并封装店员所属区域信息
        List<ShopUserPositionBusiness> shopUserPositionBusinessList = this.shopPositionQueryService.getPositionOfShopUser(shopAndUserInfo.getShopId(), shopAndUserInfo.getUserShopEntityId(), shopAndUserInfo.getUserBrand());
        List<Shopuserposition> shopuserposition = null;
        if (CollectionUtils.isNotEmpty(shopUserPositionBusinessList))
        {
            shopuserposition = new ArrayList<Shopuserposition>();
            for (ShopUserPositionBusiness shopUserPositionBusiness : shopUserPositionBusinessList)
            {
                Shopuserposition tempShopuserposition = new Shopuserposition();
                tempShopuserposition.setShopuserentityid(shopUserPositionBusiness.getShopEntityId());
                tempShopuserposition.setShopuserentityname(shopUserPositionBusiness.getShopEntityName());
                tempShopuserposition.setPositionid(shopUserPositionBusiness.getPositionId());
                shopuserposition.add(tempShopuserposition);
            }
        }
        //5.封装返回数据
        LoginRoot root = new LoginRoot();
        root.setRealname(shopAndUserInfo.getUserName() != null ? shopAndUserInfo.getUserName() : "");
        root.setShopid(shopAndUserInfo.getShopId());
        root.setShopentityid(shopAndUserInfo.getUserShopEntityId());
        root.setShopuserid(shopUserId);
        root.setHeadpic(shopAndUserInfo.getUserHeadImg());
        root.setShopuserposition(shopuserposition);
        return root;
    }
}
