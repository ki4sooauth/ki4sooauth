package com.gooagoo.core.protecteds.shop;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.shop.ShopEntityInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopLidInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopTableInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.shop.ShopProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopLidInfo;
import com.gooagoo.entity.generator.shop.ShopLidInfoExample;
import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;

@Service
public class ShopProtectedCoreServiceImpl implements ShopProtectedCoreService
{

    @Autowired
    private ShopInfoGeneratorCoreService shopInfoGeneratorCoreService;

    @Autowired
    private ShopEntityInfoGeneratorCoreService shopEntityInfoGeneratorCoreService;

    @Autowired
    private ShopLidInfoGeneratorCoreService shopLidInfoGeneratorCoreService;

    @Autowired
    private ShopTableInfoGeneratorCoreService shopTableInfoGeneratorCoreService;

    @Override
    public boolean checkShopStatus(String shopId)
    {
        if (StringUtils.isBlank(shopId))
        {
            GooagooLog.info("校验商家状态是否正常：商家ID（" + shopId + "）为空");
            return false;
        }
        ShopInfo shopInfo = this.shopInfoGeneratorCoreService.selectByPrimaryKey(shopId);
        if (shopInfo == null || "Y".equals(shopInfo.getIsDel()))
        {
            GooagooLog.info("校验商家状态是否正常：商家（" + shopId + "）不存在或被删除");
            return false;
        }
        if ("U".equals(shopInfo.getShopStatus()))
        {
            return true;
        }
        else
        {
            GooagooLog.info("校验商家状态是否正常：商家（" + shopId + "|" + shopInfo.getShopStatus() + "）处于锁定状态或待营业状态");
            return false;
        }
    }

    @Override
    public ShopInfo getNormalShopInfo(String shopId)
    {
        ShopInfo shopInfo = this.shopInfoGeneratorCoreService.selectUnDelByPrimaryKey(shopId);
        if (shopInfo == null || "Y".equals(shopInfo.getIsDel()))
        {
            GooagooLog.info("获取状态正常的商家信息：商家（" + shopId + "）不存在或已被删除");
            return null;
        }
        if ("U".equals(shopInfo.getShopStatus()))
        {
            return shopInfo;
        }
        else
        {
            GooagooLog.info("获取状态正常的商家信息：商家（" + shopId + "|" + shopInfo.getShopStatus() + "）处于锁定状态或待营业状态");
            return null;
        }
    }

    @Override
    public String getLidBase(String shopId, String lid)
    {
        //1、校验入参
        if (StringUtils.isBlank(shopId))
        {
            GooagooLog.info("获取LID基本信息：商家编号（" + shopId + "）为空");
            return null;
        }
        //2、获取商家名下总店
        String shopEntityId = null;
        ShopEntityInfoExample queryCondition1 = new ShopEntityInfoExample();
        queryCondition1.createCriteria().andShopIdEqualTo(shopId).andIsGeneralEqualTo("Y").andIsDelEqualTo("N");
        List<ShopEntityInfo> shopEntityInfoList = this.shopEntityInfoGeneratorCoreService.selectByExample(queryCondition1);
        if (CollectionUtils.isNotEmpty(shopEntityInfoList))
        {
            shopEntityId = shopEntityInfoList.get(0).getShopEntityId();
        }
        //3、获取商家名下总店的lidbase
        String lidBase = null;
        if (shopEntityId != null)
        {
            ShopLidInfoExample queryCondition2 = new ShopLidInfoExample();
            queryCondition2.createCriteria().andShopIdEqualTo(shopId).andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
            List<ShopLidInfo> shopLidInfoList = this.shopLidInfoGeneratorCoreService.selectByExample(queryCondition2);
            if (CollectionUtils.isNotEmpty(shopLidInfoList))
            {
                lidBase = shopLidInfoList.get(0).getLidBase();
            }
        }
        //4、根据lid获取lidbase
        if (StringUtils.isEmpty(lid) || lid.length() < 6)
        {
            return lidBase;
        }
        ShopLidInfo shopLidInfo = this.shopLidInfoGeneratorCoreService.selectByPrimaryKey(lid.substring(0, 6));
        if (shopLidInfo == null || "Y".equals(shopLidInfo.getIsDel()) || !shopId.equals(shopLidInfo.getShopId()))
        {
            GooagooLog.info("获取LID基本信息：商家（" + shopId + "）名下无LID（" + lid + "）");
            return lidBase;
        }

        return shopLidInfo.getLidBase();
    }

    @Override
    public String getShopEntity(String shopId, String lid)
    {
        //1、校验入参
        if (StringUtils.isBlank(shopId))
        {
            GooagooLog.info("定位实体店：商家编号（" + shopId + "）为空");
            return null;
        }
        //2、获取商家名下总店
        String shopEntityId = null;
        ShopEntityInfoExample queryCondition = new ShopEntityInfoExample();
        queryCondition.createCriteria().andShopEntityIdEqualTo(shopId).andIsGeneralEqualTo("Y").andIsDelEqualTo("N");
        List<ShopEntityInfo> shopEntityInfoList = this.shopEntityInfoGeneratorCoreService.selectByExample(queryCondition);
        if (CollectionUtils.isNotEmpty(shopEntityInfoList))
        {
            shopEntityId = shopEntityInfoList.get(0).getShopEntityId();
        }
        //3、根据lid定位实体店
        if (StringUtils.isEmpty(lid) || lid.length() < 6)
        {
            return shopEntityId;
        }
        ShopLidInfo shopLidInfo = this.shopLidInfoGeneratorCoreService.selectByPrimaryKey(lid.substring(0, 6));
        if (shopLidInfo == null || "Y".equals(shopLidInfo) || !shopId.equals(shopLidInfo.getShopId()))
        {
            GooagooLog.info("定位实体店：商家（" + shopId + "）名下无LID（" + lid + "）");
            return shopEntityId;
        }

        return shopLidInfo.getShopEntityId();
    }

    @Override
    public String getTransponderMac(String shopEntityId, String tableName)
    {
        String mac = null;
        ShopTableInfoExample shopTableInfoExample = new ShopTableInfoExample();
        shopTableInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andTableNameEqualTo(tableName).andIsDelEqualTo("N");
        List<ShopTableInfo> shopTableInfoList = this.shopTableInfoGeneratorCoreService.selectByExample(shopTableInfoExample);
        if (CollectionUtils.isNotEmpty(shopTableInfoList))
        {
            mac = shopTableInfoList.get(0).getMac();
        }
        return mac;
    }

    @Override
    public String getShopEntityLidBase(String shopEntityId)
    {
        if (StringUtils.isNotBlank(shopEntityId))
        {
            ShopLidInfoExample shopLidInfoExample = new ShopLidInfoExample();
            shopLidInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
            shopLidInfoExample.setOrderByClause("lid_base");
            List<ShopLidInfo> ShopLidInfoList = this.shopLidInfoGeneratorCoreService.selectByExample(shopLidInfoExample);
            if (CollectionUtils.isNotEmpty(ShopLidInfoList))
            {
                return ShopLidInfoList.get(0).getLidBase();
            }
        }
        return null;
    }

}
